package Lab7.Compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class SharedMemory {

    private final Queue<Token> tokens;

    public SharedMemory(int n) {
        List<Token> tokenList = new ArrayList<>();
        for (int i = 1; i <= n * n * n; i++) {
            tokenList.add(new Token(i));
        }
        Collections.shuffle(tokenList);
        tokens = new ConcurrentLinkedQueue<>(tokenList);
    }

    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            extracted.add(tokens.poll());
        }
        return extracted;
    }

}
