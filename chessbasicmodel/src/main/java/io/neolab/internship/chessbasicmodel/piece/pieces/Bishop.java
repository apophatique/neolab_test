package io.neolab.internship.chessbasicmodel.piece.pieces;

import io.neolab.internship.chessbasicmodel.board.field.Field;
import io.neolab.internship.chessbasicmodel.mediator.Mediator;
import io.neolab.internship.chessbasicmodel.attack.BasicAttackPatterns;

import java.util.ArrayList;

public class Bishop implements IPiece {
    private String name = "Bishop";
    private char gameSymbol = 'B';
    private String color = "White";

    public Bishop() {}

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
        return BasicAttackPatterns.getDiagonalAttackFields(getField());
    }
}
