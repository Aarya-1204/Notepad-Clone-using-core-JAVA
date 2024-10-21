package notepad;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.*;

public class Notepad extends JFrame implements ActionListener{
    int WordWrapFlag = 0;
    int ThemeFlag = 0;
    JTextArea TextArea;
    String Text = "";
    JMenu File;
    JMenu Edit;
    JMenu View;
    JMenu About;
    public Notepad() {

        setTitle("Notepad");

        setSize(1850, 1010);

        setLocationRelativeTo(null);

        JMenuBar MenuBar = new JMenuBar();

        File = new JMenu("File");

        Edit = new JMenu("Edit");

        View = new JMenu("View");

        About = new JMenu("Help");


        JMenuItem NewFile = new JMenuItem("New");
        NewFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        NewFile.addActionListener(this);

        JMenuItem OpenFile = new JMenuItem("Open");
        OpenFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        OpenFile.addActionListener(this);

        JMenuItem SaveFile = new JMenuItem("Save");
        SaveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        SaveFile.addActionListener(this);

        JMenuItem PrintFile = new JMenuItem("Print");
        PrintFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
        PrintFile.addActionListener(this);

        JMenuItem ExitFile = new JMenuItem("Exit");
        ExitFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
        ExitFile.addActionListener(this);

        JMenuItem CopyContent = new JMenuItem("Copy");
        CopyContent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        CopyContent.addActionListener(this);

        JMenuItem PasteContent = new JMenuItem("Paste");
        PasteContent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        PasteContent.addActionListener(this);

        JMenuItem CutContent = new JMenuItem("Cut");
        CutContent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        CutContent.addActionListener(this);

        JMenuItem SelectAllContent = new JMenuItem("Select All");
        SelectAllContent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        SelectAllContent.addActionListener(this);

        JMenuItem WordWrap = new JMenuItem("WordWrap");
        WordWrap.addActionListener(this);

        JMenuItem Theme = new JMenuItem("Theme");
        Theme.addActionListener(this);

        JMenuItem AboutNotepad = new JMenuItem("About Notepad");
        AboutNotepad.addActionListener(this);

        TextArea = new JTextArea();
        TextArea.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));

        JScrollPane ScrollBar = new JScrollPane(TextArea);
        ScrollBar.setBorder(BorderFactory.createEmptyBorder());

        setJMenuBar(MenuBar);

        MenuBar.add(File);
        MenuBar.add(Edit);
        MenuBar.add(View);
        MenuBar.add(About);

        File.add(NewFile);
        File.add(OpenFile);
        File.add(SaveFile);
        File.add(PrintFile);
        File.add(ExitFile);

        Edit.add(CopyContent);
        Edit.add(PasteContent);
        Edit.add(CutContent);
        Edit.add(SelectAllContent);

        View.add(WordWrap);
        View.add(Theme);
        
        About.add(AboutNotepad);

        add(ScrollBar);

        setVisible(true);

        }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getActionCommand().equals("New")) {
            TextArea.setText("");
             }

        else if (ae.getActionCommand().equals("Open")) {
            JFileChooser Chooser = new JFileChooser();
            Chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter Restrict = new FileNameExtensionFilter("Only .txt files", "txt");
            Chooser.addChoosableFileFilter(Restrict);
            int result = Chooser.showOpenDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                File file = Chooser.getSelectedFile();

                try {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    TextArea.read(br, null);
                    br.close();
                    TextArea.requestFocus();  //indicates that text area is ready to get the user input again //I don't think its necessary
                    }

                catch (Exception e) {
                    System.out.print("File Not Found" );
                    }
                }
            }

        else if(ae.getActionCommand().equals("Save")) {
            JFileChooser SaveAs = new JFileChooser();
            SaveAs.setApproveButtonText("Save");
            int actionDialog = SaveAs.showOpenDialog(this);

            if (actionDialog != JFileChooser.APPROVE_OPTION) {
                return;
                }

            File fileName = new File(SaveAs.getSelectedFile() + ".txt");
            BufferedWriter outFile;

            try {
                outFile = new BufferedWriter(new FileWriter(fileName));
                TextArea.write(outFile);
                }

            catch (IOException e) {
                System.out.println("Save Function Failed");
                }
            }

        else if(ae.getActionCommand().equals("Print")){

            try{
                TextArea.print();
                }

            catch(Exception e){
                System.out.println("Unable To Print");
                }
            }

        else if (ae.getActionCommand().equals("Exit")) {
            System.exit(0);
            }

        else if (ae.getActionCommand().equals("Copy")) {
            Text = TextArea.getSelectedText();
            }

        else if (ae.getActionCommand().equals("Paste")) {
            TextArea.insert(Text, TextArea.getCaretPosition());
            }

        else if (ae.getActionCommand().equals("Cut")) {
            Text = TextArea.getSelectedText();
            TextArea.replaceRange("", TextArea.getSelectionStart(), TextArea.getSelectionEnd());
            }

        else if (ae.getActionCommand().equals("Select All")) {
            TextArea.selectAll();
            }

        else if (ae.getActionCommand().equals("WordWrap")) {

            if (WordWrapFlag == 0) {
                TextArea.setLineWrap(true);
                TextArea.setWrapStyleWord(true);
                WordWrapFlag++;
                }

            else{
                TextArea.setLineWrap(false);
                TextArea.setWrapStyleWord(false);
                WordWrapFlag--;
                }
            }

        else if (ae.getActionCommand().equals("Theme")) {

            if (ThemeFlag == 0) {
                TextArea.setBackground(Color.darkGray);
                TextArea.setForeground(Color.white);
                File.setForeground(Color.white);
                Edit.setForeground(Color.white);
                View.setForeground(Color.white);
                About.setForeground(Color.white);
                getJMenuBar().setBackground(Color.darkGray);
                getJMenuBar().setBorder(BorderFactory.createLineBorder(Color.white,1));
                ThemeFlag++;
                }

            else{
                TextArea.setBackground(Color.white);
                TextArea.setForeground(Color.black);
                File.setForeground(Color.black);
                Edit.setForeground(Color.black);
                View.setForeground(Color.black);
                About.setForeground(Color.black);
                getJMenuBar().setBackground(Color.WHITE);
                ThemeFlag--;
                }
            }

        else if (ae.getActionCommand().equals("About Notepad")) {
            new notepad.About().setVisible(true);
            }
        }

    public static void main(String[] args) {
        new Notepad();
        }
    }