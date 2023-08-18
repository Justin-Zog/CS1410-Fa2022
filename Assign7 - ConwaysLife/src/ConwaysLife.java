// Reference for Lanterna 3: https://github.com/mabe02/lanterna/blob/master/docs/contents.md
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class ConwaysLife {
    public static void main(String[] args) {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            TextGraphics graphics = screen.newTextGraphics();
            TerminalSize size = screen.getTerminalSize();

            LifeSimulator simulation = new LifeSimulator(size.getColumns(), size.getRows());
            simulation.insertPattern(new PatternBlock(), 0, 0);
            simulation.insertPattern(new PatternBlinker(), 1, 5);
            simulation.insertPattern(new PatternGlider(), 20, 15);
            simulation.insertPattern(new PatternZawgMethuselah(), 39, 4);
            simulation.insertPattern(new PatternAcorn(), 5, 15);
            //simulation.insertPattern(new PatternGosperGlider(), 1,1);

            screen.startScreen();
            screen.setCursorPosition(null);

            for (int i = 0; i < 100; i++) {
                render(simulation, screen, graphics);   // Render the current state of the simulation
                Thread.yield();                         // Let the JVM have some time to update other things
                Thread.sleep(100);                // Sleep for a bit to make for a nicer paced animation
                simulation.update();                    // Tell the simulation to update
            }

            screen.stopScreen();
        } catch (Exception ex) {
            System.out.println("Something bad happened: " + ex.getMessage());
        }
    }


    public static void render(LifeSimulator simulation, Screen screen, TextGraphics graphics) {
        // If a cell is alive use graphics.setCharacter(...) to draw it at the location. █ ▓ ▒ ░
        // The code below may or may not be necessary.
        screen.clear();

        for (int row = 0; row < simulation.getSizeX() - 1; row++) {
            for (int column = 0; column < simulation.getSizeY() - 1; column++) {
                if (simulation.getCell(row, column)) {
                    graphics.setCharacter(row, column, new TextCharacter('░', TextColor.ANSI.CYAN, TextColor.ANSI.DEFAULT));
                }
            }
        }

        try {
            screen.refresh();
        } catch (Exception ex) {
            System.out.println("Something bad happened: " + ex.getMessage());
        }
    }
}
