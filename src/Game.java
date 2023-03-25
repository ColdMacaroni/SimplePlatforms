import ecs100.*;
public class Game {
    // Members ------
    private final Player player;
    private boolean done = false;

    // Constructor --
    Game() {
        player = new Player(20, 20);
    }

    // Getters ------
    public boolean getDone() {
        return done;
    }
    public Player getPlayer() {
        return player;
    }

    // Methods ------
    public void tick() {

    }

    public void handleMovement(String key) {

        // We can treat it as a char for easier handling
        if (key.length() == 1) {
            char k = key.charAt(0);

            switch (k) {
                case 'd' -> player.moveRight();
                case 'a' -> player.moveLeft();
                case 'q' -> done = true;
            }
        }
    }
}