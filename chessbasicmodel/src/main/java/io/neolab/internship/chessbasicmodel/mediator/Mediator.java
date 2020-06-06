package io.neolab.internship.chessbasicmodel.mediator;

import io.neolab.internship.chessbasicmodel.board.field.Field;
import io.neolab.internship.chessbasicmodel.piece.pieces.IPiece;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Objects;

/**
 * This class provides a wires between a pieces and a fields to avoid their direct connection.
 * Made based on the Singleton.
 */
public final class Mediator {
    private HashMap<Field, IPiece> boardLocationMap;

    private Mediator() {
        boardLocationMap = new HashMap<>();
    }

    /**
     * Static class for creating a Mediator instance.
     */
    private static class MediatorHolder {
        public static final Mediator HOLDER_INSTANCE = new Mediator();
    }

    /**
     * Method for getting singleton Mediator instance.
     * @return {@link Mediator} instance.
     */
    public static Mediator getInstance() {
        return MediatorHolder.HOLDER_INSTANCE;
    }

    /**
     * Creating a new field-piece connectivity.
     * @param field {@link Field} a field the piece is standing on.
     * @param piece {@link IPiece} new piece on the board.
     */
    public void addNewPosition(final Field field, final IPiece piece) {
        boardLocationMap.put(field, piece);
    }

    /**
     * Method for taking a piece by field it is standing on.
     * @param field - a field
     * @return a Piece.
     */
    public IPiece getPiece(final Field field) {
        return boardLocationMap.get(field);
    }

    /**
     * Method for taking all the pieces on the board.
     * @return Pieces on the board list.
     */
    public Collection<IPiece> getPieces() {
        return boardLocationMap.values();
    }

    /**
     * Method for taking a field from boardLocationMap by a piece standing on it.
     * @param piece {@link IPiece} standing on the field.
     * @return {@link Field} instance or null if not found.
     */
    public Field getField(final IPiece piece) {
        Set<Map.Entry<Field, IPiece>> entrySet = boardLocationMap.entrySet();
        for (Map.Entry<Field, IPiece> pair : entrySet) {
            if (Objects.equals(piece, pair.getValue())) {
                return pair.getKey();
            }
        }
        return null;
    }

    /**
     * Method for taking a field from boardLocationMap by row, column coordinates.
     * @param x {@link Integer} row coordinate.
     * @param y {@link Integer} column coordinate.
     * @return {@link Field} a field or null if not found.
     */
    public Field getField(final int x, final int y) {
        Set<Map.Entry<Field, IPiece>> entrySet = boardLocationMap.entrySet();
        for (Map.Entry<Field, IPiece> pair : entrySet) {
            if (pair.getKey().getXCoord() == x && pair.getKey().getYCoord() == y) {
                return pair.getKey();
            }
        }
        return null;
    }
}
