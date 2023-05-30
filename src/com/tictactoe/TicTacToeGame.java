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
    private boolean gameFinished;

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
    public boolean isSpaceAvailable() {
        for (int i = 1; i < board.length; i++) {
            if (board[i] == ' ') {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is for check winning condition
     */
    public boolean checkWin(char player) {
        // Winning combinations
        int[][] winCombinations = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, // Rows
                {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, // Columns
                {1, 5, 9}, {3, 5, 7}             // Diagonals
        };

        for (int[] combination : winCombinations) {
            if (board[combination[0]] == player && board[combination[1]] == player && board[combination[2]] == player) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is for play the game
     */
    public void playGame() {
        chooseLetter();
        toss();
        showBoard();

        while (!gameFinished) {
            if (currentPlayer == userLetter) {
                makeMove();
                showBoard();
                if (checkWin(userLetter)) {
                    System.out.println("Congratulations! You win!");
                    gameFinished = true;
                } else if (isSpaceAvailable()) {
                    System.out.println("It's a tie!");
                    gameFinished = true;
                }
                currentPlayer = computerLetter;
            } else {
                System.out.println("Computer's turn:");
                computerMove();
                showBoard();
                if (checkWin(computerLetter)) {
                    System.out.println("Computer wins! Better luck next time.");
                    gameFinished = true;
                } else if (isSpaceAvailable()) {
                    System.out.println("It's a tie!");
                    gameFinished = true;
                }
                currentPlayer = userLetter;
            }
        }
    }

    /**
     * This method is for computer move
     */
    public void computerMove() {
        // Check if computer can win in the next move
        for (int i = 1; i < board.length; i++) {
            if (board[i] == ' ') {
                board[i] = computerLetter;
                if (checkWin(computerLetter)) {
                    return;
                } else {
                    board[i] = ' ';
                }
            }
        }

        // Check if user can win in the next move and block it
        for (int i = 1; i < board.length; i++) {
            if (board[i] == ' ') {
                board[i] = userLetter;
                if (checkWin(userLetter)) {
                    board[i] = computerLetter;
                    return;
                } else {
                    board[i] = ' ';
                }
            }
        }

        // Take a corner if available
        if (board[1] == ' ') {
            board[1] = computerLetter;
            return;
        } else if (board[3] == ' ') {
            board[3] = computerLetter;
            return;
        } else if (board[7] == ' ') {
            board[7] = computerLetter;
            return;
        } else if (board[9] == ' ') {
            board[9] = computerLetter;
            return;
        }

        // Take the center if available
        if (board[5] == ' ') {
            board[5] = computerLetter;
            return;
        }

        // Take any available side
        for (int i = 2; i <= 8; i += 2) {
            if (board[i] == ' ') {
                board[i] = computerLetter;
                return;
            }
        }
    }

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.playGame();
    }
}
