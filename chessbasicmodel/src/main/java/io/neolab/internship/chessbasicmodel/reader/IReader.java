package io.neolab.internship.chessbasicmodel.reader;

/**
 * Interface IReader is needed for the GameMap.
 * It has two methods, one of which checks, if the string has next char,
 *  * and the other get next char in case in exists.
 */
public interface IReader {
    void readString();
    char nextChar(final int i, final int j);
    void validateString();
}
