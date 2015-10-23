package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;


public class Controller {

    private double midaFont;
    public TextArea texto;
    public Button botoTallar;
    public Button botoCopiar;
    public Button botoEnganxar;
    private double fontSize;
    public MenuItem editarCopiar;
    public MenuItem editarEnganxar;

    public void initialize(){
        fontSize = texto.getFont().getSize();
        botoTallar.setGraphic(new ImageView("cut.png"));
        botoCopiar.setGraphic(new ImageView("copy.png"));
        botoEnganxar.setGraphic(new ImageView("paste.png"));
    }

    public void deshabilitar(Event event){
        if(texto.getSelectedText().equals("")){
            editarCopiar.setDisable(true);
            editarEnganxar.setDisable(true);
        }
        else{
            editarCopiar.setDisable(false);
            editarEnganxar.setDisable(false);
        }
    }


    public void sortir(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void copiarText(ActionEvent actionEvent) {
        texto.copy();
    }

    public void tallarText(ActionEvent actionEvent) {
        texto.cut();
    }

    public void enganxarText(ActionEvent actionEvent) {
        texto.paste();
    }

    public void desferText(ActionEvent actionEvent) {
        texto.undo();
    }

    public void agumentarMida(ActionEvent actionEvent) {
        midaFont = texto.getFont().getSize();
        midaFont++;
        texto.setFont(new Font(midaFont));
    }

    public void reduirMida(ActionEvent actionEvent) {
        midaFont = texto.getFont().getSize();
        midaFont--;
        texto.setFont(new Font(midaFont));
    }


    public void establirFont(ActionEvent actionEvent) {
        texto.setFont(new Font("DejaVu Sans Bold", fontSize));
    }

    public void about(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("I have a great message for you!");
        alert.showAndWait();
    }
}