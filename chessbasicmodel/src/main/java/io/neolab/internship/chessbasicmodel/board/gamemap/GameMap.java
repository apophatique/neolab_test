package io.neolab.internship.chessbasicmodel.board.gamemap;

import io.neolab.internship.chessbasicmodel.board.field.Field;
import io.neolab.internship.chessbasicmodel.mediator.Mediator;
import io.neolab.internship.chessbasicmodel.attack.PiecesAttackFieldsRepository;
import io.neolab.internship.chessbasicmodel.piece.factory.PieceFactory;
import io.neolab.internship.chessbasicmodel.piece.pieces.IPiece;
import io.neolab.internship.chessbasicmodel.reader.IReader;
import io.neolab.internship.chessbasicmodel.reader.ScannerReader;

import java.util.ArrayList;
import java.util.Map;

/**
 * Class that providing a "board" (matrix) model contains a {@link Field} elements inside.
 */
public final class GameMap {
    private final Mediator mediator;
    private final PieceFactory pieceFactory;
    private final PiecesAttackFieldsRepository piecesAttackFieldsRepository;
    private final IReader reader;

    private static Field[][] boardMatrix;
    private final int boardSize = 4;

    private GameMap() {
        mediator = Mediator.getInstance();
        pieceFactory = new PieceFactory();
        piecesAttackFieldsRepository = PiecesAttackFieldsRepository.getInstance();
        reader = new ScannerReader();
    }

    private static class GameMapHolder {
        public static final GameMap HOLDER_INSTANCE = new GameMap();
    }

    /**
     * Get singleton GameMap instance.
     * @return GameMap instance.
     */
    public static GameMap getInstance() {
        return GameMapHolder.HOLDER_INSTANCE;
    }

    /**
     * Method to create a board matrix and fill it with according to input string.
     */
    public void initializeBoardMatrix() {
        boardMatrix = new Field[boardSize][boardSize];
        reader.readString();

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Field newField = new Field(i, j);
                boardMatrix[i][j] = newField;
            }
        }

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Field nextField = boardMatrix[i][j];

                char nextChar = reader.nextChar(i, j);
                if (nextChar != ' ') {
                    IPiece newPiece = pieceFactory.createPiece(nextChar);
                    mediator.addNewPosition(nextField, newPiece);
                    piecesAttackFieldsRepository.addNewPiece(newPiece);
                }
            }
        }

        for (IPiece piece : mediator.getPieces()) {
            piecesAttackFieldsRepository.updatePieceAttackList(piece);
        }
    }

    public void printBoard() {
        System.out.println("Game board:");
        System.out.format("%6d%5d%5d%5d\n\n", 0, 1, 2, 3);

        for (int i = 0; i < boardSize; i++) {
            System.out.format("%d", i);
            for (int j = 0; j < boardSize; j++) {
                if (mediator.getField(i, j) == null) {
                    System.out.format("%5s", " ");
                } else {
                    System.out.format("%5s",  mediator.getPiece(boardMatrix[i][j]).getGameSymbol());
                }
            }
            System.out.print("\n\n");
        }
    }

    /**
     * Method to show the task answer.
     */
    public boolean getBlackKingChecks() {
        short blackKingCheckedCount = 0;
        for (Map.Entry<IPiece, ArrayList<Field>> attackFieldsMap: piecesAttackFieldsRepository.getAllAttackLists()) {
            for (Field field : attackFieldsMap.getValue()) {
                if (mediator.getPiece(field).getName().equals("King")) {
                    blackKingCheckedCount++;
                }
            }
        }
        System.out.format("Black King checked %d times.\n", blackKingCheckedCount);

        for (Map.Entry<IPiece, ArrayList<Field>> attackFieldsMap: piecesAttackFieldsRepository.getAllAttackLists()) {
            for (Field field : attackFieldsMap.getValue()) {
                if (mediator.getPiece(field).getName().equals("King")) {
                    System.out.format(" - %s attacks from (%d; %d)\n",
                            attackFieldsMap.getKey().getName(),
                            mediator.getField(attackFieldsMap.getKey()).getXCoord(),
                            mediator.getField(attackFieldsMap.getKey()).getYCoord());
                }
            }
        }
        return (blackKingCheckedCount > 0);
    }

    public Field getBoardField(final int x, final int y) {
        return boardMatrix[x][y];
    }

    public int getBoardSize() {
        return boardSize;
    }
}
