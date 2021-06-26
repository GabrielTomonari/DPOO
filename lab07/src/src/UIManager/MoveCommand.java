package UIManager;

import Utils.Direction;

public class MoveCommand implements iCommand {
    Direction info;

    @Override
    public Direction getInfo() {
        return this.info;
    }

    public void setDirection(Direction info) {
        this.info = info;
    }

}
