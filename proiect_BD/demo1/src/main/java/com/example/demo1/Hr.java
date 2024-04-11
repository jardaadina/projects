package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Hr {

    @FXML
    private Button inapoiButton;
    @FXML
    private Button BGRU;
    @FXML
    private Button BGRUDPHR;
    @FXML
    private Button BGRUMDHR1;
    @FXML
    private Button BGRUDAHR;
    @FXML
    private Button BOFC;
    @FXML
    private Button BOFCSHR;
    @FXML
    private Button BOFCSAHR;
    @FXML
    private Button inapoiMeniuButton;
    @FXML
    public Label numeLabel;

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserData(ResultSet result) throws SQLException {
        String userNume = result.getString("Nume");
        String userPrenume = result.getString("Prenume");
        numeLabel.setText("  " +userNume+" "+userPrenume);
        setId(result.getInt("ID_Utilizator"));
    }

    public void BGRUDPHROnAction(ActionEvent e)throws SQLException{
        fereastraDatePersonale(id);
    }

    public void inapoiButtonOnAction(ActionEvent e){
        Stage stage= (Stage)inapoiButton.getScene().getWindow();
        stage.close();
    }
    public void inapoiMeniuButtonOnAction(ActionEvent e){
        initialize();
        inapoiButton.setVisible(true);
    }

    public void initialize()
    {
        hideButtonBGRU();
        hideButtonOFC();
        inapoiMeniuButton.setVisible(false);
    }

    public void BGRUonAction(ActionEvent e)
    {
        hideButtonBGRU();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBGRU()
    {
        boolean isBGRUPressed = BGRU.isArmed() || BGRU.isPressed();

        BGRUDPHR.setVisible(isBGRUPressed);
        BGRUMDHR1.setVisible(isBGRUPressed);
        BGRUDAHR.setVisible(isBGRUPressed);
        BOFC.setVisible(!isBGRUPressed);
    }

    public void BOFConAction(ActionEvent e)
    {
        hideButtonOFC();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonOFC()
    {
        boolean isBOFCPressed = BOFC.isArmed() || BOFC.isPressed();

        BOFCSHR.setVisible(isBOFCPressed);
        BOFCSAHR.setVisible(isBOFCPressed);
        BGRU.setVisible(!isBOFCPressed);
    }
    public void fereastraDatePersonale(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("datePersonale.fxml"));
            Scene scene = new Scene(date.load(), 1180, 120);
            DatePersonale d = date.getController();
            d.setID(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Date Personale");
            stageDate.setScene(scene);

            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void BGRUMDHR1OnAction(ActionEvent e)throws SQLException{
        fereastraModificaDate(id);
    }

    public void fereastraModificaDate(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("modificadate.fxml"));
            Scene scene = new Scene(date.load(), 440, 400);
            ModificaDate d = date.getController();
            d.setID(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Modifica Date");
            stageDate.setScene(scene);

            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void BOFCSHROnAction(ActionEvent e)throws SQLException{
        fereastraSalariu(id);
    }

    public void fereastraSalariu(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("salariu.fxml"));
            Scene scene = new Scene(date.load(), 490, 280);
            Salariu d = date.getController();
            d.setId(id);
            d.setUserSalariu(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Salariu");
            stageDate.setScene(scene);

            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


    public void BGRUDAHROnAction(ActionEvent e)throws SQLException{
        fereastraDatePersonaleAngajati(id);
    }
    public void fereastraDatePersonaleAngajati(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("datePersonaleAngajati.fxml"));
            Scene scene = new Scene(date.load(), 1150, 307);
            DatePersonaleAngajati d = date.getController();
            d.setID(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Date Personale Angajati");
            stageDate.setScene(scene);

            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void BOFCSAHROnAction(ActionEvent e)throws SQLException{
        fereastraSalariiAngajati(id);
    }

    public void fereastraSalariiAngajati(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("salariiAngajati.fxml"));
            Scene scene = new Scene(date.load(), 600, 400);
            SalariiAngajati d = date.getController();
            d.setID(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Salarii");
            stageDate.setScene(scene);
            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}