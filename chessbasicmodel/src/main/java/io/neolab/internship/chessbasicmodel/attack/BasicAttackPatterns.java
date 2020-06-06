package io.neolab.internship.chessbasicmodel.attack;

import io.neolab.internship.chessbasicmodel.board.field.Field;
import io.neolab.internship.chessbasicmodel.board.gamemap.GameMap;
import io.neolab.internship.chessbasicmodel.mediator.Mediator;

import java.util.ArrayList;

/**
 * Class that allow to get attack fields on basic pieces moving directions.
 */
public final class BasicAttackPatterns {
    private static int boardSize = GameMap.getInstance().getBoardSize();

    private BasicAttackPatterns() {}

    /**
     * Method for iterating through diagonal directions relative to the piece.
     * @param currentField {@link Field} a piece current location.
     * @return {@link ArrayList} list of the fields the piece attacks.
     */
    public static ArrayList<Field> getDiagonalAttackFields(final Field currentField) {
        ArrayList<Field> possibleAttackFields = new ArrayList<>();

        boolean keepRightDownMove = true;
        boolean keepLeftUpMove = true;
        for (int i = 1; i < boardSize; i++) {
            if (keepRightDownMove && currentField.getXCoord() < boardSize && currentField.getYCoord() < boardSize) {
                keepRightDownMove = actionToAdd(currentField.getXCoord() + i, currentField.getYCoord() + i, possibleAttackFields);
            }

            if (keepLeftUpMove && currentField.getXCoord() > 0 && currentField.getYCoord() > 0) {
                keepLeftUpMove = actionToAdd(currentField.getXCoord() - i, currentField.getYCoord() - i, possibleAttackFields);
            }
        }

        boolean keepRightUpMove = true;
        boolean keepLeftDownMove = true;
        for (int i = 1; i < boardSize; i++) {
            if (keepRightUpMove && currentField.getXCoord() > 0 && currentField.getYCoord() < boardSize) {
                keepRightUpMove = actionToAdd(currentField.getXCoord() - i, currentField.getYCoord() + i, possibleAttackFields);
            }

            if (keepLeftDownMove && currentField.getXCoord() < boardSize && currentField.getYCoord() > 0) {
                keepLeftDownMove = actionToAdd(currentField.getXCoord() + i, currentField.getYCoord() - i, possibleAttackFields);
            }
        }

        return possibleAttackFields;
    }

    /**
     * Method for iterating through horizontal and vertical directions relative to the piece.
     * @param currentField {@link Field} a piece current location.
     * @return {@link ArrayList} list of the fields the piece attacks.
     */
    public static ArrayList<Field> getHorizonVerticalAttackFields(final Field currentField) {
        ArrayList<Field> possibleAttackFields = new ArrayList<>();

        boolean keepRightMove = true;
        boolean keepLeftMove = true;
        for (int i = 1; i < boardSize; i++) {
            if (keepRightMove) {
                keepRightMove = actionToAdd(currentField.getXCoord(), currentField.getYCoord() + i, possibleAttackFields);
            }
            if (keepLeftMove) {
                keepLeftMove = actionToAdd(currentField.getXCoord(), currentField.getYCoord() - i, possibleAttackFields);
            }
        }

        boolean keepUpMove = true;
        boolean keepDownMove = true;
        for (int i = 1; i < boardSize; i++) {
            if (keepUpMove) {
                keepUpMove = actionToAdd(currentField.getXCoord() - i, currentField.getYCoord(), possibleAttackFields);
            }
            if (keepDownMove) {
                keepDownMove = actionToAdd(currentField.getXCoord() + i, currentField.getYCoord(), possibleAttackFields);
            }
        }
        return possibleAttackFields;
    }

    /**
     * Method for iterating through Knight moving pieces..
     * @param currentField {@link Field} a piece current location.
     * @return {@link ArrayList} list of the fields the piece attacks.
     */
    public static ArrayList<Field> getKnightAttackMoves(final Field currentField) {
        ArrayList<Field> possibleAttackFields = new ArrayList<>();
        int[] onesList = new int[] {1, -1};
        int[] twosList = new int[] {2, -2};

        for (int one : onesList) {
            for (int two : twosList) {
                actionToAdd(currentField.getXCoord() + one, currentField.getYCoord() + two, possibleAttackFields);
                actionToAdd(currentField.getXCoord() + two, currentField.getYCoord() + one, possibleAttackFields);
            }
        }

        return possibleAttackFields;
    }

    /**
     * Method for iterating through pawn attack fields.
     * @param currentField {@link Field} a piece current location.
     * @return {@link ArrayList} list of the fields the piece attacks.
     */
    public static ArrayList<Field> getWhitePawnAttackMoves(final Field currentField) {
        ArrayList<Field> possibleAttackFields = new ArrayList<>();
        int[] onesList = new int[] {1, -1};
        for (int one : onesList) {
            actionToAdd(currentField.getXCoord() - 1, currentField.getYCoord() + one, possibleAttackFields);
        }

        return possibleAttackFields;
    }

    /**
     * This method checks if it needed to add a field to the piece's attack list.
     * It checks if the field coordinates are within the dimensions of the Board.
     * If the fields contains some piece that has opposite color, the field added to the list.
     *
     * @param newFieldXCoord {@link Integer} row coordinate of the field being checked
     * @param newFieldYCoord {@link Integer} column coordinate of the field being checked
     * @param possibleMoveList a list where we add the field if it needed.
     * @return boolean value if moving through direction is possible (not covered with another piece).
     */
    private static boolean actionToAdd(final int newFieldXCoord, final int newFieldYCoord, ArrayList<Field> possibleMoveList) {
        if (!(newFieldXCoord >= 0 && newFieldXCoord < boardSize && newFieldYCoord >= 0 && newFieldYCoord < boardSize)) {
           return false;
        }
        Field newField = GameMap.getInstance().getBoardField(newFieldXCoord, newFieldYCoord);
        if (Mediator.getInstance().getPiece(newField) != null) {
            if (Mediator.getInstance().getPiece(newField).getColor().equals("Black")) {   // would be changed during model development.
                possibleMoveList.add(newField);
            }
            return false;
        }
        return true;
    }
}
