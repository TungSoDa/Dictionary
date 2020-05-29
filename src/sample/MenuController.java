package sample;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class MenuController
{
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    ArrayList<String> arrayList = new  ArrayList<String>();

    @FXML
    ListView<String> listView;

    @FXML
    TextField textField;
    public void Search(KeyEvent event)
    {
        dictionaryManagement.insertFromFile();
        ArrayList<String> arrayList = dictionaryManagement.dictionarySearcher(textField.getText());
        listView.getItems().setAll(arrayList);
    }

    @FXML
    WebView webView;
    public void lookUp(MouseEvent event)
    {
        String str = listView.getSelectionModel().getSelectedItem();
        String vietnameseMeaning = dictionaryManagement.dictionaryLookup(str);
        if (!vietnameseMeaning.equals(null))
        {
            WebEngine webEngine = webView.getEngine();
            webEngine.loadContent(vietnameseMeaning);
        }
    }

    @FXML
    Button buttonAdd;
    public  void openAddWindow(ActionEvent event) throws IOException
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("add.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),400,200);
            Stage stage = new Stage();
            scene.getStylesheets().addAll(this.getClass().getResource("functionBackground.css").toExternalForm());
            stage.setTitle("Add Word");
            stage.setScene(scene);
            stage.show();
        }   catch (IOException e) {System.out.println(e.getMessage());}
    }

    @FXML
    Button buttonDelete;
    public  void openDeleteWindow(ActionEvent event) throws IOException
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("delete.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),400,200);
            Stage stage = new Stage();
            scene.getStylesheets().addAll(this.getClass().getResource("functionBackground.css").toExternalForm());
            stage.setTitle("Delete Word");
            stage.setScene(scene);
            stage.show();
        }   catch (IOException e) {System.out.println(e.getMessage());}
    }

    @FXML
    Button buttonFix;
    public  void openFixWindow(ActionEvent event) throws IOException
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("fix.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),400,200);
            Stage stage = new Stage();
            scene.getStylesheets().addAll(this.getClass().getResource("functionBackground.css").toExternalForm());
            stage.setTitle("Fix Word");
            stage.setScene(scene);
            stage.show();
        }   catch (IOException e) {System.out.println(e.getMessage());}
    }

    @FXML
    Button buttonAPI;
    public  void openGGTAPI(ActionEvent event) throws IOException
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("API.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),700,350);
            Stage stage = new Stage();
            scene.getStylesheets().addAll(this.getClass().getResource("GoogleTranslate.css").toExternalForm());
            stage.setTitle("Google translate API");
            stage.setScene(scene);
            stage.show();
        }   catch (IOException e) {System.out.println(e.getMessage());}
    }

    @FXML
    Button buttonReturn;
    public void Return(ActionEvent event)
    {
        if (event.getSource() == buttonReturn)
        {
            textField.setText("");
            listView.getItems().clear();
            webView.getEngine().loadContent("");
        }
    }

    @FXML
    Button buttonSound;
    public  void Sound(ActionEvent event)
    {
        if (event.getSource() == buttonSound)
        {
            String word = listView.getSelectionModel().getSelectedItem();
            System.setProperty("mbrola.base", "C:/Users/Dell/Desktop/Dictionary/MBROLA/mbrola");
            VoiceManager voiceManager = VoiceManager.getInstance();
            Voice voice = voiceManager.getVoice("mbrola_us1");
            voice.allocate();
            voice.speak(word);
            voice.deallocate();
        }
    }


}
