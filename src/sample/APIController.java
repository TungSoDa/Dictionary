package sample;

import com.darkprograms.speech.translator.GoogleTranslate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;

public class APIController
{
    private static String fromLang = "en";
    private static String toLang = "vi";
    @FXML private TextArea textArea;
    @FXML private Button apiEV;
    @FXML private Button apiVE;
    @FXML private WebView webView;
    public void TranslateAPI(ActionEvent event)
    {
        try
        {
            if (!textArea.getText().equals(""))
            {
                if(apiEV.isPressed())
                {
                    String s = GoogleTranslate.translate(fromLang,toLang,textArea.getText());
                    webView.getEngine().loadContent(s);
                }
                else
                {
                    String s = GoogleTranslate.translate(toLang,fromLang,textArea.getText());
                    webView.getEngine().loadContent(s);
                }
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("YOU HAVE NOT ENTERED TEXT. PLEASE ENTER TEXT TO TRANSLATE");
                alert.show();
            }
        }   catch (Exception e) {e.printStackTrace();}
    }
}
