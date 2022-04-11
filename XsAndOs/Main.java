package XsAndOs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //set up scanner
        // Create array for the game state
        char[][] gameArray = new char[3][3];

        //get game state and fill the array

        System.out.print("Enter cells: ");
        String gameState = scanner.next();
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameArray[i][j] = gameState.charAt(count);
                count++;
            }
        }
        //build grid and output game

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++){
                System.out.print(gameArray[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        // check game state
        char x = 'X';
        char o = 'O';
        int xCount = 0;
        int oCount = 0;
        int empty = 0;
        boolean unfair = false;
        boolean xRow = false;
        boolean oRow = false;
        //check fair number of turns
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                if (gameArray[i][j] == x) {
                    xCount++;
                } else if (gameArray[i][j] == o) {
                    oCount++;
                } else {
                    empty++;
                }
            }
        } if (xCount == oCount + 2 || oCount == xCount + 2) {
            unfair = true;
        }

        //check for complete 3s

        for (int i = 0; i < 3; i++){
            //rows
            if (gameArray[i][0] == x || gameArray[i][0] == o) {
                if (gameArray[i][0] == gameArray[i][1] && gameArray[i][0] == gameArray[i][2]) {
                    if (gameArray[i][0] == x) {
                        xRow = true;
                    } else {
                        oRow = true;
                    }
                }

            }
            //columns
            if (gameArray[0][i] == x || gameArray[0][i] == o) {
                if (gameArray[0][i] == gameArray[1][i] && gameArray[0][i] == gameArray[2][i]) {
                    if (gameArray[0][i] == x) {
                        xRow = true;
                    } else {
                        oRow = true;
                    }
                }
            }
        }
        //diagonals
        if (gameArray[1][1] == x || gameArray[1][1] == o) {
            if (gameArray[1][1] == gameArray[0][0] && gameArray[1][1] == gameArray[2][2] ||
                    gameArray[1][1] == gameArray[0][2] && gameArray[1][1] == gameArray[2][0]) {
                if (gameArray[1][1] == x) {
                    xRow = true;
                } else {
                    oRow = true;
                }
            }

        }

        //check for both having a full row
        if (xRow && oRow) {
            unfair = true;
        }
        if (unfair) {
            System.out.println("Impossible");
        } else if (xRow) {
            System.out.println("X wins");
        } else if (oRow) {
            System.out.println("O wins");
        } else if (empty == 0) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }

    }
}
