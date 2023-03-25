import ecs100.UI;

import java.util.ArrayList;

public class Game {
    // Members ------
    private final Player player;
    private final double[] startingPos;
    private enum Direction {UP, RIGHT, DOWN, LEFT};
    private boolean done = false;
    public ArrayList<Block> blocks;

    // Constructor --
    Game(ArrayList<Block> blocks, double[] startingPos) {
        this.startingPos = startingPos;
        this.blocks = blocks;
        player = new Player(startingPos[0], startingPos[1]);
    }

    // Getters ------
    public boolean getDone() {
        return done;
    }
    public Player getPlayer() {
        return player;
    }

    // Methods ------
    public void resetPlayerPos() {
        player.setX(startingPos[0]);
        player.setY(startingPos[1]);
    }
    public void tick() {
        boolean canFall = true;
        for (Block b: blocks) {
            if (player.collideBottom(b) || player.collideBottom(b, Player.stepSize)) {
                player.setY(b.getY() - player.getHeight());
                canFall = false;
                break;
            }
        }
        if (canFall) player.fall();

        player.tick();
    }

    private void movePlayer(Direction dir) {
        switch (dir) {
            case UP -> {
                // TODO: Jumping
            }
            case DOWN -> {
                // TODO: Useless??
            }
            case RIGHT -> {
                for (Block b : blocks) {
                    if (player.collideRight(b) || player.collideRight(b, Player.stepSize)) {
                        player.setX(b.getX() - player.getWidth());
                        return;
                    }
                }

                player.moveRight();
            }
            case LEFT -> {
                for (Block b: blocks) {
                    if (player.collideLeft(b) || player.collideLeft(b, -Player.stepSize)) {
                        player.setX(b.getFarX());
                        return;
                    }
                }

                player.moveLeft();
            }
        }
    }

    public void handleInput(String key) {
        // We can treat it as a char for easier handling
        if (key.length() == 1) {
            char k = key.charAt(0);

            switch (k) {
                case 'd' -> movePlayer(Direction.RIGHT);
                case 'a' -> movePlayer(Direction.LEFT);
                case 'q' -> done = true;
            }
        }
    }
}