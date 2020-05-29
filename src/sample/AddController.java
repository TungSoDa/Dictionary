package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddController
{
    MyDictionary myDictionary = new MyDictionary();
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    @FXML
    TextField textFieldEnglish;
    @FXML
    TextField textFieldVietnamese;
    @FXML
    Button button1;
    public  void add(ActionEvent event)
    {
        if((textFieldEnglish.getText().equals("")) || textFieldVietnamese.getText().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Notice the Add function");
            alert.setContentText("YOU HAVE NOT MADE ENTER YOUR WORD YET!!!");
            alert.show();
        }
        else
        {
            dictionaryManagement.addWord(textFieldEnglish.getText(), textFieldVietnamese.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notice the Add function");
            alert.setContentText("ADDED SUCCESSFULLY");
            alert.show();
        }
    }

}
