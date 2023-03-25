import ecs100.UI;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void setupGUI(Game game) {
        UI.initialise();
        UI.setKeyListener(game::handleInput);
    }

    public static void main(String[] args) {
        ColorBlock platform = new ColorBlock(0, 400, 400, 20, Color.BLACK);

        ArrayList<Block> blocks = new ArrayList<Block>();
        blocks.add(platform);

        Game game = new Game(blocks);
        setupGUI(game);

        final double frame_len = 1000.0 / 30.0;
        while (!game.getDone()) {
            // Magic
            game.tick();

            UI.clearGraphics();

            platform.draw();
            game.getPlayer().draw();

            UI.sleep(frame_len);
        }
    }
}
