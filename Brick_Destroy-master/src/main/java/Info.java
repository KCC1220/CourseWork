package main.java;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Info extends JComponent implements ActionListener {
    JButton back = new JButton("back");
    JFrame frame = new JFrame();
    public Info() {

        String introduction1 = "This game named as Brick Master. ";
        String introduction2 = "This game is a 2D arcade game which basically it help to train a player's reflexes";
        String instruction1 = "To start the game, you can press the 'START' button in the main menu";
        String instruction2 ="After you press the main menu, you are free to choose some of the colours that shows on the screen.";
        String instruction3 ="You can choose the colours for PLAYER and BALL";
        String instruction4 ="After the desired colour being chosen, you can press the start button to load the game";
        String instruction5 = "After the game being loaded, you can press SPACE BAR to start the game";
        String control="To control the player, you can use A for moving to left while D for moving to the right or LEFT ARROW for moving to the left while RIGHT ARROW for moving to the right";
        String mechanism1="The mission of te game is to break all the brick in the game. Therefore you will proceed to the next level";
        String mechanism2="You will have three chances to missed the ball";
        JLabel display = new JLabel(introduction1);
        JLabel display1 = new JLabel(introduction2);
        JLabel display2= new JLabel(instruction1);
        JLabel display3 = new JLabel(instruction2);
        JLabel display4 = new JLabel(instruction3);
        JLabel display5 = new JLabel(instruction4);
        JLabel display6 = new JLabel(instruction5);
        JLabel display7 = new JLabel(control);
        JLabel display8 = new JLabel(mechanism1);
        JLabel display9 = new JLabel(mechanism2);



        JPanel panel = new JPanel();

        panel.add(display);
        panel.add(display1);
        panel.add(display2);
        panel.add(display3);
        panel.add(display4);
        panel.add(display5);
        panel.add(display6);
        panel.add(display7);
        panel.add(display8);
        panel.add(display9);
        back.addActionListener(this);
        panel.add(back);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Instruction");
        frame.setSize( 1000,Colour.DEF_HEIGHT);
        autoLocate(frame);

        frame.setVisible(true);

    }



    private void autoLocate(JFrame frame) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (size.width - frame.getWidth()) / 2;
        int y = (size.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            frame.dispose();
            EventQueue.invokeLater(() -> new GameFrame().initialize());
        }
    }


}

