package com.example.shopvideocard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class avtorez {

    @FXML
    private TextField log;

    @FXML
    private TextField pas;

    @FXML
    private Button reg1;

    @FXML
    private Button vhod;

    @FXML
    void initialize() {
        vhod.setOnAction(click -> { //проверка логина и пароля пользователя
            vhod.setText("Добро пожаловать");
            System.out.println("Логин:" + log.getText());
            System.out.println("Пароль:" + pas.getText());
            vhod.getScene().getWindow().hide();
            try (
                    BufferedReader reader = new BufferedReader(new FileReader("D:\\dowlond\\kursach\\Shop-Video-Cards-master\\src\\main\\java\\com\\example\\shopvideocard\\log.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals(pas.getText().trim())) {
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("3okno.fxml"));
                            loader.load();
                            Parent root = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("Верный пароль");
                    }
                }
            } catch (
                    FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (
                    IOException e) {
                throw new RuntimeException(e);
            }
            try (
                    BufferedReader reader = new BufferedReader(new FileReader("D:\\dowlond\\kursach\\Shop-Video-Cards-master\\src\\main\\java\\com\\example\\shopvideocard\\pass.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals(log.getText().trim())) {
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.load();
                            Parent root = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("Верный логин");
                    }
                }
            } catch (
                    FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (
                    IOException e) {
                throw new RuntimeException(e);
            }
        });
        reg1.setOnAction(clic -> {
            reg1.getScene().getWindow().hide();
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("2okno.fxml"));
                //возвращение на окно авторизации при возникновения ошибки
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
