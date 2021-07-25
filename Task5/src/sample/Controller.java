package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Controller {

    @FXML
    private Button btnClose;

    @FXML
    private TextField fName;

    @FXML
    private TextField sName;

    @FXML
    private DatePicker presentDate;

    @FXML
    public void navigateToReceipt(ActionEvent actionEvent) throws Exception{ //Navigating from patient details input area to receipt area
        String firstName = fName.getText();
        String secondName = sName.getText();
        LocalDate date = presentDate.getValue();

        FXMLLoader receiptViewLoader = new FXMLLoader(getClass().getResource("Receipt.fxml"));
        Parent root = (Parent) receiptViewLoader.load();

        ReceiptController receiptController = receiptViewLoader.getController();
        receiptController.displayText(firstName,secondName);
        receiptController.displayDate(date);


        Stage newStage = new Stage();
        newStage.setTitle("Receipt");
        newStage.setScene(new Scene(root,493,296));
        newStage.show();

        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();
    }

    @FXML
    public void closeProgram(){ //Closing patient details area to go to receipt area
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}
