package tictactoe.gui.model;

import javafx.fxml.FXML;


public class TicTacViewModel {
    private String[] names = new String[3]; // Array to store names.
    public String getName(int playerNumber) {

        // Returns the name of the player.
        return names[playerNumber];
    }

    public void setName(int playerNumber, String name){
        // 0, 1 , 2
        names[playerNumber] = name;
    }

}
