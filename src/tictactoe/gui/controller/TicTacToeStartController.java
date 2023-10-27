package tictactoe.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tictactoe.gui.model.TicTacViewModel;
import java.io.IOException;

public class TicTacToeStartController {
    public TextField PlayerOneName;
    public TextField PlayerTwoName;



    @FXML
    private void ClickOpen(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/TicTacView.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("The Game");
        TicTacViewController controller =  loader.getController();
        TicTacViewModel model = new TicTacViewModel();

        model.setName(1, PlayerOneName.getText()); // Setting Player One's name
        model.setName(2, PlayerTwoName.getText()); // Setting Player Two's name

        controller.setModel(model);
        controller.updateNameOfParticipant();

        stage.show();

        currentStage.close();



    }


}

