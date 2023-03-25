import ecs100.*;
public class Game {
    public Player player;
    private boolean done = false;

    public boolean getDone() {
        return done;
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

    Game() {
        player = new Player(20, 20);
    }

}