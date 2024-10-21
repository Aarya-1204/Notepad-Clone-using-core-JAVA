package notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class About extends JFrame implements ActionListener{

    About(){

        setTitle("About");
        setBounds(400, 100, 600, 500);

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Windows.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 60, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel HeaderIcon = new JLabel(i3);
        HeaderIcon.setBounds(50, 40, 500, 80);
        add(HeaderIcon);

        JLabel Text1 = new JLabel("<html><b>____________________________________________________________________________<b></html>");
        Text1.setBounds(20, 2, 600, 300);
        Text1.setFont(new Font("Times New Roman", Font.PLAIN,14));
        add(Text1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("notepad.png"));
        Image i5 = i4.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel Icon = new JLabel(i6);
        Icon.setBounds(50, 180, 70, 70);
        add(Icon);

        JLabel Text2 = new JLabel("<html><b>About Notepad:</b><br><br>Notepad is a digital application designed and developed by (Minor Project).<br> With a focus on simplicity, efficiency, and user experience. <br>It provides users with a versatile platform <br>for note-taking, text editing, and document management.<br><br><b>Contact Us:</b><br><b>Ph: </b>+91 9876543210<br><b>Email: </b>minorproject123@gmail.com</html>");
        Text2.setBounds(140, 120, 500, 300);
        Text2.setFont(new Font("Times New Roman", Font.PLAIN,14));
        add(Text2);

        JButton b1 = new JButton("OK");
        b1.setBounds(150, 390, 120, 25);
        b1.addActionListener(this);
        b1.setFocusable(false);
        add(b1);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }

    public static void main(String[] args){
        new About();
    }

}