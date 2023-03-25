import ecs100.UI;

public class Main {
    public static void setupGUI(Game game) {
        UI.initialise();
        UI.setKeyListener(game::handleMovement);
    }

    public static void main(String[] args) {
        Game game = new Game();
        setupGUI(game);
        UI.println("Hi!");

        final double frame_len = 1.0/1.0;
        while (!game.getDone()) {
            UI.clearGraphics();
            game.player.draw();
            UI.sleep(frame_len);
        }
    }
}
