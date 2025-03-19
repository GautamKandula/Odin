package OdinJ;

enum TokenType {
    // Single character Tokens
    LEFT_BRACK, RIGHT_BRACK, LEFT_CURLY, RIGHT_CURLY, COMMA, DOT, MINUS, PLUS, SEMI, SLASH, STAR,

    // 1-2 Character Tokens
    BANG, BANG_EQUAL, EQUAL, EQUAL_EQUAL, GREATER, GREATER_EQUAL, LESS, LESS_EQUAL,

    // Multi Character Tokens
    AND, CLASS, ELSE, FALSE, FUN, FOR, IF, NIL, OR, PRINT, RETURN, SUPER, THIS, TRUE, VAR, WHILE,

    // End of file
    EOF
}