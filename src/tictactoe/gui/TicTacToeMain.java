/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Stegger
 */

public class TicTacToeMain extends Application {

@Override
    public void start(Stage stage) throws Exception {

        // This will set the scene.
        Parent root = FXMLLoader.load(getClass().getResource("/TicTacToeStart.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Tic Tac Toe");
        stage.show();
    }

    public static void main(String[] args) {
    //This will run our main.
    launch(args);
    }


}





