package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.awt.*;

public class FixController
{
    MyDictionary myDictionary = new MyDictionary();
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    @FXML
    TextField textFieldFixWord;
    @FXML
    TextField textFieldNewMeaning;
    @FXML
    Button button3;
    public void fix(ActionEvent event)
    {
        dictionaryManagement.fixWord(textFieldFixWord.getText(), textFieldNewMeaning.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notice the Fix function");
        alert.setContentText("FIXED SUCCESSFULLY!");
        alert.show();
    }

    @FXML
    WebView webViewOldMeaing;
    public void showOldMeaing(ActionEvent event)
    {
        String str = textFieldFixWord.getSelectedText();
        String vietnameseMeaning = dictionaryManagement.dictionaryLookup(str);
        if (!vietnameseMeaning.equals(null))
        {
            WebEngine webEngine = webViewOldMeaing.getEngine();
            webEngine.loadContent(vietnameseMeaning);
        }
    }
}
