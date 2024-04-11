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

public class Superadmin
{
    @FXML
    private Button inapoiButton;
    @FXML
    private Button BDPSUPADMIN;
    @FXML
    private Button BMDPSUPADMIN;
    @FXML
    private Button BADSSUPADMIN;
    @FXML
    private Button BMDSSUPADMIN;
    @FXML
    private Button BSDSSUPADMIN;
    @FXML
    private Button BVDSSupAdmin;
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
        numeLabel.setText("   " +userNume+" "+userPrenume);
        setId(result.getInt("ID_Utilizator"));
    }

    public void inapoiButtonOnAction(ActionEvent e)
    {
        Stage stage= (Stage)inapoiButton.getScene().getWindow();
        stage.close();
    }

    public void inapoiMeniuButtonOnAction(ActionEvent e){
        initialize();
        inapoiButton.setVisible(true);
    }

    public void initialize()
    {
        hideButtonBDPSUPADMIN();
        hideButtonBMDPSUPADMIN();
        hideButtonBADSSUPADMIN();
        hideButtonBMDSSUPADMIN();
        hideButtonBSDSSUPADMIN();
        inapoiMeniuButton.setVisible(false);
    }
    public void BDPSUPADMINonAction(ActionEvent e)
    {
      //  hideButtonBDPSUPADMIN();
      //  inapoiMeniuButton.setVisible(true);
       // inapoiButton.setVisible(false);
        fereastraDatePersonale(id);
    }

    private void hideButtonBDPSUPADMIN()
    {
        boolean isBDPSUPADMINoNPressed = BDPSUPADMIN.isArmed() || BDPSUPADMIN.isPressed();

        BMDPSUPADMIN.setVisible(!isBDPSUPADMINoNPressed);
        BADSSUPADMIN.setVisible(!isBDPSUPADMINoNPressed);
        BMDSSUPADMIN.setVisible(!isBDPSUPADMINoNPressed);
        BSDSSUPADMIN.setVisible(!isBDPSUPADMINoNPressed);
    }

    public void BMDPSUPADMINonAction(ActionEvent e)
    {
       // hideButtonBMDPSUPADMIN();
       // inapoiMeniuButton.setVisible(true);
        //inapoiButton.setVisible(false);
        fereastraModificaDate(id);
    }

    private void hideButtonBMDPSUPADMIN()
    {
        boolean isBMDPSUPADMINPressed = BMDPSUPADMIN.isArmed() || BMDPSUPADMIN.isPressed();

        BDPSUPADMIN.setVisible(!isBMDPSUPADMINPressed);
        BADSSUPADMIN.setVisible(!isBMDPSUPADMINPressed);
        BMDSSUPADMIN.setVisible(!isBMDPSUPADMINPressed);
        BSDSSUPADMIN.setVisible(!isBMDPSUPADMINPressed);
    }


    private void hideButtonBADSSUPADMIN()
    {
        boolean isBADSSUPADMINPressed = BADSSUPADMIN.isArmed() || BADSSUPADMIN.isPressed();

        BDPSUPADMIN.setVisible(!isBADSSUPADMINPressed);
        BMDPSUPADMIN.setVisible(!isBADSSUPADMINPressed);
        BMDSSUPADMIN.setVisible(!isBADSSUPADMINPressed);
        BSDSSUPADMIN.setVisible(!isBADSSUPADMINPressed);
    }

    public void BMDSSUPADMINonAction(ActionEvent e)
    {
        hideButtonBMDSSUPADMIN();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBMDSSUPADMIN()
    {
        boolean isBMDSSUPADMINPressed = BMDSSUPADMIN.isArmed() || BMDSSUPADMIN.isPressed();

        BDPSUPADMIN.setVisible(!isBMDSSUPADMINPressed);
        BMDPSUPADMIN.setVisible(!isBMDSSUPADMINPressed);
        BADSSUPADMIN.setVisible(!isBMDSSUPADMINPressed);
        BSDSSUPADMIN.setVisible(!isBMDSSUPADMINPressed);
    }

    public void BSDSSUPADMINonAction(ActionEvent e)
    {
       // hideButtonBSDSSUPADMIN();
        //inapoiMeniuButton.setVisible(true);
      //  inapoiButton.setVisible(false);
        fereastraStergeDateSistem(id);
    }

    private void hideButtonBSDSSUPADMIN()
    {
        boolean isBSDSSUPADMINPressed = BSDSSUPADMIN.isArmed() || BSDSSUPADMIN.isPressed();

        BDPSUPADMIN.setVisible(!isBSDSSUPADMINPressed);
        BMDPSUPADMIN.setVisible(!isBSDSSUPADMINPressed);
        BADSSUPADMIN.setVisible(!isBSDSSUPADMINPressed);
        BMDSSUPADMIN.setVisible(!isBSDSSUPADMINPressed);
    }

    public void BADSSUPADMINOnAction(ActionEvent e)throws SQLException{
        fereastraAdaugaDateSistem1(id);
        fereastraAdaugaDateSistem2(id);
        fereastraAdaugaDateSistem3(id);
    }

    public void BVDSSupAdminOnAction(ActionEvent e)throws SQLException{
        fereastraDatePersonaleAngajati(id);
    }
    public void fereastraAdaugaDateSistem1(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("adaugadatesistem.fxml"));
            Scene scene = new Scene(date.load(), 480, 580);
            AdaugaDateSistem d = date.getController();
            d.setID(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Adauga Hr, Economic, Receptioner, Admin");
            stageDate.setScene(scene);

            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void fereastraAdaugaDateSistem2(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("adaugadatesistemMedic.fxml"));
            Scene scene = new Scene(date.load(), 700, 580);
            AdaugaDateSistem d = date.getController();
            d.setID(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Adauga Medic ");
            stageDate.setScene(scene);

            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraAdaugaDateSistem3(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("adaugadatesistemAsistent.fxml"));
            Scene scene = new Scene(date.load(), 700, 580);
            AdaugaDateSistem d = date.getController();
            d.setID(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Adauga Asistent Medical ");
            stageDate.setScene(scene);

            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
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


    public void BMDSSUPADMINOnAction(ActionEvent e)throws SQLException{
        fereastraModificaDateSistem1(id);
        fereastraModificaDateSistem2(id);
        fereastraModificaDateSistem3(id);
    }

    public void fereastraModificaDateSistem1(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("modificadatesistem.fxml"));
            Scene scene = new Scene(date.load(), 480, 580);
            ModificaDateSistem d = date.getController();
            d.setID(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Modifica Admin, Hr, Economic, Receptioner ");
            stageDate.setScene(scene);

            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void fereastraModificaDateSistem2(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("modificadatesistemMedic.fxml"));
            Scene scene = new Scene(date.load(), 700, 580);
            ModificaDateSistem d = date.getController();
            d.setID(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Modifica Medic  ");
            stageDate.setScene(scene);

            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void fereastraModificaDateSistem3(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("modificadatesistemAsistent.fxml"));
            Scene scene = new Scene(date.load(), 700, 580);
            ModificaDateSistem d = date.getController();
            d.setID(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Modifica Asistent Medical ");
            stageDate.setScene(scene);

            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
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

    public void fereastraStergeDateSistem(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("stergeDateSistem.fxml"));
            Scene scene = new Scene(date.load(), 480, 300);
            StergeDateSistem d = date.getController();
            d.setID(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Sterge datele din sistem ");
            stageDate.setScene(scene);

            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}