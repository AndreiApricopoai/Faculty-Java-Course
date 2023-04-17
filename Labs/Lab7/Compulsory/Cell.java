package Lab7.Compulsory;

import java.util.List;

public class Cell {
    private List<Token> tokens;

    public Cell() {
        tokens = null;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public boolean isEmpty() {
        return tokens == null;
    }
}
