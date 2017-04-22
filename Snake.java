/**
 * Java. Game "Snake"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated April 22, 2017
 */
public class Snake {
    public int move;
    public int moveLeft = 0;
    public int moveUp = 1;
    public int moveRight = 2;
    public int moveDown = 3;
    public int lenSnaek = 2;

    public int[] snakeMaxX = new int[GameWindow.HEIGHT_CELL * GameWindow.WIDTH_CELL];
    public int[] snakeMaxY = new int[GameWindow.HEIGHT_CELL * GameWindow.WIDTH_CELL];

    public Snake (int x0, int y0, int x1, int y1){

        snakeMaxX[0] = x0;
        snakeMaxY[0] = y0;
        snakeMaxX[1] = x1;
        snakeMaxY[1] = y1;
    }

    public void move (){
        for (int i = lenSnaek; i > 0; i--){
            snakeMaxX [i] = snakeMaxX [i -1];
            snakeMaxY [i] = snakeMaxY [i -1];
        }

        if (move == moveLeft){
            snakeMaxX[0]++;
        }
        if (move == moveUp){
            snakeMaxY[0]--;
        }
        if (move == moveRight){
            snakeMaxX[0]--;
        }
        if (move == moveDown){
            snakeMaxY[0]++;
        }
        for (int i = lenSnaek -1; i > 0; i--){
            if (snakeMaxX [0] == snakeMaxX [i] & snakeMaxY [0] == snakeMaxY [i]) {
                lenSnaek = i - 2;
            }
        }
        if (snakeMaxX[0] > GameWindow.WIDTH_CELL-1){
            snakeMaxX[0] = 0;
        }
        if (snakeMaxX[0] < 0){
            snakeMaxX[0]= GameWindow.WIDTH_CELL - 1;
        }
        if (snakeMaxY[0] > GameWindow.HEIGHT_CELL){
            snakeMaxY[0] = 0;
        }
        if (snakeMaxY[0] < 0){
            snakeMaxY[0] = GameWindow.HEIGHT_CELL - 1;
        }
        if (lenSnaek < 2) {
            lenSnaek = 2;
        }

    }
}
