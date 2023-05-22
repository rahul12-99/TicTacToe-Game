package com.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
    // Created a board of char size array 10;
     public static char[] board = new char[10];
    public static char computerLetter;
    public static char playerLetter;

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
//        System.out.println("Currently no one is playing the game");
    }

    /**
     * This method is for taking user input for player latter and condition for the
     * computer letter and printing
     */
    public void chooseLetter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a letter :: X or O :");
        playerLetter = sc.next().toUpperCase().charAt(0);
        if (playerLetter == 'X'){
            computerLetter = 'O';
        }else {
            computerLetter = 'X';
        }
        System.out.println("Player choose letter : " + playerLetter);
        System.out.println("Computer choose letter : " + computerLetter);
    }

    /**
     * Main method to execute the program and calling the method
     */
    public static void main(String[] args) {
        System.out.println("-----Welcome to tic tac toe game ------");
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.createEmptyBoard();
        ticTacToeGame.chooseLetter();
    }
}
