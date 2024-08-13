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

public class RaportPacient {

    @FXML
    private TableColumn<DateRapoarte, String> nume;

    @FXML
    private TableColumn<DateRapoarte, String> prenume;

    @FXML
    private TableColumn<DateRapoarte, String> continut;

    @FXML
    private TableColumn<DateRapoarte, String> parafa;

    @FXML
    private Button inapoiProgramari;


    @FXML
    private TableColumn<DateRapoarte, String> id_raport;

    @FXML
    private TableView<DateRapoarte> raportPacient;


    public void cancelButtonOnAction(ActionEvent e){
        Stage stage= (Stage) inapoiProgramari.getScene().getWindow();
        stage.close();
    }

    private int id;
    public void setID(int id) throws SQLException {
        this.id=id;
        dateTabelRapoarte(id);
    }

    ObservableList<DateRapoarte> listR= FXCollections.observableArrayList();

    public void dateTabelRapoarte(int id) throws SQLException
    {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String getData = "SELECT u.nume, u.prenume, r.Continut, r.ID_Raport FROM utilizatori u JOIN pacienti p ON u.ID_Utilizator = p.ID_Utilizator\n" +
                "                JOIN programari prog ON prog.ID_Pacient=p.ID_Pacient\n" +
                "                JOIN rapoartemedicale r ON prog.ID_Programare = r.ID_Programare\n" +
                "                WHERE u.ID_Utilizator = ?;\n";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(getData))
        {

            preparedStatement.setInt(1, id); // Setăm valoarea pentru parametrul ID_Utilizator

            try (ResultSet result2 = preparedStatement.executeQuery())
            {

                while (result2.next())
                {
                    String userNume = result2.getString("Nume");
                    String userPrenume = result2.getString("Prenume");
                    String userContinut = result2.getString("Continut");
                    String userRaport= result2.getString("ID_Raport");
                    String userParafa= result2.getString("ID_Raport");

                    listR.add(new DateRapoarte(userNume, userPrenume, userContinut, userRaport,userParafa));
                }

                nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
                prenume.setCellValueFactory(new PropertyValueFactory<>("prenume"));
                continut.setCellValueFactory(new PropertyValueFactory<>("continut"));
                id_raport.setCellValueFactory(new PropertyValueFactory<>("raport"));


                raportPacient.setItems(listR);

            } catch (SQLException e)
            {
                Logger.getLogger(DateRapoarte.class.getName()).log(Level.SEVERE, null, e);
                e.printStackTrace();
            }
        }


    }

}