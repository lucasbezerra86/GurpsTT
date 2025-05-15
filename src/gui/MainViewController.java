package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.Constraints;
import gui.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class MainViewController implements Initializable {
	
	@FXML
	private Button btCalcDist;
	
	@FXML
	private Button btCalcDays;
	
	@FXML 
	private TextField milesTextField;
	
	@FXML
	private TextField daysTextField;
	
	@FXML
	private Label milesLabel;
	
	@FXML
	private Label daysLabel;
	
	@FXML
	public void onBtCalcDistAction() {
		try {
		double movement = Double.parseDouble(milesTextField.getText());
		double distance = movement*7;
		milesLabel.setText(String.format("%.2f", distance));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Invalid value", null, "Value cannot be blank", AlertType.ERROR);
		}
	}
	
	@FXML
	public void onBtCalcDays() {
		try {double totalDistance = Double.parseDouble(daysTextField.getText());
		double finalDistance = Double.parseDouble(milesTextField.getText())*7;
		double totalDays = totalDistance/finalDistance;
		daysLabel.setText(String.format("%.1f", totalDays));
	} catch (NumberFormatException e) {
		Alerts.showAlert("Invalid value", null, "Put a movement value first!", AlertType.ERROR);
	}
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldDouble(milesTextField);
		Constraints.setTextFieldInteger(daysTextField);
		// TODO Auto-generated method stub
		
	}

}
