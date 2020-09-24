package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

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
    public void register(ActionEvent event){
        ArrayList<String> newUsernameAndPassword = getUsernameAndPassword();
        String new_email = newUsernameAndPassword.get(0);
        String new_password = newUsernameAndPassword.get(1);
        System.out.println(new_email + " " + new_password);
    }

    //login into the application
    public void login(ActionEvent event){
        ArrayList<String> existingUsernameAndPassword = getUsernameAndPassword();
        String existingEmail = existingUsernameAndPassword.get(0);
        String existingPassword = existingUsernameAndPassword.get(1);
        System.out.println(existingEmail + ' ' + existingPassword);
    }

}
