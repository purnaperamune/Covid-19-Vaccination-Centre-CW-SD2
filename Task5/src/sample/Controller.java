package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Button btnClose;

    @FXML
    private Button btnReceipt;

    @FXML
    private Button btnCloseReceipt;

    @FXML
    public void navigateToReceipt(ActionEvent actionEvent) throws Exception{
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Receipt.fxml"));
        newStage.setTitle("Receipt");
        newStage.setScene(new Scene(root,493,296));
        newStage.show();

        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();
    }

    @FXML
    public void closeProgram(){
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void closeReceipt(){
        Stage stage = (Stage) btnCloseReceipt.getScene().getWindow();
        stage.close();
    }
}
