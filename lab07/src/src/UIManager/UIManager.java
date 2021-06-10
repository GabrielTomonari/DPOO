package UIManager;

import HeroManager.PrintableHeroStatus;
import RoomManager.PrintableRoomState;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UIManager implements iUIManager {

    @Override
    public void renderState(PrintableHeroStatus heroStatus, PrintableRoomState roomState, Stage primaryStage) {
        primaryStage.setTitle("Hello from JavaFX!");
        Button button = new Button("Clique Aqui");
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("Aopaaaaa");
            }

        });

        StackPane root = new StackPane();
        root.getChildren().addAll(button);
        primaryStage.setScene(new Scene(root, 300, 255));
        primaryStage.show();
    }

}
