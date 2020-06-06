package io.neolab.internship.chessbasicmodel.piece.pieces;

import io.neolab.internship.chessbasicmodel.attack.BasicAttackPatterns;
import io.neolab.internship.chessbasicmodel.board.field.Field;
import io.neolab.internship.chessbasicmodel.mediator.Mediator;

import java.util.ArrayList;

public class Knight implements IPiece {
    private String name = "Knight";
    private char gameSymbol = 'N';
    private String color = "White";

    public Knight() {}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public char getGameSymbol() {
        return gameSymbol;
    }

    @Override
    public Field getField() {
        return Mediator.getInstance().getField(this);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public ArrayList<Field> definePossibleAttackList() {
        return BasicAttackPatterns.getKnightAttackMoves(getField());
    }
}
