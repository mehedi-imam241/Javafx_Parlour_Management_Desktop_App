package javaFxControllers;

import dbOperations.DbServices;
import java.io.IOException;
import java.util.List;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeController {
    
    DbServices dbServices = DbServices.getInstance(); //Get the database service class

    @FXML
    private TextField appointmentMakerName;
    
    @FXML
    private TextField appointmentMakerEmail;
    
    @FXML
    private ChoiceBox<String> selectedService;
    
    @FXML
    private Text selectServices;
    
    @FXML
    private DatePicker appointmentDate;
    
    @FXML
    private TextField appointmantMakerPhone;
    
    @FXML
    private ChoiceBox<String> selectedService1;
    
    @FXML
    private Text selectAppointmentTimeText;
    
    @FXML
    public void initialize() {
        //Firing new thread to keep UI safe from hanging 
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                final List<String> servicesNamesList = dbServices.getServicesList();
                
                if (servicesNamesList != null) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            selectedService.getItems().addAll(servicesNamesList);
                            selectedService.setValue(servicesNamesList.get(0)); //Add the first item as a default value
                            selectServices.setVisible(false);
                        }
                    });
                } else {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            showAlert(Alert.AlertType.ERROR, "Can not get services", "Can not get services,please try again");
                        }
                    });
                    
                }
            }
        }
        ).start();
    }
    
    @FXML
    void aboutUs(ActionEvent event
    ) {
        
    }
    
    @FXML
    void admin(ActionEvent event
    ) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxmls/AdminServiceAdd.fxml"));
        
        Stage stage = (Stage) selectServices.getScene().getWindow();
        Scene scene = null;
        try {
            scene = new Scene((Parent) loader.load(), 1114, 627);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }
    
    @FXML
    void contactUs(ActionEvent event
    ) {
        
    }
    
    @FXML
    void homeScreen(ActionEvent event
    ) {
        
    }
    
    @FXML
    void services(ActionEvent event
    ) {
        
    }
    
    @FXML
    void makeAnAppointment(ActionEvent event
    ) {
        validateAppointmentInput();
    }
    
    private void validateAppointmentInput() {
        if (appointmentMakerName.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Appointment maker name can not be empty", "Please enter your name");
        } else if (appointmentDate.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, "Appointment can not be empty", "Plese enter appoinment date");
        } else if (appointmantMakerPhone.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Appoint maker phone number can not be empty", "Please enter your mobile number");
        }
    }
    
    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
