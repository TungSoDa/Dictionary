package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DeleteController
{
    MyDictionary myDictionary = new MyDictionary();
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    @FXML
    TextField textFieldDeleteWord;
    @FXML
    Button button2;
    public  void delete(ActionEvent event)
    {
        String text = dictionaryManagement.deleteWord(textFieldDeleteWord.getText());
        if(text == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Notice the Delete function");
            alert.setContentText("YOU HAVE NOT MADE ENTER YOUR WORD YET!!!");
            alert.show();
        }

        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notice the Delete function");
            alert.setContentText("DELETED SUCCESSFULLY!");
            alert.show();
        }

    }
}
