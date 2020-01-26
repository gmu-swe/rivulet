grammar BasicSQL;

@header {
    import java.util.LinkedList;
}

@parser::members {
  private StringBuilder codeBuilder = new StringBuilder();
  public LinkedList<String> code = new LinkedList<>();
  public LinkedList<String> commented = new LinkedList<>();
  public LinkedList<String> quoted  = new LinkedList<>();

  private void resetBuilder() {
    if(codeBuilder.length() != 0) {
      code.add(codeBuilder.toString());
      codeBuilder = new StringBuilder();
    }
  }
}

parse
: text parse
| EOF {resetBuilder();}
;

text
: commented {resetBuilder(); commented.add($commented.text);}
| quoted {resetBuilder(); quoted.add($quoted.text);}
| unquoted {codeBuilder.append($unquoted.text);}
;

commented
: (MULTILINE_COMMENT | SINGLE_LINE_COMMENT)
;

quoted
: (DOUBLE_QUOTE_STRING | SINGLE_QUOTE_STRING | BACKTICK_STRING)
;

unquoted
: OTHER+
;

MULTILINE_COMMENT
: '/*' .*? ('*/' | EOF)
;

SINGLE_LINE_COMMENT
: ('--' | '#') ~[\r\n]* (('\r'? '\n') | EOF)
;

DOUBLE_QUOTE_STRING
: '"' ('\\'. | '""' | ~( '"' | '\\'))* ('"' | EOF)
;

SINGLE_QUOTE_STRING
: '\'' ('\\'. | '\'\'' | ~( '\'' | '\\'))* ('\'' | EOF)
;

BACKTICK_STRING
: '`' ('\\'. | '``' | ~( '`' | '\\'))* ('`' | EOF)
;

OTHER
: .
;