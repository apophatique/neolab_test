package io.neolab.internship.romannumeralsconverter.converter;

import io.neolab.internship.romannumeralsconverter.pair.Pair;

import java.util.Set;

/**
 * Class that represents an advanced converter for the numbers greater than 10.000.
 */
public final class RomanSystemConverter {
    private static final RomanSystemMap ROMAN_SYSTEM_MAP = new RomanSystemMap();
    private static final Set<Integer> KEYS = ROMAN_SYSTEM_MAP.getKeys();

    private static final String SINGLE_OVERLINE_SYMBOL = "\u0305";
    private static final String DOUBLE_OVERLINE_SYMBOL = "\u033F";
    private static final short ADVANCED_NUMBER_WEIGHT_RATIO = 1000;
    private static final short CONVERTER_INPUT_LIMIT = 10000;
    private static final short FROM_END_TO_PENULTIMATE_CHAR_DISTANCE = 2;
    private static final short NULL = 0;

    private RomanSystemConverter() {

    }

    /**
     * Function for conversation an integer number to it's the Roman system implementation.
     *
     * The function works in two cases:
     * 1. Simple case: if num < 10,000
     * A number can be expressed using base root keys
     * 2. Advanced case: if num >=10,000
     * Each character in the Roman alphabet can be multiplied by 1000 if a line is drawn over it.
     * There can be a maximum of two such lines.
     *
     * @param num input {@link Integer} number to convert.
     * @throws RomanSystemConverterException if number is not positive.
     * @return a {@link String} containing the number represented in roman system.
     */
    public static String getRomeNum(final int num) throws RomanSystemConverterException {
        if (num <= 0) {
            throw new RomanSystemConverterException("A number should be positive");
        }

        int inputNumber = num;
        StringBuilder stringBuilder = new StringBuilder();

        for (Integer key : KEYS) {
            while (inputNumber >= key) {
                if (inputNumber < CONVERTER_INPUT_LIMIT) {
                    stringBuilder.append(ROMAN_SYSTEM_MAP.getValue(key));
                    inputNumber -= key;

                } else {
                    short numberWeightDegree = 0;
                    int inputCopy = inputNumber;

                    while (numberWeightDegree < 2 && inputCopy >= ADVANCED_NUMBER_WEIGHT_RATIO) {
                        numberWeightDegree++;
                        inputCopy /= ADVANCED_NUMBER_WEIGHT_RATIO;
                    }

                    Pair<String, Integer> charInfo = getCharWithOverline(inputCopy, numberWeightDegree);
                    stringBuilder.append(charInfo.getFirst());
                    inputNumber -= charInfo.getSecond() * Math.pow(ADVANCED_NUMBER_WEIGHT_RATIO, numberWeightDegree);
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * This function is needed get a number in the highest order
     * and returns it together with it advanced Roman system implementation.
     *
     * @param inputNumber {@link Integer} without the last 3*n numerals (reducing the number to X<10.000)
     * @param count {@link Integer} - degree of number weight
     * @return {@link Pair} class, contained numbers Roman numeral implementation (string) and numeral in highest position.
     */
    private static Pair<String, Integer> getCharWithOverline(final int inputNumber, final int count) {
        StringBuilder stringBuilder = new StringBuilder();
        int numeralInHighestPosition = 0;

        for (Integer key : KEYS) {
            if (inputNumber >= key) {
                String newEnd = ROMAN_SYSTEM_MAP.getValue(key);

                /*
                    Single line symbol is shown together with the last char.
                    Double line symbol is shown after the last char (offset=1), so i had to append double line symbol at first
                 */
                if (count == 1) {
                    stringBuilder.append(newEnd).append(SINGLE_OVERLINE_SYMBOL);
                } else {
                    stringBuilder.append(DOUBLE_OVERLINE_SYMBOL).append(newEnd);
                }
                /*
                    Some of the numerals are displayed as two chars in Roman system (IV, IX, XL),
                    but unfortunately, the lines only overlap with the last one, so i had to mark both of them.
                 */
                if (newEnd.length() == 2) {
                    String overline = (count == 1) ? SINGLE_OVERLINE_SYMBOL : DOUBLE_OVERLINE_SYMBOL;
                    stringBuilder.insert(stringBuilder.length() - FROM_END_TO_PENULTIMATE_CHAR_DISTANCE, overline);
                }

                numeralInHighestPosition = key;
                break;
            }
        }
        return new Pair<String, Integer>(stringBuilder.toString(), numeralInHighestPosition);
    }
}
