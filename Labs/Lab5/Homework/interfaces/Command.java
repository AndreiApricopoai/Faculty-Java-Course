package Lab5.Homework.interfaces;

/**
 * The interface Command.
 *
 * @param <T> the type parameter
 */
public interface Command<T> {

    /**
     * Execute t.
     *
     * @return the t
     * @throws Exception the exception
     */
    public abstract T execute() throws Exception;
}
