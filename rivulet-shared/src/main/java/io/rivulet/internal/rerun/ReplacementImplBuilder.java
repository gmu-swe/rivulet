package io.rivulet.internal.rerun;

import io.rivulet.converter.*;
import io.rivulet.internal.ProcessedSourceInfoTaintLabel;
import io.rivulet.internal.SourceInfoTaintLabel;
import io.rivulet.internal.Violation;

import java.util.*;

/* Generates ReplacementImpls based on supplied criteria. */
public class ReplacementImplBuilder implements ReplacementBuilder {

    // The replacementValue that will be used to replace the original value at the source. Must be non-null.
    private Object replacementValue;
    // Targeted baseSource of the label of values at the source that should be replaced. Must be non-null if isPayload is false.
    private String baseSource;
    // Targeted actualSourceClass of the label of values at the source that should be replaced. A null replacementValue indicates
    // that every actualSourceClass should be replaced.
    private String actualSourceClass;
    // Targeted sourceArgIndex of the label of values at the source that should be replaced. A replacementValue of ReplacementImpl.ANY_INT
    // indicates that every sourceArgIndex should be replaced.
    private int sourceArgIndex;
    // Whether the success of a replacement generated by this builder impacts the overall success of a rerun. If isPayload
    // is true and required is true, then a rerun configuration generated with this builder must contain at least one of
    // the replacements generated by this builder.
    private boolean required;
    // Whether this replacement should be bound to a tainted replacementValue that reached the sink during the original run. If this
    // builder's criteria is valid for more than one tainted replacementValue label, then a ReplacementImpl is generated for each
    // distinct qualifying label.
    private boolean isPayload;

    /* Constructs a new ReplacementImplBuilder with all of its fields in their respective accept any replacementValue states. */
    public ReplacementImplBuilder() {
        this.replacementValue = null;
        this.baseSource = actualSourceClass = null;
        this.sourceArgIndex = ReplacementImpl.ANY_INT;
        this.required = false;
        this.isPayload = false;
    }

    /* Sets replacementValue to the specified replacementValue. Returns this builder. */
    public ReplacementImplBuilder value(Object value) {
        this.replacementValue = value;
        return this;
    }

    /* Sets baseSource to the specified replacementValue. Returns this builder. */
    public ReplacementImplBuilder baseSource(String baseSource) {
        this.baseSource = baseSource;
        return this;
    }

    /* Sets actualSourceClass to the specified replacementValue. Returns this builder. */
    public ReplacementImplBuilder actualSourceClass(String actualSourceClass) {
        this.actualSourceClass = actualSourceClass;
        return this;
    }

    /* Sets sourceArgIndex to the specified replacementValue. Returns this builder. */
    public ReplacementImplBuilder sourceArgIndex(int sourceArgIndex) {
        this.sourceArgIndex = sourceArgIndex;
        return this;
    }

    /* Sets required to the specified replacementValue. Returns this builder. */
    public ReplacementImplBuilder required(boolean required) {
        this.required = required;
        return this;
    }

    /* Sets isPayload to the specified replacementValue. Returns this builder. */
    public ReplacementImplBuilder isPayload(boolean isPayload) {
        this.isPayload = isPayload;
        return this;
    }

    /* Getter for isPayload. */
    public boolean isPayload() {
        return isPayload;
    }

    /* Returns whether baseSource is non-null. */
    public boolean hasBaseSource() {
        return baseSource != null;
    }

    /* Returns whether or not at least one replacement generated from this builder must be included in a rerun configuration
     * for the configuration to be considered valid. */
    @Override
    public boolean isRequiredForGeneration() {
        return required && isPayload;
    }

    /* Throws a runtime exception if this builder specifies invalid replacement construction criteria. */
    public void validate() {
        if(replacementValue == null) {
            throw new RuntimeException("Replacements must specify a non-null replacement replacementValue.");
        } else if(baseSource == null && !isPayload) {
            throw new RuntimeException(("Non-payload replacements must specify a baseSource for the replacement to target."));
        } else if(sourceArgIndex < -1 && sourceArgIndex != ReplacementImpl.ANY_INT) {
            throw new RuntimeException(String.format("Replacement cannot target invalid source argument index: %d.", sourceArgIndex));
        }
    }

    /* Returns a set of ReplacementImpls containing all of the valid combinations of generators and, if isPayload is true,
     * label bindings. */
    @Override
    public LinkedHashSet<Replacement> build(Violation violation) {
        validate();
        LinkedHashSet<Replacement> replacements = new LinkedHashSet<>();
        for(SourceInfoTaintLabel label : violation.getAllLabels()) {
            replacements.addAll(generateReplacements(label));
        }
        return replacements;
    }

    /* Returns replacements created based on the specified label and this builder's information. */
    private LinkedHashSet<Replacement> generateReplacements(SourceInfoTaintLabel label) {
        LinkedHashSet<Replacement> replacements = new LinkedHashSet<>();
        if(meetsCriteria(label) || !isPayload) {
            List<ForcedTypeConverter> validConverters = ConversionUtils.getValidConverters(isPayload ? label.getBaseSource() : baseSource);
            for(ForcedTypeConverter converter : validConverters) {
                replacements.addAll(generateReplacements(label, converter));
            }
        }
        return replacements;
    }

    /* Returns replacements created based on the specified label and this builder's information that apply the specified
     * converter first when replacing. */
    private LinkedHashSet<Replacement> generateReplacements(SourceInfoTaintLabel label, ForcedTypeConverter baseConverter) {
        LinkedHashSet<Replacement> replacements = new LinkedHashSet<>();
        if(label instanceof ProcessedSourceInfoTaintLabel && (isPayload || producibleByTargetedSourceClass(label))) {
            // Add replacements with invocation information if it is available and applicable
            ProcessedSourceInfoTaintLabel processedLabel = (ProcessedSourceInfoTaintLabel) label;
            for(int id : processedLabel.getIndexInfoMap().keySet()) {
                // Make one rerun for each invocation id
                addReplacement(replacements, label, baseConverter, new int[]{id});
            }
            if(isPayload) {
                // Add replacements with index and invocation information
                for(int id : processedLabel.getIndexInfoMap().keySet()) {
                    int[] pairs = processedLabel.getIndexInfoMap().get(id).getRangesCopy();
                    for(int i = 0; i < pairs.length; i+=2) {
                        ForcedTypeConverter chainConverter = getChainedRangeConverter(baseConverter, label.getSourceValueClass(), pairs[i], pairs[i+1]);
                        if(chainConverter != null) {
                            // Make one rerun for each range for the id
                            addReplacement(replacements, label, chainConverter, new int[]{id});
                        }
                    }
                }
            }
        }
        if(replacements.isEmpty()) {
            // Add a replacement with no invocation or index information
            addReplacement(replacements, label, baseConverter, null);
        }
        return  replacements;
    }

    /* Adds a new replacement which uses the specified converter and targets the specified invocation ids to the specified
     * set if this is a non-payload builder or the specified converted can be used for this instance's replacement
     * value for the specified label. */
    private void addReplacement(Set<Replacement> replacements, SourceInfoTaintLabel label, ForcedTypeConverter converter, int[] invocationIDs) {
        if(!isPayload) {
            replacements.add(new ReplacementImpl(replacementValue, baseSource, actualSourceClass, sourceArgIndex, null, converter, required, invocationIDs));
        } else if(canConvert(label, converter)) {
            replacements.add(new ReplacementImpl(replacementValue, label, converter, required, invocationIDs));
        }
    }

    /* Returns whether the specified converter can be used to replace something at a source that produces the specified label
     * with this instance's replacement value. */
    private boolean canConvert(SourceInfoTaintLabel label, ForcedTypeConverter converter) {
        if(converter == null) {
            return (label.getFullyReplaceable() && ConversionUtils.canBeForceConverted(label.getSourceValueClass(), replacementValue.getClass()))
                    || ConversionUtils.canBeInPlaceForceConverted(label.getSourceValueClass(), replacementValue.getClass());
        } else {
            return converter.canConvert(label.getSourceValueClass(), replacementValue.getClass()) &&
                    (label.getFullyReplaceable() || converter.isInPlace());
        }
    }

    /* Returns a converter that chains the specified converter to an range converter for the specified type and range or
     * null if valid chained converter cannot be made. */
    private ForcedTypeConverter getChainedRangeConverter(ForcedTypeConverter baseConverter, Class<?> targetType, int start, int end) {
        ForcedTypeConverter rangeConverter =  getRangeConverter(targetType, start, end);
        if(baseConverter == null || rangeConverter == null) {
            // If the base converter is null return a converter to just range convert
            // If the range converter is null return null
            return rangeConverter;
        } else if(baseConverter instanceof TargetIndependentConverter) {
            return ChainedTypeConverter.getInstance((TargetIndependentConverter) baseConverter, rangeConverter);
        } else {
            // Base converter can not be chained
            return null;
        }
    }

    /* Returns the range converter for the specified type and range or null if one does not exist for the specified type. */
    private static ForcedTypeConverter getRangeConverter(Class<?> targetType, int start, int end) {
        if(targetType.equals(String.class)) {
            return new SubstringConverter(start, end);
        } else if(targetType.isArray() && targetType.getComponentType().isPrimitive()) {
            return new SubArrayConverter(start, end);
        }  else {
            return null;
        }
    }

    /* Returns whether the specified label meets all of the criteria for a replacement built from this builder. */
    private boolean meetsCriteria(SourceInfoTaintLabel label) {
        if(baseSource != null && !baseSource.equals(label.getBaseSource())) {
            return false;
        } else if(actualSourceClass != null && !actualSourceClass.equals(label.getActualSourceClass())) {
            return false;
        } else return sourceArgIndex == ReplacementImpl.ANY_INT || sourceArgIndex == label.getSourceArgIndex();
    }

    /* Returns whether the specified label could be produced by the the same source class as the one targeted by the
     * replacements generated by this builder. */
    private boolean producibleByTargetedSourceClass(SourceInfoTaintLabel label) {
        if(actualSourceClass != null) {
            return actualSourceClass.equals(label.getActualSourceClass());
        } else if(baseSource != null && baseSource.contains(".") && label.getBaseSource().contains(".")) {
            String labelBaseSourceClass = label.getBaseSource().substring(0, label.getBaseSource().indexOf('.'));
            String baseSourceClass = baseSource.substring(0, baseSource.indexOf('.'));
            return baseSourceClass.equals(labelBaseSourceClass);
        } else {
            return false;
        }
    }
}
