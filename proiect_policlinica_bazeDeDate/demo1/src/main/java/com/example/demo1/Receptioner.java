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

public class Receptioner {

    @FXML
    private Button inapoiButton;
    @FXML
    private Button BGRU;
    @FXML
    private Button BGRUDPR;
    @FXML
    private Button BGRUMDPR;
    @FXML
    private Button BGRUCR;
    @FXML
    private Button BOFC;
    @FXML
    private Button BOFCVSR;
    @FXML
    private Button BGAO;
    @FXML
    private Button BGAOCPR;
    @FXML
    private Button BGAOEBFR;
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

    public void BGRUDPROnAction(ActionEvent e)throws SQLException{
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

        BGRUDPR.setVisible(isBGRUPressed);
        BGRUMDPR.setVisible(isBGRUPressed);
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

        BOFCVSR.setVisible(isBOFCPressed);
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

        BGAOCPR.setVisible(isBGAOPressed);
        BGAOEBFR.setVisible(isBGAOPressed);
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

    public void BGRUMDPROnAction(ActionEvent e)throws SQLException{
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

    public void BOFCVSROnAction(ActionEvent e)throws SQLException{
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
            stageDate.setTitle("Modifica Date");
            stageDate.setScene(scene);

            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void BGAOCPROnAction(ActionEvent e)throws SQLException{
        fereastraProgramareNoua(id);
    }

    public void fereastraProgramareNoua(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("programareNoua.fxml"));
            Scene scene = new Scene(date.load(), 440, 400);
            ProgramareNoua d = date.getController();
            d.setId(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Programare noua");
            stageDate.setScene(scene);
            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void BGAOEBFROnAction(ActionEvent e)throws SQLException{
        fereastraEmiteBon(id);
    }

    public void fereastraEmiteBon(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("bon.fxml"));
            Scene scene = new Scene(date.load(), 440, 400);
            CompleteazaBon d = date.getController();
            d.setId(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Emitere Bon");
            stageDate.setScene(scene);
            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
