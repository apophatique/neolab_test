package io.neolab.internship.stringreverse.handler;

/**
 * Class that provides a some concepts be performed on a string.
 */
public final class StringHandler {

    private StringHandler() {

    }
    /**
     * This function reverses a string, skipping all non-alphabetical ones.
     *
     * @param inputStr {@link String} string the function works with.
     * @return {@link String} reverted filtered string.
     */
    public static String revertString(final String inputStr) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = inputStr.length() - 1; i >= 0; i--) {
            char currentChar = inputStr.charAt(i);

            if (Character.isAlphabetic(currentChar)) {
                stringBuilder.append(currentChar);
            }
        }

        return stringBuilder.toString();
    }
}
