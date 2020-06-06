package io.neolab.internship.chessbasicmodel.piece.pieces;

import io.neolab.internship.chessbasicmodel.attack.BasicAttackPatterns;
import io.neolab.internship.chessbasicmodel.board.field.Field;
import io.neolab.internship.chessbasicmodel.mediator.Mediator;

import java.util.ArrayList;

/**
 * Class that represents a White Pawn piece in chess game.
 */
public class Pawn implements IPiece {
    private String name = "Pawn";
    private char gameSymbol = 'P';
    private String color = "White";

    public Pawn() {}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public char getGameSymbol() {
        return gameSymbol;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Field getField() {
        return Mediator.getInstance().getField(this);
    }

    @Override
    public ArrayList<Field> definePossibleAttackList() {
        return BasicAttackPatterns.getWhitePawnAttackMoves(getField());
    }
}
