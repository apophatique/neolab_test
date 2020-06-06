package io.neolab.internship.chessbasicmodel.piece.pieces;

import io.neolab.internship.chessbasicmodel.board.field.Field;

import java.util.ArrayList;

/**
 * An interface for creating a chess pieces implementations.
 */
public interface IPiece {
    /**
     * Get piece name (King, Queen, Bishop..)
     * @return {@link String} a piece name.
     */
    String getName();

    /**
     * Get piece symbol on the board (K, Q, B..)
     * @return {@link Character} a piece game symbol.
     */
    char getGameSymbol();

    /**
     * Method for getting a field the piece is standing on.
     * @return {@link Field} a Field exemplar.
     */
    Field getField();

    /**
     * Get piece's color (white, black)
     * @return color in string view.
     */
    String getColor();

    /**
     * Define a fields where opponent's pieces are located and which the our piece can attack.
     * @return {@link ArrayList<Field>} fields the piece can attack.
     */
    ArrayList<Field> definePossibleAttackList();
}