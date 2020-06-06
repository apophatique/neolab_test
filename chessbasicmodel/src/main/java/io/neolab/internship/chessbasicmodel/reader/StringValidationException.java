package io.neolab.internship.chessbasicmodel.reader;

/**
 * This class presents exception class, that can be thrown during input string validation.
 */
public class StringValidationException extends Exception {

    /**
     * Class constructor with an error message.
     *
     * @param message {@link String} thrown message.
     */
    public StringValidationException(final String message) {
        super(message);
    }
}
