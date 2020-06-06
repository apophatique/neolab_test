package io.neolab.internship.chessbasicmodel.reader;

import io.neolab.internship.chessbasicmodel.board.gamemap.GameMap;

import java.util.Scanner;

/**
 * Class for reading input string from keyboard (by {@link Scanner})
 */
public class ScannerReader implements IReader {
    private Scanner scanner;
    private String inputString;

    public ScannerReader() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void readString() {
        System.out.print("\nWrite pieces location on 4x4 chess board. It must contain one 'K' symbol. String size is 16.");
        System.out.print("\nInput: ");
        inputString = scanner.nextLine();
        validateString();
    }

    @Override
    public char nextChar(final int i, final int j) {
        final int rowLength = GameMap.getInstance().getBoardSize();
        return inputString.charAt(rowLength * i + j);
    }

    /**
     * Method to check if input string matches requirements.
     */
    @Override
    public void validateString() {
        String patternCompileString = "^" +
                "(?=.*K{1})" +
                "[KQBNRP ]{16}" +
                "$";
        if (!inputString.matches(patternCompileString)) {
            try {
                throw new StringValidationException("Input string doesn't matches the requirements");
            } catch (StringValidationException e) {
                e.printStackTrace();
            }
        }
    }
}
