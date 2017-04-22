import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Java. Game "Snake"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated April 22, 2017
 */
public class GameWindow extends JFrame {

    public static final int SCALE_CELL = 32;
    public static final int WIDTH_CELL = 20;
    public static final int HEIGHT_CELL = 20;

    public static final int WIDTH_FIELD = WIDTH_CELL * SCALE_CELL + 7;
    public static final int HEIGHT_FIELD = HEIGHT_CELL * SCALE_CELL + 55;
    public final MapGame mapGame;

    public GameWindow (){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snake Game");
        setSize(WIDTH_FIELD, HEIGHT_FIELD);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        mapGame = new MapGame(SCALE_CELL, WIDTH_CELL, HEIGHT_CELL);
        add(mapGame, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        add(btnPanel, BorderLayout.SOUTH);
        btnPanel.setLayout(new GridLayout(1,1));

        JButton btnGameExit = new JButton("Выход");
        btnGameExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnPanel.add(btnGameExit);

        setResizable(false);
        setVisible(true);
    }
}
