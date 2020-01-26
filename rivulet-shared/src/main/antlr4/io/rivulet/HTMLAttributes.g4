/* [The "BSD licence"]
 * Copyright (c) 2013 Tom Everett
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *
 * Based on the ANTLR4 example grammar for HTML (https://github.com/antlr/grammars-v4/tree/master/html), original
 * @author Tom Everett. */

grammar HTMLAttributes;

@header {
    import java.util.LinkedList;
}

@parser::members {
  public LinkedList<String[]> attributes = new LinkedList<>();
}

@lexer::members {
  @Override
  public void notifyListeners(LexerNoViableAltException e) {
    throw new ParseCancellationException();
  }

  @Override
  public void recover(LexerNoViableAltException e) {
    throw new ParseCancellationException();
  }
}

parse
: TAG_OPEN NAME attribute* TAG_CLOSE {if(true) throw new io.rivulet.internal.EndOfAttributeException();}
| EOF
;

attribute
: NAME '=' value {attributes.add(new String[]{$NAME.text, $value.text});}
| NAME {attributes.add(new String[]{$NAME.text, null});}
;

value
: VALUE
| NAME
;

TAG_OPEN
: '<'
;

TAG_CLOSE
: '/>'
| '>'
;

fragment
NAME_START
: [a-zA-Z]
| '\u2070'..'\u218F'
| '\u2C00'..'\u2FEF'
| '\u3001'..'\uD7FF'
| '\uF900'..'\uFDCF'
| '\uFDF0'..'\uFFFD'
;

fragment
NAME_CHAR
: NAME_START
| '-'
| '_'
| '.'
| [0-9]
| '\u00B7'
| '\u0300'..'\u036F'
| '\u203F'..'\u2040'
;

NAME
: NAME_START NAME_CHAR*
;

VALUE
: '\'' (~'\'')* '\''
| '"' (~'"')* '"'
| (~[ \t\r\n\f"'`=<>])+
;

WHITESPACE
: [ \t\r\n\f] -> skip
;

OTHER
: .+?
;

