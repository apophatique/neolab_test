package io.neolab.internship.timecorrection;

import io.neolab.internship.timecorrection.time.TimeHandler;
import io.neolab.internship.timecorrection.time.TimeValidFormatException;

import java.util.Scanner;

/**
 * Main class.
 */
public final class Main {
    /**
     *
     * @param args Command line args.
     */
    public static void main(final String[] args) {
        System.out.print("\nWrite a time (HH:MM:SS): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            String output = TimeHandler.formatDate(input);
            System.out.format("Output: %s\n", output);
        } catch (TimeValidFormatException e) {
            e.printStackTrace();
        }
    }

    private Main() {}
}
