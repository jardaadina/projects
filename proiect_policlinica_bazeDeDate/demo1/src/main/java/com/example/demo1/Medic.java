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

public class Medic {

    @FXML
    private Button inapoiButton;
    @FXML
    private Button BGRU;
    @FXML
    private Button BGRUDPM;
    @FXML
    private Button BGRUMDPM;
    @FXML
    private Button BGRUCM;
    @FXML
    private Button BOFC;
    @FXML
    private Button BOFCPPM;
    @FXML
    private Button BOFCPAPM;
    @FXML
    private Button BOFCSM;
    @FXML
    private Button BGAO;
    @FXML
    private Button BGAOVPM;
    @FXML
    private Button BGAOGRMM;
    @FXML
    private Button inapoiMeniuButton;
    @FXML
    private Button salariuOra;
    @FXML
    public Label numeLabel;

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserData(ResultSet result) throws SQLException {
        String userNume = result.getString("Nume");
        String userPrenume = result.getString("Prenume");
        numeLabel.setText("   "+userNume+" "+userPrenume);
        setId(result.getInt("ID_Utilizator"));
    }
    public void BGRUDPMOnAction(ActionEvent e)throws SQLException{
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

        BGRUDPM.setVisible(isBGRUPressed);
        BGRUMDPM.setVisible(isBGRUPressed);
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

        BOFCPPM.setVisible(isBOFCPressed);
        BOFCPAPM.setVisible(isBOFCPressed);
        BOFCSM.setVisible(isBOFCPressed);
        salariuOra.setVisible(isBOFCPressed);
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

        BGAOVPM.setVisible(isBGAOPressed);
        BGAOGRMM.setVisible(isBGAOPressed);
        BGRU.setVisible(!isBGAOPressed);
        BOFC.setVisible(!isBGAOPressed);
    }

    public void fereastraDatePersonale(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("datePersonale.fxml"));
            Scene scene = new Scene(date.load(), 1170, 120);
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


    public void BGRUMDPMOnAction(ActionEvent e)throws SQLException{
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

    public void BOFCSMOnAction(ActionEvent e)throws SQLException{
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

    public void BGAOVPMOnAction(ActionEvent e)throws SQLException{
        fereastraProgramari(id);
    }

    public void fereastraProgramari(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("vizualizareprogramariMedici.fxml"));
            Scene scene = new Scene(date.load(), 600, 370);
            VizualizareProgramariMedici d = date.getController();
            d.setID(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Vizualizare Programari");
            stageDate.setScene(scene);

            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void BGAOGRMMOnAction(ActionEvent e)throws SQLException{
        fereastraRapoarte(id);
    }

    public void fereastraRapoarte(int id) {
        try {
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("raportMedici.fxml"));
            Scene scene = new Scene(date.load(), 600, 400);
            VizualizareRapoarteMedic d = date.getController();
            d.setID(id);
            Stage stageDate = new Stage();
            stageDate.setTitle("Rapoarte Medicale");
            stageDate.setScene(scene);

            stageDate.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void BOFCPPMOnAction(ActionEvent e)throws SQLException{
        fereastraProfitMedic(id);
    }

    public void fereastraProfitMedic(int id) {
        try {
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("profitMedic.fxml"));
            Scene scene = new Scene(date.load(), 488, 308);
            ProfitMedic d = date.getController();
            d.setID(id);
            d.setUserProfitMedic(id);
            Stage stageDate = new Stage();
            stageDate.setTitle("Profit personal");
            stageDate.setScene(scene);

            stageDate.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void BOFCPAPMOnAction(ActionEvent e)throws SQLException{
        fereastraProfitAdus(id);
    }

    public void fereastraProfitAdus(int id) {
        try {
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("profitAdus.fxml"));
            Scene scene = new Scene(date.load(), 488, 308);
            ProfitAdus d = date.getController();
            d.setId(id);
            d.setUserProfitAdus(id);
            Stage stageDate = new Stage();
            stageDate.setTitle("Profit adus policlinicii");
            stageDate.setScene(scene);

            stageDate.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void salariuOraOnAction(ActionEvent e)throws SQLException{
        fereastraSlariuPeOra(id);
    }

    public void fereastraSlariuPeOra(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("salariuPeOra.fxml"));
            Scene scene = new Scene(date.load(), 490, 280);
            SalariuPeOra d = date.getController();
            d.setID(id);
            d.setUserSalariuPeOra(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Profitul pe ora");
            stageDate.setScene(scene);

            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}