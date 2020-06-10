package io.neolab.internship.romannumeralsconverter;

import io.neolab.internship.romannumeralsconverter.converter.RomanSystemConverterException;
import io.neolab.internship.romannumeralsconverter.converter.RomanSystemConverter;

import java.util.Scanner;

/**
 *  Main class.
 */
public class Main {
    /**
     * Main function where we can see the Roman system converter work
     *
     * @param args - command line arguments.
     */
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
            System.out.print("\nConvert an integer number to it's Roman system implementation (it should be: 0 < X <= 2.147.483.647)\n" +
                            "Input: ");
        final int input = in.nextInt();


        try {
            final String output = RomanSystemConverter.getRomeNum(input);
            System.out.format("\nOutput: %s\n", output);
        } catch (RomanSystemConverterException e) {
            e.printStackTrace();
        }
    }

    private Main() {}
}
