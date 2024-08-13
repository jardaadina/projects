package com.example.demo1;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Asistent  {

    @FXML
    private Button inapoiButton;
    @FXML
    private Button BGRU;
    @FXML
    private Button BGRUDPA;
    @FXML
    private Button BGRUMDPA;

    @FXML
    private Button BOFC;
    @FXML
    private Button BOFCSA;
    @FXML
    private Button BGAO;

    @FXML
    private Button BGAOCRA;
    @FXML
    private Button inapoiMeniuButton;
    @FXML
    public Label numeLabel;


    private int id;

    public void setId(int id) {
        this.id = id;
    }
    String userNume;
    String userPrenume;
    public void setUserData(ResultSet result) throws SQLException {
        userNume = result.getString("Nume");
        userPrenume = result.getString("Prenume");
        numeLabel.setText("   " + userNume+" "+userPrenume);
        setId(result.getInt("ID_Utilizator"));
    }
    public void BGRUDPAOnAction(ActionEvent e)throws SQLException{
        fereastraDatePersonale(id);
    }

    public void BGRUMDPAOnAction(ActionEvent e)throws SQLException{
        fereastraModificaDate(id);
    }

    public void inapoiButtonOnAction(ActionEvent e)
    {
        Stage stage= (Stage)inapoiButton.getScene().getWindow();
        stage.close();
    }

    public void inapoiMeniuButtonOnAction(ActionEvent e) throws SQLException,InstantiationException, IllegalAccessException {
        initialize();
        inapoiButton.setVisible(true);
    }

    public void initialize() throws SQLException,InstantiationException, IllegalAccessException {

        hideButtonBGRU();
        hideButtonOFC();
        hideButtonBGAO();
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

        BGRUDPA.setVisible(isBGRUPressed);
        BGRUMDPA.setVisible(isBGRUPressed);
        BGAO.setVisible(!isBGRUPressed);
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

        BOFCSA.setVisible(isBOFCPressed);
        BGRU.setVisible(!isBOFCPressed);
        BGAO.setVisible(!isBOFCPressed);
    }

    public void BGAonAction(ActionEvent e)
    {
        hideButtonBGAO();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBGAO()
    {
        boolean isBGAOPressed = BGAO.isArmed() || BGAO.isPressed();

        BGAOCRA.setVisible(isBGAOPressed);
        BGRU.setVisible(!isBGAOPressed);
        BOFC.setVisible(!isBGAOPressed);
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

    public void BOFCSAOnAction(ActionEvent e)throws SQLException{
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
    public void BGAOCRAOnAction(ActionEvent e)throws SQLException{
        fereastraRaport(id);
    }

    public void fereastraRaport(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("completareRaport.fxml"));
            Scene scene = new Scene(date.load(), 480, 400);
            CompletareRaport d = date.getController();
            d.setId(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Completeaza Raport");
            stageDate.setScene(scene);
            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}