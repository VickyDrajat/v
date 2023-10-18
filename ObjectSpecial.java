import greenfoot.*; 

public class ObjectSpecial extends Actor
{
    private int specialObjectDelay = 100;
    private int specialObjectCounter = 0;
    private GreenfootSound collectSound = new GreenfootSound("a.wav");
    private int speed = 2;
    private boolean isCollected = false;
    
    public ObjectSpecial()
    {
        setImage("jeruk.png");
    }
    
    public void act() 
    {
        if (!isCollected) {
            checkForCollision();
            fall();
        } else {
            handleCollectedState();
        }
    }
    
    private void handleCollectedState() {
        int currentY = getY();
        if (currentY >= getWorld().getHeight() - 1) {
            isCollected = false;
            resetPosition();
        }
    }
    
    private void resetPosition() {
        setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()), 0);
    }
    
    public void checkForCollision() {
        Actor character = getOneIntersectingObject(Player.class);
        if (character != null) {
            isCollected = true;
            getWorld().removeObject(this);
            playCollectSound();
        }
    }
    
    public void fall() {
        int currentX = getX();
        int currentY = getY();
        if (atWorldEdge()) {
            getWorld().removeObject(this);
        } else {
            setLocation(currentX, currentY + speed);
        }
    }
    
    public boolean atWorldEdge() {
        return getY() >= getWorld().getHeight() - 1;
    }
    
    public void playCollectSound() {
        collectSound.play();
    }
}
