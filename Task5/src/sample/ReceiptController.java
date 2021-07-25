package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.time.LocalDate;

public class ReceiptController {

    @FXML
    private Button btnCloseReceipt;

    @FXML
    private Label lblPatient;

    @FXML
    private Label lblDate;


    @FXML
    public void closeReceipt(){ //Closing receipt window
        Stage stage = (Stage) btnCloseReceipt.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void displayText(String firstName,String secondName){ //Displaying patient information in receipt window
        lblPatient.setText("Customer Name : "+firstName+" "+secondName);
    }

    @FXML
    public void displayDate(LocalDate date){ //Displaying date in receipt window
        lblDate.setText("Date : "+date);

    }


}
