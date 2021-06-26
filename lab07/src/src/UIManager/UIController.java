package UIManager;

import Utils.Direction;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class UIController extends CommandObservable {
    Scene scene;
    iCommand command;

    public UIController(Scene scene) {
        this.scene = scene;
        this.command = new MoveCommand();
    }

    @Override
    protected void notifyCommand() {
        for (iCommandObserver observer : observers) {
            observer.update(this.command);
        }
    }

    private void handleKeyBoard(KeyEvent event) {
        switch (event.getCode()) {
            case W:
            case UP:
                this.command.setDirection(Direction.Up);
                notifyCommand();
                break;
            case S:
            case DOWN:
                this.command.setDirection(Direction.Down);
                notifyCommand();
                break;
            case LEFT:
            case A:
                this.command.setDirection(Direction.Left);
                notifyCommand();
                break;
            case RIGHT:
            case D:
                this.command.setDirection(Direction.Rigth);
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
