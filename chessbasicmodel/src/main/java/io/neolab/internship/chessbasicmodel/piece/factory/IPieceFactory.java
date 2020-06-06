package io.neolab.internship.chessbasicmodel.piece.factory;

import io.neolab.internship.chessbasicmodel.piece.pieces.IPiece;

/**
 * This interface presents an instance for the creating a new command instance in according to last written lexeme name
 * and current state.
 */
public interface IPieceFactory {
    /**
     * This method transfers a piece in according to the input piece name and color.
     *
     * @param pieceName {@link Character} input piece name.
     * @return IPiece instance.
     */
    IPiece createPiece(final Character pieceName);
}
