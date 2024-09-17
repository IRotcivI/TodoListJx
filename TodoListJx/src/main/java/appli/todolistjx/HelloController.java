package appli.todolistjx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label errorText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        System.out.println(onHelloButtonClick());
    }

    @FXML
    protected void onErrorButton()
    {
        if (errorText.getText().isEmpty())
        {
            errorText.setText("Erreur!");
        }
        else
        {
            errorText.setText("");
        }
        System.out.println(onErrorButton(););
    }


}