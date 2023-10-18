import greenfoot.*;

public class Player extends Actor {
    private int score = 0;
    private boolean gameIsWin = false;

    public Player() {
        setImage("ikan.png");
    }

    public void act() {
        checkKeyPress();
        checkForCollision();
    }

    public void checkKeyPress() {
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - 3);
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + 3);
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - 3, getY());
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + 3, getY());
        }
    }

    public void checkForCollision() {
        // Cek untuk objek spesial
        Actor specialObject = getOneIntersectingObject(ObjectSpecial.class);
        if (specialObject != null) {
            increaseScore();
            getWorld().removeObject(specialObject);

            // Membuat objek spesial baru dan menambahkannya ke dunia
            ObjectSpecial newSpecialObject = new ObjectSpecial();
            getWorld().addObject(newSpecialObject, Greenfoot.getRandomNumber(getWorld().getWidth()), 0);
        }

        // Cek untuk musuh
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (enemy != null) {
            getWorld().removeObject(this); // Mematikan pemain saat bersentuhan dengan musuh
        }
        
        if (score>=100) {
            win();
        }
    }

    public void increaseScore() {
        score += 10;
        getWorld().showText("Score: " + score, 50, 25);
    }
    
    public void win(){
        gameIsWin= true;
        getWorld().showText("YOU WIN", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        Greenfoot.stop();
    }
}
