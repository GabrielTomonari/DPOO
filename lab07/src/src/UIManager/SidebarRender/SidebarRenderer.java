package UIManager.SidebarRender;

import HeroManager.PrintableHeroStatus;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SidebarRenderer {
    private Group bgRoot;
    private PrintableHeroStatus heroStatus;

    public SidebarRenderer(Group bgRoot, PrintableHeroStatus heroStatus) {
        this.bgRoot = bgRoot;
        this.heroStatus = heroStatus;
    }

    public void renderSidebar() {
        ImageView sidebarView = this.getSideBarView();
        this.bgRoot.getChildren().add(sidebarView);

        ImageView[] foodElements = getFoodElements();
        this.bgRoot.getChildren().addAll(foodElements);

        ImageView lifeBar = getLifeBar();
        this.bgRoot.getChildren().add(lifeBar);
        Text lifeValue = getLifeValue();
        this.bgRoot.getChildren().add(lifeValue);

        ImageView energyBar = getEnergyBar();
        this.bgRoot.getChildren().add(energyBar);
        Text energyValue = getEnergyValue();
        this.bgRoot.getChildren().add(energyValue);

        Text xpValue = getXpValue();
        this.bgRoot.getChildren().add(xpValue);

        Text levelValue = getLevelValue();
        this.bgRoot.getChildren().add(levelValue);
    }

    private Text getLevelValue() {
        Text value = new Text();

        value.setText(Integer.toString(this.heroStatus.currentLevel));
        this.setBaseTextStyle(value);
        value.setX(905);
        value.setY(460);

        return value;
    }

    private Text getXpValue() {
        Text value = new Text();

        value.setText(Integer.toString(this.heroStatus.currentXp) + "/" + Integer.toString(this.heroStatus.maxXp));
        this.setBaseTextStyle(value);
        value.setX(870);
        value.setY(405);

        return value;
    }

    private ImageView getLifeBar() {
        Image lifeBarImg = new Image("file:assets/img/sidebar/LifeBar.png");
        ImageView lifeBarView = new ImageView(lifeBarImg);

        lifeBarView.setX(786);
        lifeBarView.setY(126);

        double sizeOfBar = lifeBarImg.getWidth() * this.heroStatus.currentHP / this.heroStatus.maxHP;
        if (sizeOfBar == 0) {
            lifeBarView.setVisible(false);
        } else {
            lifeBarView.setFitWidth(sizeOfBar);
        }

        return lifeBarView;
    }

    private Text getLifeValue() {
        Text value = new Text();

        value.setText(Integer.toString(this.heroStatus.currentHP));
        this.setBaseTextStyle(value);
        value.setX(969);
        value.setY(140);

        return value;
    }

    private ImageView getEnergyBar() {
        Image lifeBarImg = new Image("file:assets/img/sidebar/EnergyBar.png");
        ImageView lifeBarView = new ImageView(lifeBarImg);

        lifeBarView.setX(786);
        lifeBarView.setY(182);
        double sizeOfBar = lifeBarImg.getWidth() * this.heroStatus.currentEnergy / this.heroStatus.maxEnergy;
        if (sizeOfBar == 0) {
            lifeBarView.setVisible(false);
        } else {
            lifeBarView.setFitWidth(sizeOfBar);
        }

        return lifeBarView;
    }

    private Text getEnergyValue() {
        Text value = new Text();

        value.setText(Integer.toString(this.heroStatus.currentEnergy));
        this.setBaseTextStyle(value);
        value.setX(969);
        value.setY(198);

        return value;
    }

    private void setBaseTextStyle(Text value) {
        value.setFont(Font.font("Press Start 2P", FontWeight.BOLD, FontPosture.REGULAR, 18));
        value.setFill(Color.WHITE);
    }

    private ImageView getSideBarView() {
        Image sidebarBG = new Image("file:assets/img/sidebar/Sidebar.png");
        ImageView sidebarView = new ImageView(sidebarBG);
        sidebarView.setX(728);
        sidebarView.setY(0);

        return sidebarView;
    }

    private ImageView[] getFoodElements() {
        int initialX = 743, initialY = 238;
        int xIncrement = 26;

        ImageView[] amountOfFood = new ImageView[this.heroStatus.food];

        for (int i = 0; i < amountOfFood.length; i++) {
            Image bananaImg = new Image("file:assets/img/sidebar/Banana.png");
            ImageView bananaView = new ImageView(bananaImg);
            bananaView.setX(initialX + i * xIncrement);
            bananaView.setY(initialY);
            amountOfFood[i] = bananaView;
        }

        return amountOfFood;
    }
}
