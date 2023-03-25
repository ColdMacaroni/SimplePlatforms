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
        // Check if player is touching floor
        boolean canFall = true;
        if (player.getCurJumps() <= 0) {
            for (Block b : blocks) {
                if (player.collideBottom(b) || player.collideBottom(b, Player.stepSize)) {
                    player.setY(b.getY() - player.getHeight());

                    // Reset jump
                    player.setCurJumps(-1);

                    canFall = false;
                    break;
                }
            }
        } else if (0 < player.getCurJumps() && player.getCurJumps() <= player.getMaxJumps()) {
            player.moveUp();
            player.setCurJumps(player.getCurJumps() + 1);
            canFall = false;
        }

        if (canFall) {
            player.setCurJumps(0);
            player.fall();
        }

        if (player.getFarY() > 800) resetPlayerPos();

        player.tick();
    }

    private void movePlayer(Direction dir) {
        switch (dir) {
            case UP -> {
                if (player.getCurJumps() == -1) {
                    player.setCurJumps(1);
                }
            }
            case DOWN -> {
                // Cancel jump
                if (player.getCurJumps() > 0) {
                    player.setCurJumps(0);
                }
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
                case 'w' -> movePlayer(Direction.UP);
                case 'a' -> movePlayer(Direction.LEFT);
                case 's' -> movePlayer(Direction.DOWN);
                case 'd' -> movePlayer(Direction.RIGHT);
                case 'q' -> done = true;
            }
        } else if (key.equals("Space")) {
            movePlayer(Direction.UP);
        }
    }
}