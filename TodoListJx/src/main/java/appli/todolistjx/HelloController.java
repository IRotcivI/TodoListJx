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
       HelloApplication.changerScene("inscriptionView.fxml");
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
        System.out.println();
    }


}