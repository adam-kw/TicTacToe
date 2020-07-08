package com.adamkwiecinski;

import java.util.Scanner;

public class TicTacToeTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean finish = false;
        int queue = 1;
        Player playerX = new Player('X');
        Player playerO = new Player('O');
        Player nextPlayer;
        Game testGame = new Game(playerX, playerO);
        String coordinates;

        System.out.println("Rules: \n" +
                           "1) X starts the game \n" +
                           "2) Coordinates allowed: 1-3 1-3 e.g. 1 1 or 2 1");
        while (!finish) {
            testGame.printGameTable(testGame.getBoard());

            System.out.print("Enter coordinates ");
            coordinates = input.nextLine();
            if(!testGame.isValidMove(coordinates, testGame.getBoard())){
                continue;
            }

            if (queue % 2 > 0) {
                nextPlayer = playerX;
            } else {
                nextPlayer = playerO;
            }

            testGame.makeMove(coordinates, testGame.getBoard(), nextPlayer);
            if(testGame.hasWon(testGame.getBoard())){
                testGame.printGameTable(testGame.getBoard());
                finish = true;
            }
            queue++;
        }
    }
}
