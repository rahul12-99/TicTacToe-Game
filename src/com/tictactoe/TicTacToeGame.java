package com.tictactoe;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    /*
     Declared instance variable
     */
    private final char[] board;
    private char currentPlayer;
    private char userLetter;
    private char computerLetter;
    private final boolean gameFinished;

    /*
     * This method is for declared the game board it's a constructor
     */
    public TicTacToeGame() {
        board = new char[10]; // Index 0 is ignored
        Arrays.fill(board, ' ');
        currentPlayer = ' ';
        userLetter = ' ';
        computerLetter = ' ';
        gameFinished = false;
    }

    /**
     * This method is for choose letter X or O
     */
    public void chooseLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose X or O: ");
        userLetter = Character.toUpperCase(scanner.next().charAt(0));
        computerLetter = (userLetter == 'X') ? 'O' : 'X';
        System.out.println("You chose " + userLetter);
        System.out.println("Computer is " + computerLetter);
    }

    /**
     * This method is for toss who will play first
     */
    public void toss() {
        Random random = new Random();
        int result = random.nextInt(2); // 0 for heads, 1 for tails
        currentPlayer = (result == 0) ? userLetter : computerLetter;
        System.out.println((currentPlayer == userLetter) ? "You play first." : "Computer plays first.");
    }

    /**
     * This method is for show the game board
     */
    public void showBoard() {
        System.out.println("-------------");
        System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |");
        System.out.println("-------------");
        System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |");
        System.out.println("-------------");
        System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");
        System.out.println("-------------");
    }

    /**
     * This method is for make the move
     */
    public void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int index;
        do {
            System.out.print("Enter the index (1-9) to make your move: ");
            index = scanner.nextInt();
        } while (index < 1 || index > 9 || board[index] != ' ');

        board[index] = currentPlayer;
    }

    /**
     * This method is for check available space and return true or false
     */
    public void isSpaceAvailable() {
        for (int i = 1; i < board.length; i++) {
            if (board[i] == ' ') {
                return;
            }
        }
    }

    /**
     * This method is for check winning condition
     */
    public void checkWin(char player) {
        // Winning combinations
        int[][] winCombinations = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, // Rows
                {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, // Columns
                {1, 5, 9}, {3, 5, 7}             // Diagonals
        };

        for (int[] combination : winCombinations) {
            if (board[combination[0]] == player && board[combination[1]] == player && board[combination[2]] == player) {
                return;
            }
        }
    }

    /**
     * This is main method for calling the play game method
     */
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.chooseLetter();
        game.toss();
        game.showBoard();
        game.makeMove();
        game.isSpaceAvailable();
        game.checkWin(game.currentPlayer);
    }
}
