package com.example.shopvideocard;

        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextField;
        import javafx.stage.Stage;

        import java.io.BufferedWriter;
        import java.io.FileWriter;
        import java.io.IOException;

public class register {

    @FXML
    private TextField log2;

    @FXML
    private TextField pas2;

    @FXML
    private Button reg2;

    @FXML
    void initialize() {
        reg2.setOnAction(click -> {
            System.out.println("Логин:" + log2.getText());
            System.out.println("Пароль:" + pas2.getText());
            reg2.getScene().getWindow().hide();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\dowlond\\kursach\\Shop-Video-Cards-master\\src\\main\\java\\com\\example\\shopvideocard\\log.txt"))) {
                writer.write(log2.getText());
                writer.newLine();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("1okno.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\dowlond\\kursach\\Shop-Video-Cards-master\\src\\main\\java\\com\\example\\shopvideocard\\pass.txt"))) {
                writer.write(pas2.getText());
                writer.newLine();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("1okno.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
    }
}