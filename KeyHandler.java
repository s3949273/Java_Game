
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyHandler implements KeyListener{
    public boolean fPressed, qPressed = false;
    @Override
    public void keyTyped(KeyEvent e) {
       //not using 
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_F){
            fPressed = true;
        }
        if(code == KeyEvent.VK_Q){
            qPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_F){
            fPressed = false;
        }
        if(code == KeyEvent.VK_Q){
            qPressed = false;
        }
    }

    
}
