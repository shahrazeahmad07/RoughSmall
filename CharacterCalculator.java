import java.awt.*;
import java.awt.event.*;


public class CharacterCalculator extends KeyAdapter{
    Frame f;
    Label l;
    TextArea area;
    Learn() {
        f = new Frame("Key Adapter");
        area = new TextArea();
        l = new Label();
        l.setBounds(20,50,200,20);
        area.setBounds(20,80,300,300);
        area.addKeyListener(this);
        f.add(l);
        f.add(area);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void keyPressed(KeyEvent e) {
        String text = area.getText();
        String[] words = text.split(" ");
        l.setText("Words " + words.length + "  Characters " + text.length());
    }

    public static void main(String[] args) {
        new Learn();
    }
}
