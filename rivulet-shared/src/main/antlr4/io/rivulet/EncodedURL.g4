/* Source: https://tools.ietf.org/html/rfc3986 */
grammar EncodedURL;

parse
: percentEncodedChar parse
| plusEncodedSpace parse
| unencodedChars parse
| EOF
;

percentEncodedChar
: value=PERCENT_ENCODED_CHAR
;

plusEncodedSpace
: value=PLUS
;

unencodedChars
: value=CHARS
;

PERCENT_ENCODED_CHAR
: ('%' [0-9a-fA-F] [0-9a-fA-F])+
;

PLUS
: '+'
;

CHARS
: ~[+%]+
| .
;