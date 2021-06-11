package UIManager;

import HeroManager.PrintableHeroStatus;
import RoomManager.PrintableRoomState;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UIManager implements iUIManager {
    // screen constants
    private double screenWidth = 500;
    private double screenHeigth = 500;
    private String screenTitle = "Hello from JavaFX!";
    int contador = 0;

    // JavaFX Stages and Scene
    private Stage primaryStage;
    private Scene currentScene;

    @Override
    public void updateState(PrintableHeroStatus heroStatus, PrintableRoomState roomState) {

    }

    @Override
    public void setStage(Stage stage) {
        this.primaryStage = stage;
        this.initialConfigure();
    }

    @Override
    public void render() {
        primaryStage.setScene(this.currentScene);
        primaryStage.show();
    }

    private void initialConfigure() {
        primaryStage.setTitle(this.screenTitle);
        StackPane root = new StackPane();
        this.currentScene = new Scene(root, this.screenWidth, this.screenHeigth);
    }

}
