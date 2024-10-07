package appli.todolistjx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        this.mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 170, 400);
        this.mainStage.setTitle("JavaFX!");
        this.mainStage.setScene(scene);
        this.mainStage.show();
    }
    public void changeScene(String inscription) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("inscriptionView.fxml"));
        Scene registerScene = new Scene(fxmlLoader.load(), 170, 400);
        this.mainStage.setScene(registerScene);
        this.mainStage.show();
    }

    public static void changerScene(String inscriptionView) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(inscriptionView));

            Scene newScene = new Scene(fxmlLoader.load());

            mainStage.setScene(newScene);

            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    public static void main(String[] args) {
        launch();
    }


}