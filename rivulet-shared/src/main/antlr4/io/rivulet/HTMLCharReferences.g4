/* Source: https://www.w3.org/TR/2011/WD-html5-20110525/syntax.html#character-references */
grammar HTMLCharReferences;

parse
: hexCharRef parse
| decimalCharRef parse
| namedCharRef parse
| unescapedChars parse
| EOF
;

hexCharRef
: value=HEX_CHAR_REF
;

decimalCharRef
: value=DECIMAL_CHAR_REF
;

namedCharRef
: value=NAMED_CHAR_REF
;

unescapedChars
: value=CHARS
;

HEX_CHAR_REF
: '&#' [xX] [0-9a-fA-F]+ ';'?
;

DECIMAL_CHAR_REF
: '&#' [0-9]+ ';'?
;

NAMED_CHAR_REF
: '&' [a-zA-Z0-9]+ ';'?
;

CHARS
: ~[&]+
| .
;