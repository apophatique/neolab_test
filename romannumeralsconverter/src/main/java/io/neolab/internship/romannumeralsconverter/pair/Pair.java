package io.neolab.internship.romannumeralsconverter.pair;

/**
 *  Utility class that allows to combine different objects into pairs.
 *
 * @param <T> - first object type.
 * @param <U> - seconds object type.
 */
public class Pair<T, U> {
    private final T first;
    private final U second;

    /**
     * Class constructor that initializes Pair fields with passed objects.
     *
     * @param first - first object.
     * @param second - second object.
     */
    public Pair(final T first, final U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}
