package io.neolab.internship.romannumeralsconverter.converter;


import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Class that contains a map needed to return numerals representation in Roman system.
 */
public class RomanSystemMap {
    private Map<Integer, String> numeralsMap;

    private static final int NUMERAL_ONE = 1;
    private static final int NUMERAL_FOUR = 4;
    private static final int NUMERAL_FIVE = 5;
    private static final int NUMERAL_NINE = 9;
    private static final int NUMERAL_TEN = 10;
    private static final int NUMERAL_FORTY = 40;
    private static final int NUMERAL_FIFTY = 50;
    private static final int NUMERAL_NINETY = 90;
    private static final int NUMERAL_ONE_HUNDRED = 100;
    private static final int NUMERAL_FOUR_HUNDRED = 400;
    private static final int NUMERAL_FIVE_HUNDRED = 500;
    private static final int NUMERAL_NINE_HUNDRED = 900;
    private static final int NUMERAL_ONE_THOUSAND = 1000;
    private static final int NUMERAL_FOUR_THOUSAND = 4000;
    private static final int NUMERAL_FIVE_THOUSAND = 5000;
    private static final int NUMERAL_NINE_THOUSAND = 9000;

    /**
     * The class constructor, where numeralsMap is created and filled in with
     * pairs of (numeral; it's representation in Roman system)
     */
    public RomanSystemMap() {
        numeralsMap = new TreeMap<Integer, String>(Collections.reverseOrder()) {
            {
                put(NUMERAL_ONE, "I");
                put(NUMERAL_FOUR, "IV");
                put(NUMERAL_FIVE, "V");
                put(NUMERAL_NINE, "IX");
                put(NUMERAL_TEN, "X");
                put(NUMERAL_FORTY, "XL");
                put(NUMERAL_FIFTY, "L");
                put(NUMERAL_NINETY, "XC");
                put(NUMERAL_ONE_HUNDRED, "C");
                put(NUMERAL_FOUR_HUNDRED, "CD");
                put(NUMERAL_FIVE_HUNDRED, "D");
                put(NUMERAL_NINE_HUNDRED, "CM");
                put(NUMERAL_ONE_THOUSAND, "M");
                put(NUMERAL_FOUR_THOUSAND, "M" + "V\u0305");
                put(NUMERAL_FIVE_THOUSAND, "V\u0305");
                put(NUMERAL_NINE_THOUSAND, "M" + "X\u0305");
            }
        };
    }

    /**
     * Function to return numeral representation in Roman system.
     *
     * @param key {@link Integer} numeral key.
     * @return {@link String} numeral representation in Roman system.
     */
    public String getValue(final int key) {
        return numeralsMap.get(key);
    }

    /**
     * Function to return TreeMap keys.
     *
     * @return Set of the keys.
     */
    public Set<Integer> getKeys() {
        return numeralsMap.keySet();
    }
}