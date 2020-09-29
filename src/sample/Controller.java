package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Controller {
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private Label exists;

    //Getting the input from the text boxes
    private ArrayList<String> getUsernameAndPassword(){
        String user = username.getText();
        String pass = password.getText();
        ArrayList<String> information = new ArrayList<>();
        information.add(user);
        information.add(pass);
        return information;
    }

    //Register an account
    public void register() throws SQLException {
        ArrayList<String> newUsernameAndPassword = getUsernameAndPassword();
        String new_email = newUsernameAndPassword.get(0);
        String new_password = newUsernameAndPassword.get(1);
        System.out.println(new_email + " " + new_password);
        //Handling if the username and password already exist
        if (sql_queries.checkIfExists(new_email, new_password) == false){
            sql_queries.registerNameAndPassword(new_email, new_password);
        } else {
            exists.setText("That email has already been registered.");
        }
    }

    //login into the application
    public void login(ActionEvent event) throws IOException, SQLException {
        ArrayList<String> existingUsernameAndPassword = getUsernameAndPassword();
        String existingEmail = existingUsernameAndPassword.get(0);
        String existingPassword = existingUsernameAndPassword.get(1);
        System.out.println(existingEmail + ' ' + existingPassword);

        //Making sure the user has correctly entered their username and password
        if (sql_queries.checkIfExists(existingEmail, existingPassword) == true){
            //Switching to the flight_seats page
            Parent root = FXMLLoader.load(getClass().getResource("flight_seats.fxml"));
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();




            stage.setScene(new Scene(root));
            //Making a user class so the information can be passed into the next window
            User user = new User(existingEmail, existingPassword);
            //Passing the information to the next scene
            stage.setUserData(user);
            stage.show();
        } else {
            exists.setText("This email is either not registered or the password has been incorrectly entered");
        }
    }



}
