import greenfoot.*;
import java.util.Random;

public class MyWorld extends World {
    private int specialObjectDelay = 100;
    private int specialObjectCounter = 0;
    private int score = 0;

    public MyWorld() {
        super(1300, 731, 1);
        prepare();
    }

    public void act() {
        if (score >= 100) {
            showText("You Won!", getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
        }
    }

    public void prepare() {
        // Add initialization of objects and main characters for the first level here
        addObject(new Player(), getWidth() / 2, getHeight() - 30);
        addObject(new Enemy(), getWidth() / 2, getHeight() - 30);
        addObject(new ObjectSpecial(), 
            Greenfoot.getRandomNumber(getWidth()), 
            Greenfoot.getRandomNumber(getHeight()));

        // Add more objects or characters for the first level here
    }

    public void nextLevel() {
        if (score >= 100) {
            showText("You Won!", getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
        } else {
            removeObjects(getObjects(ObjectSpecial.class));
            prepare();

            // Additional logic for setting up the next level
        }
    }

    public void addScore() {
        score++;
    }
}
