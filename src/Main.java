import ecs100.UI;

public class Main {
    public static void setupGUI(Game game) {
        UI.initialise();
        UI.setKeyListener(game::handleMovement);
    }

    public static void main(String[] args) {
        Game game = new Game();
        setupGUI(game);

        final double frame_len = 1000.0 / 30.0;
        while (!game.getDone()) {
            // Tick player in order to apply gravity and such
            game.player.tick();

            UI.clearGraphics();

            game.player.draw();

            UI.sleep(frame_len);
        }
    }
}
