import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Java. Game "Snake"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated April 22, 2017
 */
public class MapGame extends JPanel implements ActionListener {

    public  int scaleCell;
    public  int widthCell;
    public  int heightCell;
    public static final int SPEED = 4;

    private Color colorMap = new Color(65,169,76);
    private Color colorGrid = new Color(255,255,153);
    private Color colorSnake = new Color(40,103,160);
    private Color colorApple = new Color(200,0,0);

    Snake snake = new Snake(10,10,9,10);
    Timer timer = new Timer(1000/SPEED, this);
    Apple apple = new Apple((int)(Math.random() * widthCell), (int) (Math.random() * heightCell));

   public MapGame(int scaleCell, int widthCell, int heightCell){
       this.scaleCell = scaleCell;
       this.widthCell = widthCell;
       this.heightCell = heightCell;
       timer.start();
       addKeyListener(new Keyboard());
       setFocusable(true);
       setBackground(colorMap);
    }

    @Override
    protected void paintComponent(Graphics g){
       super.paintComponent(g);
       g.setColor(colorGrid);

       for (int i = 0; i <= widthCell * scaleCell + 1; i+= scaleCell){
           g.drawLine(i, 0, i, heightCell * scaleCell);
       }

        for (int j = 0; j <= heightCell * scaleCell + 1; j+= scaleCell){
            g.drawLine(0, j, widthCell * scaleCell, j);
        }

        for (int i = 0; i < snake.lenSnaek; i++){
            g.setColor(colorSnake);
            g.fillRect(snake.snakeMaxX[i]* scaleCell + 1, snake.snakeMaxY[i]* scaleCell + 1,
                    scaleCell - 1, scaleCell -1 );
        }

        g.setColor(colorApple);
        g.fillRect(apple.posX * scaleCell + 1, apple.posY * scaleCell + 1,
                scaleCell - 1,scaleCell - 1);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        if (snake.snakeMaxX[0] == apple.posX & snake.snakeMaxY[0] == apple.posY){
            apple.setRandomPositionApple();
            snake.lenSnaek++;
        }
        for(int i = 1; i< snake.lenSnaek; i++) {
            if (snake.snakeMaxX[i] == apple.posX & snake.snakeMaxY[i] == apple.posY) {
                apple.setRandomPositionApple();
            }
        }
        repaint();
    }

    private class Keyboard extends KeyAdapter{
        @Override
        public void keyPressed (KeyEvent e){
            int key = e.getKeyCode();
            if (key == e.VK_RIGHT & snake.move != 2){
                snake.move = 0;
            }
            if (key == e.VK_UP & snake.move != 3){
                snake.move = 1;
            }
            if (key == e.VK_LEFT & snake.move != 0){
                snake.move = 2;
            }
            if (key == e.VK_DOWN & snake.move != 1){
                snake.move = 3;
            }
        }
    }
}
