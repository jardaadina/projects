package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {
    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField cnpTextField;
    @FXML
    private PasswordField parolaPasswordField;
    @FXML
    private Label errorLabel;

    public Label getErrorLabel() {
        return errorLabel;
    }



    public void loginButtonOnAction(ActionEvent e){
        if(cnpTextField.getText().isBlank()==false && parolaPasswordField.getText().isBlank()==false){
            // loginMessageLabel.setText("Ai incercat sa te conectezi");
            validateLogin();
        }
        else{
            loginMessageLabel.setText("Completati username-ul si parola!");
        }
    }
    public void cancelButtonOnAction(ActionEvent e){
        Stage stage= (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String verifyLogin = "SELECT ID_Utilizator, Nume, Prenume, Parola, rol_user FROM utilizatori WHERE CNP='"
                + cnpTextField.getText() + "' AND parola='" + parolaPasswordField.getText() + "'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet result = statement.executeQuery(verifyLogin);

            boolean userAuthenticated = false;

            while (result.next()) {
                String userRol = result.getString("rol_user");
                if (parolaPasswordField.getText().equals(result.getString("Parola"))) {
                    userAuthenticated = true;
                    switch (userRol) {
                        case "asistent":
                            fereastraAsistent(result);
                            break;
                        case "medic":
                            fereastraMedic(result);
                            break;
                        case "hr":
                            fereastraHr(result);
                            break;
                        case "receptioner":
                            fereastraReceptioner(result);
                            break;
                        case "admin":
                            fereastraAdmin(result);
                            break;
                        case "superadmin":
                            fereastraSuperadmin(result);
                            break;
                        case "economic":
                            fereastraEconomic(result);
                            break;
                        case "pacient":
                            fereastraPacient(result);
                            break;
                        default:
                            errorLabel.setText("Tip de utilizator necunoscut: " + userRol);
                    }
                } else {
                    errorLabel.setText("Parolă incorectă!");
                }
            }

            if (!userAuthenticated) {
                errorLabel.setText("CNP sau parolă incorecte!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fereastraAsistent( ResultSet result){
        try{
            FXMLLoader asistent = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("asistent.fxml"));
            Scene scene = new Scene(asistent.load(), 600, 400);
            Stage stageAsistent= new Stage();
            stageAsistent.setTitle("Asistent");
            stageAsistent.setScene(scene);
            Asistent asis = asistent.getController();
            // asis.setRezultat(result);
            asis.setUserData(result);
            stageAsistent.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraMedic( ResultSet result){
        try{
            FXMLLoader medic = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("medic.fxml"));
            Scene scene = new Scene(medic.load(), 600, 400);
            Stage stageMedic=new Stage();
            stageMedic.setTitle("Medic");
            stageMedic.setScene(scene);
            Medic m = medic.getController();
            m.setUserData(result);
            stageMedic.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraPacient( ResultSet result){
        try{
            FXMLLoader pacient = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("pacient.fxml"));
            Scene scene = new Scene(pacient.load(), 507, 386);
            Stage stagePacient=new Stage();
            stagePacient.setTitle("Pacient");
            stagePacient.setScene(scene);
            Pacient p = pacient.getController();
            p.setUserData(result);
            stagePacient.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraHr( ResultSet result){
        try{
            FXMLLoader hr = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("hr.fxml"));
            Scene scene = new Scene(hr.load(), 600, 400);
            Stage stageHr=new Stage();
            stageHr.setTitle("HR");
            stageHr.setScene(scene);
            Hr h = hr.getController();
            h.setUserData(result);
            stageHr.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraReceptioner( ResultSet result){
        try{
            FXMLLoader receptioner = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("receptioner.fxml"));
            Scene scene = new Scene(receptioner.load(), 600, 400);
            Stage stagereceptioner=new Stage();
            stagereceptioner.setTitle("Receptioner");
            stagereceptioner.setScene(scene);
            Receptioner r = receptioner.getController();
            r.setUserData(result);
            stagereceptioner.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraEconomic( ResultSet result){
        try{
            FXMLLoader economic = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("economic.fxml"));
            Scene scene = new Scene(economic.load(), 600, 400);
            Stage stageeconomic=new Stage();
            stageeconomic.setTitle("Economic");
            stageeconomic.setScene(scene);
            Economic e = economic.getController();
            e.setUserData(result);
            stageeconomic.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraAdmin( ResultSet result){
        try{
            FXMLLoader admin = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("admin.fxml"));
            Scene scene = new Scene(admin.load(), 600, 400);
            Stage stageadmin=new Stage();
            stageadmin.setTitle("Admin");
            stageadmin.setScene(scene);
            Admin a = admin.getController();
            a.setUserData(result);
            stageadmin.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraSuperadmin( ResultSet result){
        try{
            FXMLLoader superadmin = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("superadmin.fxml"));
            Scene scene = new Scene(superadmin.load(), 600, 400);
            Stage stagesuperadmin=new Stage();
            stagesuperadmin.setTitle("SuperAdmin");
            stagesuperadmin.setScene(scene);
            Superadmin s = superadmin.getController();
            s.setUserData(result);
            stagesuperadmin.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}