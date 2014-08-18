package designpatterns.structural.adapter;
import javax.swing.*;
import java.awt.event.*;

class TestAdapter_Swing extends JFrame {
    public TestAdapter_Swing(){
        setSize(200,200);
        setVisible(true);
        addWindowListener(new Closer());
    }
    
    public static void main(String[] args){
        new TestAdapter_Swing();
    }
    
    class Closer extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
    }
}

//Remove--------------------
interface WindowsListenerX{
    public void windowClosed(WindowEvent e); 
    public void windowOpened(WindowEvent e);
    public void windowIconified(WindowEvent e);
    public void windowDeiconified(WindowEvent e);
    public void windowActivated(WindowEvent e);
    public void windowDeactivated(WindowEvent e);
    public void windowClosing(WindowEvent e);
}

class WindowAdapterX implements WindowsListenerX{
    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {}
}
