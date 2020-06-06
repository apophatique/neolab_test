package io.neolab.internship.chessbasicmodel.piece.pieces;

import io.neolab.internship.chessbasicmodel.board.field.Field;
import io.neolab.internship.chessbasicmodel.mediator.Mediator;

import java.util.ArrayList;

public class King implements IPiece {
    private final String name = "King";
    private final char gameSymbol = 'K';
    private String color = "Black";

    public King() {}

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
        return new ArrayList<>();
    }
}
