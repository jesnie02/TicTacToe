/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tictactoe.bll.GameBoard;
import tictactoe.bll.IGameModel;
import tictactoe.gui.model.TicTacViewModel;

/**
 *
 * @author Stegger
 */
public class TicTacViewController implements Initializable
{

    public Button btnNewMenu;
    private TicTacViewModel ticTacViewModel;
    @FXML
    public Label nameOfParticipant1;
    public Label nameOfParticipant2;
    @FXML
    private Label lblPlayer;

    @FXML
    private Button btnNewGame;

    @FXML
    private GridPane gridPane;
    
    private static final String TXT_PLAYER = "Player: "; // Stores the player name and is used in setName.
    private IGameModel game;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            // Get the row index of the Node that triggered the event in a GridPane.
            Integer row = GridPane.getRowIndex((Node) event.getSource());
            // Get the column index of the Node that triggered the event in a GridPane.
            Integer col = GridPane.getColumnIndex((Node) event.getSource());
            // Check if the row index is null; if it's null, set it to 0, otherwise, use the retrieved value.
            int r = (row == null) ? 0 : row;
            // Check if the column index is null; if it's null, set it to 0, otherwise, use the retrieved value.
            int c = (col == null) ? 0 : col;
            // Get the next player in the game, assuming there's a method called 'getNextPlayer' in the 'game' object.
            int player = game.getNextPlayer();

                // Check if a valid move was made by calling the 'play' method with the column and row indices.
                if (game.play(c, r)) {
                    // Get the Button that triggered the event.
                    Button btn = (Button) event.getSource();
                    // Determine whether the current player is "X" or "O" based on the player variable.
                    String xOrO = player == 0 ? "X" : "O";
                    // Set the text of the Button to "X" or "O" to indicate the player's move.
                    btn.setText(xOrO);
                        // Get the winner of the game using the 'getWinner' method.
                        int winner = game.getWinner();
                    // Check if there is a winner. The value -1 typically represents no winner.
                    if (winner != -1) {
                        //ticTacViewModel.setWinnerName(ticTacViewModel.getName(winner));
                        displayWinner(winner);
                        disableButtons();
                    } else {

                        setPlayer();
                    }
                }
            } catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

    @FXML
    private void handleNewGame(ActionEvent event)
    {
        game.newGame();
        setPlayer();
        clearBoard();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        game = new GameBoard();
        setPlayer();

    }



    private void setPlayer()
    {

        lblPlayer.setText(TXT_PLAYER + game.getNextPlayer());
    }

    private void displayWinner(int winner)
    {
        String message = "";
        switch (winner)
        {
            case 0:
                message = "It's a draw :-(";
                break;
            default:
                message = ticTacViewModel.getName(winner) + " wins!!!";
                break;

        }

    lblPlayer.setText(message);

    }


    private void disableButtons() {
        for(Node n : gridPane.getChildren()) {
            Button btn = (Button) n;
            btn.setDisable(true);
        }
    }

    private void clearBoard()
    {
        // Iterate through all the child nodes of the 'gridPane', which are assumed to be buttons.
        for(Node n : gridPane.getChildren())
        {
            // Check if the current node is an instance of the Button class.
            if (n instanceof Button) {
                Button btn = (Button) n;
                btn.setText("");
                btn.setDisable(false);
            }
        }
    }

    @FXML
    public void setModel(TicTacViewModel model) {

        ticTacViewModel = model;
    }

    @FXML
    public void updateNameOfParticipant() {

        nameOfParticipant1.setText(ticTacViewModel.getName(1)); // Get Player One's name
        nameOfParticipant2.setText(ticTacViewModel.getName(2)); // Get Player Two's name

    }

    public void btnMainMenu(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/TicTacToeStart.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("TicTacToe");


        stage.show();
        currentStage.close();
    }
}
