package io.rivulet.internal.rerun;

import io.rivulet.converter.ForcedTypeConverter;
import io.rivulet.internal.IndexedSourceInfoTaintLabel;
import io.rivulet.internal.SourceInfoTaintLabel;
import io.rivulet.internal.TaintedStringBuilder;

import java.util.Arrays;

/* Stores information about a single value that should be used to a replace values being tainted at source methods with
 * labels that meet certain criteria. */
public class ReplacementImpl extends Replacement {

    private static final long serialVersionUID = 3232281521139859502L;
    // The number of characters of a replacement value that should be printed before truncating the value
    private static final int MAX_REPLACEMENT_VALUE_LENGTH = 150;

    // The object that should be used to replace the value being tainted, must be non-null
    private final Object replacementValue;
    // The baseSource that the label should match, must be non-null
    private final String targetedBaseSource;
    // The actualSourceClass that the label should match, or null if the label can have any actualSourceClass
    private final String targetedActualSourceClass;
    // The sourceArgIndex that the label should match, or ANY_INT if the label can have any sourceArgIndex
    private final int targetedSourceArgIndex;
    // The sourceValueClass that the label should match, or null if the label can have any sourceValueClass
    private final Class<?> targetedSourceValueClass;
    // The sorted array of invocation ids that the label's indexInfo should match at least one of or null if the label
    // can have any invocation id
    private final int[] targetedInvocationIDs;
    // The forced type converter that should be used to convert the replacementValue to the original value's type, or null
    // if any converter can be used.
    private final ForcedTypeConverter converter;

    /* Constructs a new ReplacementImpl with the specified value that only replaces values that match the specified label. */
    protected ReplacementImpl(Object replacementValue, SourceInfoTaintLabel label, ForcedTypeConverter converter, boolean required, int[] targetedInvocationIDs) {
        super(required);
        this.replacementValue = replacementValue;
        this.targetedBaseSource = label.getBaseSource();
        this.targetedActualSourceClass = label.getActualSourceClass();
        this.targetedSourceArgIndex = label.getSourceArgIndex();
        this.targetedSourceValueClass = label.getSourceValueClass();
        this.converter = converter;
        this.targetedInvocationIDs = targetedInvocationIDs;
        if(targetedInvocationIDs != null) {
            Arrays.sort(targetedInvocationIDs);
        }
    }

    /* Constructs a new ReplacementImpl with the specified values. */
    protected ReplacementImpl(Object replacementValue, String targetedBaseSource, String targetedActualSourceClass, int targetedSourceArgIndex,
                              Class<?> targetedSourceValueClass, ForcedTypeConverter converter, boolean required, int[] targetedInvocationIDs) {
        super(required);
        this.replacementValue = replacementValue;
        this.targetedBaseSource = targetedBaseSource;
        this.targetedActualSourceClass = targetedActualSourceClass;
        this.targetedSourceArgIndex = targetedSourceArgIndex;
        this.targetedSourceValueClass = targetedSourceValueClass;
        this.converter = converter;
        this.targetedInvocationIDs = targetedInvocationIDs;
        if(targetedInvocationIDs != null) {
            Arrays.sort(targetedInvocationIDs);
        }
    }

    /* Getter for targetedBaseSource. */
    public String getTargetedBaseSource() {
        return targetedBaseSource;
    }

    /* Getter for targetedActualSourceClass. */
    public String getTargetedActualSourceClass() {
        return targetedActualSourceClass;
    }

    /* Getter for targetedSourceArgIndex. */
    public int getTargetedSourceArgIndex() {
        return targetedSourceArgIndex;
    }

    /* Getter for targetedSourceValueClass. */
    public Class<?> getTargetedSourceValueClass() {
        return targetedSourceValueClass;
    }

    /* Getter for converter. */
    public ForcedTypeConverter getConverter() {
        return converter;
    }

    /* Getter for targetedInvocationIDs. */
    public int[] getTargetedInvocationIDs() {
        return targetedInvocationIDs;
    }

    @Override
    public ForcedTypeConverter getConverter(Class<?> targetType, SourceInfoTaintLabel label) {
        return converter;
    }

    @Override
    public Object getReplacementValue(Class<?> targetType, SourceInfoTaintLabel label) {
        return replacementValue;
    }

    /* Returns whether the specified label meets all of the criteria for this replacement and whether this instance's
     * replacementValue can be forcibly converted to the specified type. */
    @Override
    public boolean isApplicable(Class<?> targetType, SourceInfoTaintLabel label) {
        return meetsCriteria(label) && super.isApplicable(targetType, label);
    }

    /* Returns whether the specified label meets all of the criteria for this replacement. */
    private boolean meetsCriteria(SourceInfoTaintLabel label) {
        if(targetedBaseSource != null && !targetedBaseSource.equals(label.getBaseSource())) {
            return false;
        } else if(targetedActualSourceClass != null && !targetedActualSourceClass.equals(label.getActualSourceClass())) {
            return false;
        } else if(targetedSourceArgIndex != ANY_INT && targetedSourceArgIndex != label.getSourceArgIndex()) {
            return false;
        } else if(targetedSourceValueClass != null && !targetedSourceValueClass.equals(label.getSourceValueClass())) {
            return false;
        } else if(targetedInvocationIDs == null || targetedInvocationIDs.length == 0) {
            return true;
        } else if(!(label instanceof IndexedSourceInfoTaintLabel)) {
            // Invocation information is not available to be checked against
            return true;
        } else {
            int labelID = ((IndexedSourceInfoTaintLabel) label).getIndexInfoCopy().getInvocationID();
            for(int id : targetedInvocationIDs) {
                if(labelID == id) {
                    return true;
                }
            }
            return false;
        }
    }

    /* Returns a text representation of this instance. */
    @Override
    public String toString() {
        String criteriaString = targetedBaseSource;
        if(targetedActualSourceClass != null) {
            criteriaString = targetedActualSourceClass + "." + targetedBaseSource.substring(targetedBaseSource.indexOf(".")+1);
        }
        if(targetedSourceArgIndex != ANY_INT) {
            criteriaString += "(arg=" + targetedSourceArgIndex + ")";
        }
        if(targetedInvocationIDs != null) {
            criteriaString += "(ids=" + Arrays.toString(targetedInvocationIDs) + ")";
        }
        if(converter == null) {
            return String.format("Replacement: {%s -> %s}", criteriaString, TaintedStringBuilder.formatTaintedValue(replacementValue));
        } else {
            return String.format("Replacement: {%s -> %s with %s}", criteriaString, TaintedStringBuilder.formatTaintedValue(replacementValue), converter);
        }
    }

    /* Returns a shallow copy of this replacement. */
    public ReplacementImpl copy() {
        int[] invocationIDsCopy = targetedInvocationIDs == null ? null : targetedInvocationIDs.clone();
        ReplacementImpl copy =new ReplacementImpl(replacementValue, targetedBaseSource, targetedActualSourceClass, targetedSourceArgIndex,
                targetedSourceValueClass, converter, isRequired(), invocationIDsCopy);
        copy.setSuccessful(isSuccessful());
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        if(!super.equals(o)) return false;

        ReplacementImpl that = (ReplacementImpl) o;

        if(targetedSourceArgIndex != that.targetedSourceArgIndex) return false;
        if(replacementValue != null ? !replacementValue.equals(that.replacementValue) : that.replacementValue != null)
            return false;
        if(targetedBaseSource != null ? !targetedBaseSource.equals(that.targetedBaseSource) : that.targetedBaseSource != null)
            return false;
        if(targetedActualSourceClass != null ? !targetedActualSourceClass.equals(that.targetedActualSourceClass) : that.targetedActualSourceClass != null)
            return false;
        if(targetedSourceValueClass != null ? !targetedSourceValueClass.equals(that.targetedSourceValueClass) : that.targetedSourceValueClass != null)
            return false;
        if(!Arrays.equals(targetedInvocationIDs, that.targetedInvocationIDs)) return false;
        return converter != null ? converter.equals(that.converter) : that.converter == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (replacementValue != null ? replacementValue.hashCode() : 0);
        result = 31 * result + (targetedBaseSource != null ? targetedBaseSource.hashCode() : 0);
        result = 31 * result + (targetedActualSourceClass != null ? targetedActualSourceClass.hashCode() : 0);
        result = 31 * result + targetedSourceArgIndex;
        result = 31 * result + (targetedSourceValueClass != null ? targetedSourceValueClass.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(targetedInvocationIDs);
        result = 31 * result + (converter != null ? converter.hashCode() : 0);
        return result;
    }

    /* Returns whether this replacement cannot successfully occur in the same rerun as the specified other replacement. */
    public boolean hasConflict(ReplacementImpl other) {
        if(targetedBaseSource != null ? !targetedBaseSource.equals(other.targetedBaseSource) : other.targetedBaseSource != null) {
            return false;
        } else if(targetedActualSourceClass != null ? !targetedActualSourceClass.equals(other.targetedActualSourceClass) : other.targetedActualSourceClass != null) {
            return false;
        } else if(targetedSourceArgIndex != other.targetedSourceArgIndex && targetedSourceArgIndex != ANY_INT && other.targetedSourceArgIndex != ANY_INT) {
            return false;
        } if(targetedInvocationIDs == null || other.targetedInvocationIDs == null) {
            return true;
        } else {
            // Check if their targeted IDs overlap at all
            for(int i : targetedInvocationIDs) {
                for(int j : other.targetedInvocationIDs) {
                    if(i == j) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override
    public String toString(int indent) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < indent; i++) {
            builder.append("\t");
        }
        String indentStr = builder.toString();
        builder = new StringBuilder();
        builder.append(indentStr).append("{\n");
        // Add criteria line
        builder.append(indentStr).append('\t').append("criteria: ");
        if(targetedActualSourceClass != null) {
            builder.append(targetedActualSourceClass).append('.').append(targetedBaseSource.substring(targetedBaseSource.indexOf(".")+1));
        } else {
            builder.append(targetedBaseSource);
        }
        if(targetedSourceArgIndex != ANY_INT) {
            builder.append("(arg=").append(targetedSourceArgIndex).append(')');
        }
        if(targetedInvocationIDs != null) {
            builder.append("(ids=").append(Arrays.toString(targetedInvocationIDs)).append(')');
        }
        builder.append("\n");
        // Add replacement line
        String formattedReplacement = TaintedStringBuilder.formatTaintedValue(replacementValue).replaceAll("\n", "\\\\n");
        formattedReplacement = formattedReplacement.replaceAll("\t", "\\\\t").replaceAll("\r", "\\\\r");
        if( formattedReplacement.length() > MAX_REPLACEMENT_VALUE_LENGTH) {
            formattedReplacement =  formattedReplacement.substring(0, MAX_REPLACEMENT_VALUE_LENGTH) + "...";
        }
        builder.append(indentStr).append('\t').append("replacement: ").append( formattedReplacement).append("\n");
        // Add converter line
        if(converter != null) {
            builder.append(indentStr).append('\t').append("converter: ").append(converter).append("\n");
        }
        return builder.append(indentStr).append('}').toString();
    }
}
