package refactula.micro.futuristic.model;

import java.util.UUID;

public final class Token {
    private final String text;

    public static Token geterate() {
        return new Token(UUID.randomUUID().toString());
    }

    public Token(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        return text != null ? text.equals(token.text) : token.text == null;
    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    @Override
    public String toString() {
        return text;
    }
}
