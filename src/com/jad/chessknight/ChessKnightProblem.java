package com.jad.chessknight;

import java.util.Objects;

public abstract class ChessKnightProblem {

    //Mouvement possible pour le cavalier
    private static final int[][] possiblesMoves = {{-1,-2},{1,-2},{-2,-1},{2,-1},{-2,1},{2,1},{-1,2},{1,2}};

    public static void solve() throws CloneNotSupportedException {
        ChessBoard chessBoard = new ChessBoard();
        ChessKnight chessKnight = new ChessKnight(chessBoard, 0, 0);

        // Calcul du nombre total de mouvements nécessaires pour que le cavalier couvre tout le plateau d'échecs
        int totalMoves = chessBoard.getHeight() * chessBoard.getWidth() - 1;

        // Déplacement du cavalier sur chaque case du plateau d'échecs jusqu'à ce qu'il couvre toutes les cases
        for (int i = 1; i <= totalMoves; i++) {
            // Obtention du prochain mouvement possible pour le cavalier
            int[] nextMove = getNextMove(chessKnight, chessBoard);
            // Déplacement du cavalier à la position du prochain mouvement possible
            chessKnight.moveTo(nextMove[0], nextMove[1]);
        }

        // Affichage de l'ordre de passage du cavalier sur le plateau d'échecs
        System.out.println(chessBoard);
    }

    /**
     * Retourne la position du prochain mouvement optimal pour le cavalier sur l'échiquier.
     */
    private static int[] getNextMove(ChessKnight chessKnight, ChessBoard chessBoard) {
        int x = chessKnight.getX();
        int y = chessKnight.getY();
        int[] nextMove = new int[2];
        int minMoves = Integer.MAX_VALUE;

        // Itère sur tous les mouvements possibles.
        for (int i = 0; i < 8; i++) {
            int nextX = x + possiblesMoves[i][0];
            int nextY = y + possiblesMoves[i][1];

            // Vérifie si le prochain mouvement est valide et n'a pas été visité auparavant.
            if (nextX >= 0 && nextX < chessBoard.getWidth() && nextY >= 0 && nextY < chessBoard.getHeight() &&
                    Objects.requireNonNull(chessBoard.getAt(nextX, nextY)).getValue() == 0) {

                // Calcule le nombre de mouvements possibles à partir de cette position.
                int moves = countPossibleMoves(chessBoard, nextX, nextY);

                // Met à jour la position du prochain mouvement optimal.
                if (moves < minMoves) {
                    nextMove[0] = nextX;
                    nextMove[1] = nextY;
                    minMoves = moves;
                }
            }
        }

        return nextMove;
    }

    /**
     * Compte le nombre de mouvements possibles à partir d'une position sur l'échiquier.
     */
    private static int countPossibleMoves(ChessBoard chessBoard, int x, int y) {
        int count = 0;

        // Itère sur tous les mouvements possibles à partir de cette position.
        for (int i = 0; i < 8; i++) {
            int nextX = x + possiblesMoves[i][0];
            int nextY = y + possiblesMoves[i][1];

            // Vérifie si le prochain mouvement est valide et n'a pas été visité auparavant.
            if (nextX >= 0 && nextX < chessBoard.getWidth() && nextY >= 0 && nextY < chessBoard.getHeight() &&
                    Objects.requireNonNull(chessBoard.getAt(nextX, nextY)).getValue() == 0) {
                count++;
            }
        }

        return count;
    }
}
