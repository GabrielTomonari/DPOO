package UIManager;

import BoardManager.PrintableBoardState;
import HeroManager.PrintableHeroStatus;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class UIManager implements iUIManager {
    // screen constants
    private double screenWidth = 1024;
    private double screenHeigth = 728;
    private int cellsInColumn = 16;
    private int cellsInLine = 16;
    private double cellHeigth = this.screenHeigth / this.cellsInColumn;
    private double cellWidth = this.cellHeigth;
    private String screenTitle = "POOtencial Evolutivo - by DPOO";

    // JavaFX Stuffs
    private GameTimer timer;
    private Stage primaryStage;
    private Scene currentScene;
    private Group bgRoot;

    @Override
    public void updateState(PrintableHeroStatus heroStatus, PrintableBoardState roomState) {
        this.clearScreen();
        ImageView heroView = getHeroView(heroStatus);
        ImageView[] roomElements = getRoomElements(roomState);
        this.bgRoot.getChildren().addAll(roomElements);
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
        ImageView bgView = this.getBackGroundView();
        this.bgRoot.getChildren().add(bgView);
    }

    private void initialConfigure() {
        // generate the first scene
        primaryStage.setTitle(this.screenTitle);
        primaryStage.setResizable(false);
        this.bgRoot = new Group();
        this.clearScreen();
        this.currentScene = new Scene(this.bgRoot, this.screenWidth, this.screenHeigth);

        // conect the ui with timer so it render on every new frame
        this.timer = new GameTimer();
        this.timer.connect(this);
        this.timer.start();
    }

    // TODO: maybe become class?
    private ImageView getBackGroundView() {
        Image imageBG = new Image("file:assets/img/Grass.png");
        ImageView bgView = new ImageView(imageBG);
        bgView.setPreserveRatio(true);
        bgView.setFitHeight(this.screenHeigth);
        return bgView;
    }

    // TODO: maybe become class?
    private ImageView getHeroView(PrintableHeroStatus heroStatus) {
        Image imageHero = new Image("file:assets/img/Character.png");
        ImageView heroView = new ImageView(imageHero);

        heroView.setPreserveRatio(true);
        heroView.setFitHeight(this.cellHeigth);

        heroView.setX(heroStatus.position.column * this.cellWidth);
        heroView.setY(heroStatus.position.line * this.cellHeigth);

        return heroView;
    }

    // TODO: maybe become class?
    private ImageView[] getRoomElements(PrintableBoardState roomState) {
        ImageView[] elements = new ImageView[this.cellsInColumn * this.cellsInLine];

        roomState.resetCounter();
        while (roomState.shouldPrintNext()) {
            Image img = new Image(roomState.getCurrentImage());
            ImageView newElement = new ImageView(img);

            newElement.setPreserveRatio(true);
            newElement.setFitHeight(this.cellHeigth);
            newElement.setX(roomState.currentColumn() * this.cellWidth);
            newElement.setY(roomState.currentLine() * this.cellHeigth);

            elements[(roomState.currentLine() * this.cellsInLine) + roomState.currentColumn()] = newElement;
            roomState.changeToNextImage();
        }

        return elements;
    }
}
