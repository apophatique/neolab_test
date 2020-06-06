package io.neolab.internship.timecorrection.time;

/**
 * This class presents exception class, that can be thrown during the TimeHandler work.
 */
public class TimeValidFormatException extends Exception {

    /**
     * Class constructor with an error message.
     *
     * @param message {@link String} thrown message.
     */
    public TimeValidFormatException(final String message) {
        super(message);
    }
}
