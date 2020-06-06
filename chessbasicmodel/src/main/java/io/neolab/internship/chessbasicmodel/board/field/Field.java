package io.neolab.internship.chessbasicmodel.board.field;

import io.neolab.internship.chessbasicmodel.mediator.Mediator;
import io.neolab.internship.chessbasicmodel.piece.pieces.IPiece;

/**
 * Class that is a model for representing a "fields" on a chessboard, which the game map consists of.
 */
public class Field {
    private int xCoord;
    private int yCoord;

    /**
     * The class constructor.
     * @param xCoord {@link Integer} row field coordinate on the board.
     * @param yCoord {@link Integer} column field coordinate on the board.
     */
    public Field(final int xCoord, final int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    /**
     * Get piece that standing on the field.
     * @return {@link IPiece} implementation.
     */

    public boolean isEmpty() {
        return Mediator.getInstance().getPiece(this) == null;
    }

    public IPiece getPiece() {
        return Mediator.getInstance().getPiece(this);
    }

    /**
     * Get row coordinate.
     * @return xCoord attribute.
     */
    public int getXCoord() {
        return xCoord;
    }

    /**
     * Get column coordinate.
     * @return yCoord attribute.
     */
    public int getYCoord() {
        return yCoord;
    }
}
