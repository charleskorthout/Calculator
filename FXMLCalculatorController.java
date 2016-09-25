/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Charles Korthout
 */
public class FXMLCalculatorController implements Initializable {

    ScientificCalculator sc;
    @FXML private TextField display;

    /**
     * Provide the link between the calculator and the GUI
     * @param e the action event
     */
    @FXML
    public void handleButtonAction(ActionEvent e ) {
        Button button = (Button)e.getSource();
        sc.processSelection(button.getText());
        display.setText(sc.getDisplayContents());
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sc = ScientificCalculator.singleton();
    }
    
}
