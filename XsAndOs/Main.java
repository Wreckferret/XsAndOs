package XsAndOs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //set up scanner
        // Create array for the game state
        char[] gameArray = new char[9];

        //get game state and fill the array

        System.out.print("Enter cells: ");
        String gameState = scanner.nextLine();
        for (int i = 0; i < 9; i++) {
            gameArray[i] = gameState.charAt(i);
        }
        //build grid and output game

        System.out.println("---------");
        for (int i = 0; i < 9; i = i + 3) {
            System.out.print("| ");
            for (int j = i; j <= i + 2; j++){
                System.out.print(gameArray[j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}