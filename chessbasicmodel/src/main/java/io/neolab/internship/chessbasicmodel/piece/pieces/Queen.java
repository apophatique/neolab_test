package io.neolab.internship.chessbasicmodel.piece.pieces;

import io.neolab.internship.chessbasicmodel.board.field.Field;
import io.neolab.internship.chessbasicmodel.mediator.Mediator;
import io.neolab.internship.chessbasicmodel.attack.BasicAttackPatterns;

import java.util.ArrayList;

public class Queen implements IPiece {
    private String name = "Queen";
    private char gameSymbol = 'Q';
    private String color = "White";

    public Queen() {}

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
        ArrayList<Field> possibleAttackList = new ArrayList<>();
        possibleAttackList.addAll(BasicAttackPatterns.getDiagonalAttackFields(getField()));
        possibleAttackList.addAll(BasicAttackPatterns.getHorizonVerticalAttackFields(getField()));

        return possibleAttackList;
    }
}
