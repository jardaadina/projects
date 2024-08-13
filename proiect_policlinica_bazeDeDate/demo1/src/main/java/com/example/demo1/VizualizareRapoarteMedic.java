package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VizualizareRapoarteMedic {

    @FXML
    private TableColumn<DateRapoarte,String> continut;

    @FXML
    private TableColumn<DateRapoarte,String> id_raport;

    @FXML
    private Button inapoiProgramari;
    @FXML
    private Button valideaza;

    @FXML
    private TableColumn<DateRapoarte,String> nume;

    @FXML
    private TableColumn<DateRapoarte,String> prenume;

    @FXML
    private TableView<DateRapoarte> raportPacient;
    @FXML
    private Label text;
    @FXML
    private TableColumn<DateRapoarte, String> parafa;

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage= (Stage) inapoiProgramari.getScene().getWindow();
        stage.close();
    }

    private int id;
    public void setID(int id) throws SQLException {
        this.id=id;
        String par="-";
        dateTabelRapoarteMedici(id,par);
    }

    ObservableList<DateRapoarte> listP= FXCollections.observableArrayList();

    public void valideazaOnAction(ActionEvent e) throws SQLException {
            puneParafa(id);
    }
    public void dateTabelRapoarteMedici(int id,String par) throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String getData = "SELECT u.nume, u.prenume, r.Continut, r.ID_Raport \n" +
                "FROM programari prog JOIN rapoartemedicale r ON r.ID_Programare=prog.ID_Programare\n" +
                "JOIN pacienti pac on pac.ID_Pacient=prog.ID_Pacient\n" +
                "JOIN utilizatori u on pac.ID_Utilizator=u.ID_Utilizator\n" +
                "Join medici m on r.ID_Medic=m.ID_Medic\n" +
                "JOIN angajati a on a.ID_Angajat=m.ID_Angajat\n" +
                "WHERE a.ID_Utilizator= ?";


        try (PreparedStatement preparedStatement = connectDB.prepareStatement(getData)) {
           // for(int i=1;i<150;i++) {

                preparedStatement.setInt(1, id); // Setăm valoarea pentru parametrul ID_Utilizator

                try (ResultSet result2 = preparedStatement.executeQuery()) {

                    while (result2.next()) {
                        String userNume = result2.getString("Nume");
                        String userPrenume = result2.getString("Prenume");
                        String userContinut = result2.getString("Continut");
                        String userIdRaport = result2.getString("ID_Raport");
                        String userParafa = par;
                        listP.add(new DateRapoarte(userNume, userPrenume, userContinut, userIdRaport,userParafa));
                    }

                    nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
                    prenume.setCellValueFactory(new PropertyValueFactory<>("prenume"));
                    continut.setCellValueFactory(new PropertyValueFactory<>("continut"));
                    id_raport.setCellValueFactory(new PropertyValueFactory<>("raport"));
                    parafa.setCellValueFactory(new PropertyValueFactory<>("parafa"));


                    raportPacient.setItems(listP);

                } catch (SQLException e) {
                    Logger.getLogger(DateRapoarte.class.getName()).log(Level.SEVERE, null, e);
                    e.printStackTrace();
                }
            //}

        }
    }
    public void puneParafa(int id) throws SQLException{
        String codParafa="-";

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String getData="SELECT m.Cod_Parafa\n" +
                "FROM medici m\n" +
                "JOIN angajati a ON m.ID_Angajat = a.ID_Angajat\n" +
                "JOIN utilizatori u ON a.ID_Utilizator = u.ID_Utilizator\n" +
                "WHERE u.ID_Utilizator =?";
        try (PreparedStatement preparedStatement = connectDB.prepareStatement(getData)) {

            preparedStatement.setInt(1, id); // Setăm valoarea pentru parametrul ID_Utilizator
            try (ResultSet result2 = preparedStatement.executeQuery()) {

                while (result2.next()) {
                    codParafa = result2.getString("Cod_Parafa");
                }

            } catch (SQLException e) {
                Logger.getLogger(DateRapoarte.class.getName()).log(Level.SEVERE, null, e);
                e.printStackTrace();
            }
        }


            raportPacient.getItems().clear();


        dateTabelRapoarteMedici(id,codParafa);
        text.setText("Rapoarte validate cu succes");
    }

}
