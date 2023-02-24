package com.jad;

import com.jad.chessknight.*;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        ChessKnightProblem.solve();

        HexagonalBoard<Square> hexBoard = new HexagonalBoard<>(3, 6);
        System.out.println(hexBoard);
    }


}
