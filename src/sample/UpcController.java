package sample; /**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;


public class UpcController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="sourceTextField"
    private TextField sourceTextField; // Value injected by FXMLLoader

    @FXML // fx:id="textArea"
    private TextArea textArea; // Value injected by FXMLLoader

    @FXML
    private File selectedDirectory;


    @FXML
    void doOnClick(ActionEvent event) {

        //A list of all the files in our source path
        File[] listRoot = this.selectedDirectory.listFiles();


        for(int i = 0; i < listRoot.length; i++){
            if(listRoot[i].isDirectory()) {
                System.out.println(listRoot[i]);
            }
        }







    }

    @FXML
    void selectOnClick(ActionEvent event) {

        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select the folder");


       this.selectedDirectory = chooser.showDialog(null);

        if(selectedDirectory != null){
            this.sourceTextField.setText(selectedDirectory.toString());
        }


    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert sourceTextField != null : "fx:id=\"sourceTextField\" was not injected: check your FXML file 'sample.fxml'.";
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
