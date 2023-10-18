import greenfoot.*;

public class Enemy extends Actor {
    public Enemy() {
        setImage("hiu.png");
    }

    public void act() {
        if (getWorld().getObjects(Player.class).isEmpty()) {
            return;
        }

        followPlayer();
        checkCollisionWithPlayer();
    }

    public void followPlayer() {
        Player player = (Player) getWorld().getObjects(Player.class).get(0);
        if (player != null) {
            int playerX = player.getX();
            int playerY = player.getY();
            int currentX = getX();
            int currentY = getY();

            int dx = playerX - currentX;
            int dy = playerY - currentY;

            double angle = Math.atan2(dy, dx);
            int speed = 2;

            int vx = (int) (speed * Math.cos(angle));
            int vy = (int) (speed * Math.sin(angle));

            setLocation(currentX + vx, currentY + vy);
        }
    }

    public void checkCollisionWithPlayer() {
        if (isTouching(Player.class)) {
            showGameOver();
            Greenfoot.stop();
        }
    }

    public void showGameOver() {
        World world = getWorld();
        world.showText("Game Over", world.getWidth() / 2, world.getHeight() / 2);
    }
}
