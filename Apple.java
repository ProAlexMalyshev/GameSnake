/**
 * Java. Game "Snake"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated April 22, 2017
 */
public class Apple {

    public int posX;
    public int posY;

    public Apple (int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public void setRandomPositionApple(){
        posX = (int)(Math.random()*GameWindow.WIDTH_CELL);
        posY = (int)(Math.random()*GameWindow.HEIGHT_CELL);
    }
}
