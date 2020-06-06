package io.neolab.internship.chessbasicmodel.piece.factory;


import io.neolab.internship.chessbasicmodel.piece.pieces.IPiece;
import io.neolab.internship.chessbasicmodel.piece.pieces.Rook;
import io.neolab.internship.chessbasicmodel.piece.pieces.Knight;
import io.neolab.internship.chessbasicmodel.piece.pieces.King;
import io.neolab.internship.chessbasicmodel.piece.pieces.Bishop;
import io.neolab.internship.chessbasicmodel.piece.pieces.Queen;
import io.neolab.internship.chessbasicmodel.piece.pieces.Pawn;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a repository
 * for getting an IPiece classes (value) in according to input symbol (key).
 */
public class PieceClassesRepository {
    private Map<Character, Class<? extends IPiece>> pieceMap;
    private static final Character KING_PIECE_SYMBOL = 'K';
    private static final Character QUEEN_PIECE_SYMBOL = 'Q';
    private static final Character BISHOP_PIECE_SYMBOL = 'B';
    private static final Character KNIGHT_PIECE_SYMBOL = 'N';
    private static final Character ROOK_PIECE_SYMBOL = 'R';
    private static final Character PAWN_PIECE_SYMBOL = 'P';

    public PieceClassesRepository() {
        pieceMap = new HashMap<>();
        pieceMap.put(KING_PIECE_SYMBOL, King.class);
        pieceMap.put(QUEEN_PIECE_SYMBOL, Queen.class);
        pieceMap.put(BISHOP_PIECE_SYMBOL, Bishop.class);
        pieceMap.put(KNIGHT_PIECE_SYMBOL, Knight.class);
        pieceMap.put(ROOK_PIECE_SYMBOL, Rook.class);
        pieceMap.put(PAWN_PIECE_SYMBOL, Pawn.class);
    }

    /**
     * Get IPiece class by symbol key.
     * @param pieceName IPiece implementation.
     * @return Extended IPiece class
     */
    public Class<? extends IPiece> getPieceClass(final Character pieceName) {
        return pieceMap.get(pieceName);
    }
}
