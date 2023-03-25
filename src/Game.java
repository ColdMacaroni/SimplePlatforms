import java.util.ArrayList;

public class Game {
    // Members ------
    private final Player player;
    private boolean done = false;
    public ArrayList<Block> blocks;

    // Constructor --
    Game(ArrayList<Block> blocks) {
        this.blocks = blocks;
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
        player.tick();
    }

    public void handleInput(String key) {

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