grammar BasicVBScript;

@header {
    import java.util.LinkedList;
}

@parser::members {
  private StringBuilder codeBuilder = new StringBuilder();
  public LinkedList<String> code = new LinkedList<>();
  public LinkedList<String> commented = new LinkedList<>();
  public LinkedList<String> quoted = new LinkedList<>();

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
: SINGLE_LINE_COMMENT
;

quoted
: DOUBLE_QUOTE_STRING
;

unquoted
: OTHER
;

SINGLE_LINE_COMMENT
: '\'' ~[\r\n]* (('\r'? '\n') | EOF)
| REM ([\t ] ~[\r\n]*)? (('\r'? '\n') | EOF)
;

DOUBLE_QUOTE_STRING
: '"' ('""' | ~'"')* ('"'| EOF)
;

REM
:  ('R' | 'r') ('E' | 'e') ('M' | 'm')
;

OTHER
: ~[\r\n\t ] ('R' | 'r') ('E' | 'e') ('M' | 'm')
| ('R' | 'r') ('E' | 'e') ('M' | 'm') ~[\r\n\t ]
| .
;