package com.adamkwiecinski;

public class Game {
    private Player player1;
    private Player player2;
    private char[][] board = new char[3][3];

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public char[][] getBoard() {
        return board;
    }

    public void printGameTable(char[][] gameTable){
        System.out.println("---------");
        System.out.println("|" + " " + gameTable[0][0] + " " + gameTable[0][1] + " " + gameTable[0][2] + " " + "|");
        System.out.println("|" + " " + gameTable[1][0] + " " + gameTable[1][1] + " " + gameTable[1][2] + " " + "|");
        System.out.println("|" + " " + gameTable[2][0] + " " + gameTable[2][1] + " " + gameTable[2][2] + " " + "|");
        System.out.println("---------");
    }

    public boolean isValidMove(String coordinates, char[][] gameTable){
        String[] array = coordinates.split(" ");

        int x = 0;
        int y = 0;

        try {
            x = Integer.parseInt(array[0]);
            y = Integer.parseInt(array[1]);
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            return false;
        }

        if (x > 3 || x < 1 || y > 3 || y < 1) {
            System.out.println("Coordinates should be between 1 and 3");
            return false;
            //throw new IllegalArgumentException("Coordinates should be between 1 and 3");
        }

        for(int row = 0; row < 3; row++){
            for(int column = 0; column < 3; column++){
                if(gameTable[x-1][y-1] == 'O' || gameTable[x-1][y-1] == 'X'){
                    System.out.println("This cell is occupied! Choose another one!");
                    return false;
                    //throw new IllegalArgumentException("This cell is occupied! Choose another one!");
                }
            }
        }
        return true;
    }

    public char[][] makeMove(String coordinates, char[][] gameTable, Player player) {
        String[] array = coordinates.split(" ");
        int x = Integer.parseInt(array[0]);
        int y = Integer.parseInt(array[1]);

        switch (x) {
            case 1:
                switch (y) {
                    case 1:
                        gameTable[0][0] = player.getPlayerRole();
                        break;
                    case 2:
                        gameTable[0][1] = player.getPlayerRole();
                        break;
                    case 3:
                        gameTable[0][2] = player.getPlayerRole();
                        break;
                }
                break;

            case 2:
                switch (y) {
                    case 1:
                        gameTable[1][0] = player.getPlayerRole();
                        break;
                    case 2:
                        gameTable[1][1] = player.getPlayerRole();
                        break;
                    case 3:
                        gameTable[1][2] = player.getPlayerRole();
                        break;
                }
                break;

            case 3:
                switch (y) {
                    case 1:
                        gameTable[2][0] = player.getPlayerRole();
                        break;
                    case 2:
                        gameTable[2][1] = player.getPlayerRole();
                        break;
                    case 3:
                        gameTable[2][2] = player.getPlayerRole();
                        break;
                }
                break;
        }

        return gameTable;
    }

    public boolean hasWon(char[][] gameTable){
        int oRow = 0;
        int xRow = 0;
        int oColumn = 0;
        int xColumn = 0;
        char slantLeft = '?';
        char slantRight = '!';

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(gameTable[i][j] == 'O'){
                    oRow++;
                }
                if(gameTable[i][j] == 'X'){
                    xRow++;
                }
                if(gameTable[j][i] == 'O'){
                    oColumn++;
                }
                if(gameTable[j][i] == 'X'){
                    xColumn++;
                }
            }
            if(xRow == 3 || xColumn == 3){
                System.out.println("X has won!");
                return true;
            }

            if(oRow == 3 || oColumn == 3){
                System.out.println("O has won!");
                return true;
            }
            oRow = 0;
            oColumn = 0;
            xRow = 0;
            xColumn = 0;
        }

        if (gameTable[0][0] == 'O') {
            slantLeft = 'O';
        }
        if(gameTable[0][0] == 'X'){
            slantLeft = 'X';
        }
        if(gameTable[1][1] == slantLeft &&
           gameTable[2][2] == slantLeft){
                System.out.println(slantLeft + " has won!");
                return true;
        }

        if (gameTable[0][2] == 'O') {
            slantRight = 'O';
        }
        if(gameTable[0][2] == 'X'){
            slantRight = 'X';
        }

        if (gameTable[1][1] == slantRight &&
            gameTable[2][0] == slantRight){
                System.out.println(slantRight + " has won!");
                return true;
        }

        return false;
    }
}
