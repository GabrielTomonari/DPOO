package BoardManager;

public class ObstacleCell implements iCell {

    @Override
    public void activateInteraction(BoardController controller) {
        System.out.println("Ops can't go there");
    }

    @Override
    public String getCellImage() {
        // TODO Auto-generated method stub
        return null;
    }

}