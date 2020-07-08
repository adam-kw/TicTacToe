package com.adamkwiecinski;

public class Player {
    private char playerRole;

    public Player(char playerRole) {
        this.playerRole = playerRole;
    }

    public char getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(char playerRole) {
        if(playerRole == 'O' || playerRole == 'X'){
            this.playerRole = playerRole;
        } else {
            throw new IllegalArgumentException("Player role can be either O or X");
        }
    }
}
