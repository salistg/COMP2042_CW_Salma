package sample;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Menu implements MouseListener, MouseMotionListener, KeyListener {

    private Rectangle startGame;
    private Rectangle information;
    private Rectangle backButton;
    private Rectangle exitGame;
    private BufferedImage image;
    private BufferedImage images[];
    private Color startGameButton;
    private Color informationButton;
    private Color backButtonC;
    private Color exitGameButton;
    private Font font;
    private Font font1;
    private int randomX[];
    private int randomY[];
    private int randomRad[];
    private enum STATE{
        MENU,
        INFO,
        GAME
    }

    private STATE menuState = STATE.MENU;

    public Menu(){
        startGame = new Rectangle(235,110,119,55);
        information = new Rectangle(240,210,110,55);
        exitGame = new Rectangle(240,310,110,55);
        backButton = new Rectangle(215,290,135,55);
        images = new BufferedImage[10];
        menuScreen();
        loadImage();
        randomRad= new int[10];
        randomX = new int[10];
        randomY = new int[10];
        randomNumberGeneration();
    }

    private void randomNumberGeneration() {
        Random randomNo = new Random();
        int i;
        for(i=0; i<10; i++){
            randomX[i] = randomNo.nextInt(450);
            randomY[i] = randomNo.nextInt(400);
            randomRad[i] = randomNo.nextInt(360);

        }
    }

    private void loadImage() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("img/BG.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void menuScreen() {
        int i;
        try{
            for(i=0;i<images.length;i++){
                images[i] = ImageIO.read(getClass().getResourceAsStream("img/frog.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void screensDrawing(Graphics2D graphics2D){
        int i;
        for(i=0;i<images.length;i++){
            AffineTransform affineTransform = AffineTransform.getTranslateInstance(randomX[i],randomY[i]);
            if(i%2==0)
                affineTransform.rotate(Math.toRadians(randomRad[i]++),images[i].getWidth()/2,images[i].getHeight()/2);
            else
                affineTransform.rotate(Math.toRadians(randomRad[i]--),images[i].getWidth()/2,images[i].getHeight()/2);
            graphics2D.drawImage(images[i],affineTransform,null);
            if(randomRad[i]==360 || randomRad[i]==-360)
                randomRad[i]=0;
        }
    }

    public void render(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;
        if(menuState == STATE.MENU){
            font = new Font("Verdana",Font.BOLD,100);
            graphics2D.setFont(font);
            graphics2D.drawImage(image,0,0,null);
            screensDrawing(graphics2D);

            graphics2D.setColor(startGameButton);
            graphics2D.draw(startGame);
            graphics2D.drawString("START",startGame.x,startGame.y+50);

            graphics2D.setColor(informationButton);
            graphics2D.draw(information);
            graphics2D.drawString("INFO",information.x,information.y+50);

            graphics2D.setColor(exitGameButton);
            graphics2D.draw(exitGame);
            graphics2D.drawString("START",information.x,information.y+50);


        }

        if(menuState == STATE.INFO){
            graphics2D.drawImage(image,0,0,null);
            screensDrawing(graphics2D);
            graphics2D.setColor(Color.YELLOW);
            font1 = new Font("Verdana",Font.BOLD,50);
            graphics2D.setFont(font1);
            graphics2D.drawString("You can use the arrow or the AWSD keys to play.\nYou can close the game by pressing ESC.", 110, information.y);

            graphics2D.setColor(backButtonC);
            graphics2D.draw(backButton);
            graphics2D.setFont(font);
            graphics2D.drawString("GO BACK", backButton.x, backButton.y+50);
        }
    }

    public boolean insideButton(Rectangle button, int i, int j){
        return (i>=button.getMinX() && i<=button.getMaxX()) && (j>= button.getMinY() && j<=button.getMaxX());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouse1 = e.getX();
        int mouse2 = e.getY();

        if(insideButton(startGame,mouse1,mouse2) && menuState == STATE.MENU){
            menuState = STATE.GAME;
        } else if(insideButton(information,mouse1,mouse2) && menuState== STATE.MENU){
            menuState = STATE.INFO;
        } else if(insideButton(exitGame,mouse1,mouse2) && menuState == STATE.MENU){
            System.exit(1);
        }

        if(menuState == STATE.INFO && insideButton(backButton,mouse1,mouse2)){
            menuState = STATE.MENU;
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mouse1 = e.getX();
        int mouse2 = e.getY();

        if(insideButton(startGame,mouse1,mouse2))
            startGameButton = Color.GRAY;
        else
            startGameButton = Color.WHITE;


        if(insideButton(information,mouse1,mouse2))
            informationButton = Color.blue;
        else
            informationButton = Color.cyan;

        if(insideButton(exitGame,mouse1,mouse2))
            exitGameButton = Color.BLUE;
        else
            exitGameButton = Color.CYAN;

        if(insideButton(backButton,mouse1,mouse2))
            backButtonC = Color.green;
        else
            backButtonC = Color.yellow;

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_ESCAPE){
            System.exit(1);
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
