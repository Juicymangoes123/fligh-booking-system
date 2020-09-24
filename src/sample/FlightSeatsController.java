package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FlightSeatsController {
    ArrayList<String> seatsChosen = new ArrayList<>();

    //Choosing which seats the user would like to sit in on the plane
    @FXML
    private void bookTheSeat(ActionEvent event){
        Button button = (Button) event.getSource();
        String buttonName = button.getId();
        //Showing the user which seats have been chosen by the user
        if (seatsChosen.contains(buttonName)){
            button.getStylesheets().clear();
            seatsChosen.remove(buttonName);
        } else{
            button.getStylesheets().add(getClass().getResource("flightSeats.css").toExternalForm());
            seatsChosen.add(buttonName);
        }
        System.out.println(button.getId());
    }

    //When the user has finished choosing their seats
    @FXML
    private void done(ActionEvent event){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        ArrayList<String> userLoginInfo = information(stage);
        System.out.println("Username: " + userLoginInfo.get(0) + " Password: " + userLoginInfo.get(1));
    }

    //Exiting the program
    @FXML
    private void exit(ActionEvent event){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    //Getting the user's login info from the last scene
    private ArrayList<String> information(Stage stage){
        ArrayList<String> userLoginInfo = new ArrayList<>();
        User user = (User) stage.getUserData();
        String username = user.getUsername();
        String password = user.getPassword();
        userLoginInfo.add(username);
        userLoginInfo.add(password);
        return userLoginInfo;
    }
}
