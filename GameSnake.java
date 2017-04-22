import javax.swing.*;

/**
 * Java. Game "Snake"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated April 22, 2017
 */
public class GameSnake {

    public static void main (String[] args){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameWindow();
            }
        });



    }
}
