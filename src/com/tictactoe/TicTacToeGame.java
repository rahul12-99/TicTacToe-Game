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
    public void chooseLetter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a letter :: X or O :");
        playerLetter = sc.next().toUpperCase().charAt(0);
        if (playerLetter == 'X') {
            computerLetter = 'O';
        } else {
            computerLetter = 'X';
        }
        System.out.println("Player choose letter : " + playerLetter);
        System.out.println("Computer choose letter : " + computerLetter);
    }

    /**
     * This method is for display the current board
     */
    public void showBoard() {
        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("----------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("----------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }

    /**
     * This method is for allow player to move on a desired location
     */
    public void makeMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your location(1-9): ");
        int position = scanner.nextInt();
        if (board[position] != ' ') {
            System.out.println("You already chosen this! Enter a valid location");
        } else {
            board[position] = playerLetter;
            showBoard();
            checkFreeSpace();
        }
    }

    /**
     * This method is for checking the free space available on board and
     * count the number of free space and printing
     */

    public void checkFreeSpace() {
        boolean isSpaceAvailable = false;
        int numOfFreeSpaces = 0;
        for (int index = 1; index < board.length; index++) {
            if ((board[index] == ' ')) {
                isSpaceAvailable = true;
                numOfFreeSpaces++;
            }
        }
        if (!isSpaceAvailable) {
            System.out.println("Board is full! You can't make another move");
        } else {
            System.out.println("Free space is available! you have " + numOfFreeSpaces + " moves left");
        }
    }

    /**
     * This method is for random check the first player
     */

    public void toss() {
        int Head = 0;
        double toss = Math.floor(Math.random() * 10) % 2;
        if (toss == Head) {
            System.out.println("computer starts to play first");
        } else {
            System.out.println("User starts to play first");
        }
    }

    /**
     * Main method to execute the program and calling the method
     */
    public static void main(String[] args) {
        System.out.println("-----Welcome to tic tac toe game ------");
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.createEmptyBoard();
        ticTacToeGame.chooseLetter();
        ticTacToeGame.showBoard();
        ticTacToeGame.makeMove();
        ticTacToeGame.checkFreeSpace();
        ticTacToeGame.toss();
    }
}
