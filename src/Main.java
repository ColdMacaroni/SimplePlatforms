import ecs100.UI;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void setupGUI(Game game) {
        UI.initialise();
        UI.setKeyListener(game::handleInput);
        UI.addButton("Reset Player", game::resetPlayerPos);
    }

    public static void main(String[] args) {
        // Create obstacles
        ArrayList<Block> blocks = new ArrayList<Block>();
        blocks.add(new ColorBlock(100, 400, 200, 20, Color.BLACK));
        blocks.add(new ColorBlock(200, 300, 24, 100, Color.BLACK));

        Game game = new Game(blocks, new double[]{200, 20});
        setupGUI(game);

        // Main game loop
        final double frame_len = 1000.0 / 30.0;
        while (!game.getDone()) {
            // Magic
            game.tick();

            UI.clearGraphics();

            for (Block b: game.blocks) b.draw();
            game.getPlayer().draw();

            UI.sleep(frame_len);
        }
    }
}
