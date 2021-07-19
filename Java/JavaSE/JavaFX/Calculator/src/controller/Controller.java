package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.corba.se.spi.orb.Operation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller implements Initializable{
	
	float data = 0f;
	int operation = -1;
	Float ans = (float) 0;

    @FXML
    private Button one;

    @FXML
    private Button two;

    @FXML
    private Button div;

    @FXML
    private Button three;

    @FXML
    private Button four;

    @FXML
    private Button five;

    @FXML
    private Button six;

    @FXML
    private Button mult;

    @FXML
    private Button seven;

    @FXML
    private Button eight;

    @FXML
    private Button nine;

    @FXML
    private Button minus;

    @FXML
    private Button clear;

    @FXML
    private Button zero;

    @FXML
    private Button equals;

    @FXML
    private Button plus;
    
    @FXML
    private Button answer;
    
    @FXML
    private Button anscl;

    @FXML
    private TextField result;

    @FXML
    void onAction(ActionEvent event) {
    	if(event.getSource() == one) {
    		result.setText(result.getText() + "1");
    	} else if(event.getSource() == two) {
    		result.setText(result.getText() + "2");
    	} else if(event.getSource() == three) {
    		result.setText(result.getText() + "3");
    	} else if(event.getSource() == four) {
    		result.setText(result.getText() + "4");
    	} else if(event.getSource() == five) {
    		result.setText(result.getText() + "5");
    	} else if(event.getSource() == six) {
    		result.setText(result.getText() + "6");
    	} else if(event.getSource() == seven) {
    		result.setText(result.getText() + "7");
    	} else if(event.getSource() == eight) {
    		result.setText(result.getText() + "8");
    	} else if(event.getSource() == nine) {
    		result.setText(result.getText() + "9");
    	} else if(event.getSource() == zero) {
    		result.setText(result.getText() + "0");
    	} else if(event.getSource() == answer) {
    		result.setText(result.getText() + String.valueOf(ans));
    	} else if(event.getSource() == clear) {
    		result.setText("");
    	} else if(event.getSource() == plus) {
    		data = Float.parseFloat(result.getText());
    		operation = 1; //Pour l'addition
    		result.setText("");
    	} else if(event.getSource() == minus) {
    		data = Float.parseFloat(result.getText());
    		operation = 2; //Pour la soustraction
    		result.setText("");
    	} else if(event.getSource() == mult) {
    		data = Float.parseFloat(result.getText());
    		operation = 3; //Pour la multiplication
    		result.setText("");
    	} else if(event.getSource() == div) {
    		data = Float.parseFloat(result.getText());
    		operation = 4; //Pour la division
    		result.setText("");
    	} else if(event.getSource() == equals) {
    		Float secondValue = Float.parseFloat(result.getText());
    		switch(operation) {
    		case 1:
    			ans = data + secondValue;
    			result.setText("= " + String.valueOf(ans));
    			break;
    		case 2:
    			ans = data - secondValue;
    			result.setText("= " + String.valueOf(ans));
    			break;
    		case 3:
    			ans = data * secondValue;
    			result.setText("= " + String.valueOf(ans));
    			break;
    		case 4:
    			ans = (int) data / secondValue;
    			result.setText("= " + String.valueOf(ans));
    			break;
    		}
    	} else if(event.getSource() == anscl) {
    		ans = 0f; 
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
