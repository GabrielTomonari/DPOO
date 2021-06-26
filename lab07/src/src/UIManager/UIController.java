package UIManager;

import Utils.Direction;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class UIController extends DirectionObservable {
    Scene scene;
    Direction command;

    public UIController(Scene scene) {
        this.scene = scene;
    }

    @Override
    protected void notifyCommand() {
        for (iDirectionObserver observer : observers) {
            observer.update(this.command);
        }
    }

    private void handleKeyBoard(KeyEvent event) {
        switch (event.getCode()) {
            case W:
            case UP:
                this.command = Direction.Up;
                notifyCommand();
                break;
            case S:
            case DOWN:
                this.command = Direction.Down;
                notifyCommand();
                break;
            case LEFT:
            case A:
                this.command = Direction.Left;
                notifyCommand();
                break;
            case RIGHT:
            case D:
                this.command = Direction.Rigth;
                notifyCommand();
                break;
            default:
                break;
        }
    }

    public void configKeyBoard() {
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                handleKeyBoard(event);
            }
        });
    }
}
