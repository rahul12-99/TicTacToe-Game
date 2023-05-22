package com.tictactoe;

public class TicTacToeGame {
    // Created a board of char size array 10;
     public static char[] board = new char[10];

    /**
     * This method is for creating empty board for Tic Tac Toe Game
     */
    public void createEmptyBoard() {
        for (int index = 0; index < 10; index++) {
            if (index == 0) {
                continue;
            } else {
                board[index] = ' ';
            }
        }
        System.out.println("Currently no one is playing the game");
    }

    /**
     * Main method to execute the program and calling the method
     */
    public static void main(String[] args) {
        System.out.println("-----Welcome to tic tac toe game ------");
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.createEmptyBoard();
    }
}
