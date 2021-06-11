package UIManager;

import HeroManager.PrintableHeroStatus;
import RoomManager.PrintableRoomState;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UIManager implements iUIManager {
    // screen constants
    private double screenWidth = 1024;
    private double screenHeigth = 1024;
    private String screenTitle = "POOtencial Evolutivo - by DPOO";
    int contador = 0;

    // JavaFX Stages and Scene
    private Stage primaryStage;
    private Scene currentScene;
    private Group bgRoot;

    int start = 0;

    @Override
    public void updateState(PrintableHeroStatus heroStatus, PrintableRoomState roomState) {
        this.clearScreen();
        Image imageHero = new Image("file:assets/img/Character.png");
        ImageView heroView = new ImageView(imageHero);
        heroView.setX(start);
        heroView.setY(start);

        start += 10;

        this.bgRoot.getChildren().add(heroView);
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

    private void clearScreen() {
        this.bgRoot.getChildren().clear();
        Image imageBG = new Image("file:assets/img/Grass.png");
        ImageView bgView = new ImageView(imageBG);
        this.bgRoot.getChildren().add(bgView);

        Button button = new Button("Click Me");
        button.setOnAction(event -> {
            this.updateState(null, null);
        });
        this.bgRoot.getChildren().add(button);
    }

    private void initialConfigure() {
        primaryStage.setTitle(this.screenTitle);
        this.bgRoot = new Group();
        this.clearScreen();
        this.currentScene = new Scene(this.bgRoot, this.screenWidth, this.screenHeigth);
    }

}
