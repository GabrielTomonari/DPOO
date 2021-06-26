package UIManager;

import Utils.Direction;

public interface iCommand {
    void setDirection(Direction info);

    Direction getInfo();
}
