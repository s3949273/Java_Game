import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
public class GUI extends JPanel implements Runnable{
    Thread gameThread;
    KeyHandler keyH = new KeyHandler();
    public User u = new User(User.getSave("/Users/t/Desktop/Java/non-Uni/game/Save.txt"));
    public GUI(){
        this.setPreferredSize(new Dimension(1000,800));
        this.setDoubleBuffered(true);
        this.setBackground(Color.black);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval = 1000000000/60;
        double delta = 0;
        long lastTime = System.nanoTime();
        long timer = 0;
        int drawCount = 0;
        while(gameThread !=null){
            long curTime = System.nanoTime();
            delta +=(curTime - lastTime) / drawInterval;
            timer+=(curTime - lastTime);
            lastTime = curTime;
            if(delta > 1){
                update();
                repaint();
                delta --;
                drawCount ++;
            }if(timer >= 1000000000){
                System.out.println("FPS: "+drawCount);
                drawCount =0;
                timer = 0;
            }
           
        }
    }
    public void showHUD(){
        
        
    }
    public void update(){
        //we want to update the player's stats and stuff
        if(keyH.fPressed){
            System.out.println("pressed the f key");
        }
        if(keyH.qPressed){
            System.out.println("pressed the q key");
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
    }



}