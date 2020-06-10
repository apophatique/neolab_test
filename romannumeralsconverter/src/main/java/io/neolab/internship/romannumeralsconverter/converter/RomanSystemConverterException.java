package io.neolab.internship.romannumeralsconverter.converter;

/**
 * This class presents exception class, that can be thrown during the Lexer Converter work.
 */
public class RomanSystemConverterException extends Exception {

    /**
     * Class constructor with of an error message.
     *
     *
     * @param message {@link String} instance that will be contained in the thrown instance of exception.
     */
    public RomanSystemConverterException(final String message) {
        super(message);
    }
}
