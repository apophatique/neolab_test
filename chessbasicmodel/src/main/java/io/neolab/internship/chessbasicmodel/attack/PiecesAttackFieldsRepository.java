package io.neolab.internship.chessbasicmodel.attack;

import io.neolab.internship.chessbasicmodel.board.field.Field;
import io.neolab.internship.chessbasicmodel.piece.pieces.IPiece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Repository for storing lists of attacked fields for each piece in the game.
 * Made based on Singleton.
 */
public final class PiecesAttackFieldsRepository {
    private HashMap<IPiece, ArrayList<Field>> attackFieldsMap;

    private PiecesAttackFieldsRepository() {
        attackFieldsMap = new HashMap<>();
    }

    private static class Holder {
        public static final PiecesAttackFieldsRepository HOLDER_INSTANCE = new PiecesAttackFieldsRepository();
    }

    public static PiecesAttackFieldsRepository getInstance() {
        return Holder.HOLDER_INSTANCE;
    }

    /**
     * If new piece has been added on the board, we create new list for it.
     * @param piece new piece.
     */
    public void addNewPiece(final IPiece piece) {
        attackFieldsMap.put(piece, new ArrayList<>());
    }

    /**
     * Method for updating attack fields list if the piece's location has been changed.
     * @param piece a piece that has been moved.
     */
    public void updatePieceAttackList(final IPiece piece) {
        attackFieldsMap.get(piece).clear();
        attackFieldsMap.get(piece).addAll(piece.definePossibleAttackList());
    }

    /**
     * Not necessary for this task.
     * Remove attack fields list if piece was destroyed during the game.
     * @param piece destroyed piece.
     */
    public void removePieceAttackList(final IPiece piece) {
        attackFieldsMap.remove(piece);
    }

    /**
     * Return all the piece's attack lists.
     * @return {@link Set} of the lists.
     */
    public Set<Map.Entry<IPiece, ArrayList<Field>>> getAllAttackLists() {
        return attackFieldsMap.entrySet();
    }
}
