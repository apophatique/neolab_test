package io.neolab.internship.chessbasicmodel.piece.factory;

import io.neolab.internship.chessbasicmodel.piece.pieces.IPiece;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * This class implements IPieceFactory interface and is needed to create new pieces.
 */
public class PieceFactory implements IPieceFactory {
    private PieceClassesRepository pieceClassesRepository;

    /**
     * Constructor of the class, where we declare the PieceRepository instance.
     */
    public PieceFactory() {
        pieceClassesRepository = new PieceClassesRepository();
    }

    /**
     * This method creates and transfers an IPiece instances in according to the input piece game symbol.
     *
     * @param pieceName {@link Character} input piece name.
     * @return IPiece instance.
     */
    @Override
    public IPiece createPiece(final Character pieceName) {
        Class<? extends IPiece> pieceClass = pieceClassesRepository.getPieceClass(pieceName);
        try {
            Constructor<? extends IPiece> constructor = pieceClass.getConstructor();
            return constructor.newInstance();
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
