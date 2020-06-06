package io.neolab.internship.chessbasicmodel;

import io.neolab.internship.chessbasicmodel.board.gamemap.GameMap;

/**
 * Main class.
 */
public final class Main {
    /**
     * main method, where we test basic chess model.
     * @param args Command line args
     */
    public static void main(final String[] args) {
        GameMap gameMap = GameMap.getInstance();
        gameMap.initializeBoardMatrix();
        gameMap.printBoard();
        gameMap.getBlackKingChecks();
    }
    private Main() {}
}
