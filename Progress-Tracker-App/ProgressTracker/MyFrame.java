package ProgressTracker;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{

    /*==Old Variables==================================================================================================================*/
    // SAVE FILE NAME.
    String fileName = "SaveFile.txt";

    // Variables for the notes.
    Note[][] notePanels = new Note[4][4];
    int notePanelsWidth, notePanelsHeight;
    Dimension notePanelsDimension;

    // Variables for left division.
    JButton[] leftDivisionButtons = new JButton[1];

    // Variables for right division.
    JButton[] rightDivisionButtons = new JButton[2];

    // Variables for records.
    Records records = new Records();
    Task task;

    //NEW WINDOWS.
    EditWindow editWindow;
    String[] values = new String[3];
    int[] currentPosition = new int[2];
    boolean newTask;
    FileWindow fileWindow;
    boolean saving;

    /*==New Variables==================================================================================================================*/
    Palette palette = new Palette();
    FivePanel mainPanel;
    BoardPanel boardPanel;

    MyFrame(){
        windowSetup();
        boardPanel = new BoardPanel(this, 4);
        mainPanel = boardPanel;
        editAndFileWindowSetup();
        // columnSetup();
        notesSetup();       
        leftDivisionSetup();
        rightDivisionSetup(); 
        resetNotes();
    }

    public void windowSetup(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setResizable(true);
        this.setVisible(true);
    }

    public void editAndFileWindowSetup(){
        editWindow = new EditWindow("");
        editWindow.setVisible(false);
        fileWindow = new FileWindow("");
        fileWindow.setVisible(false);
    }
    
    public void notesSetup(){
        for(int counterA = 0; counterA < 4; counterA++){
            notePanelsWidth =  boardPanel.getColumnPanels().get(counterA).getWidth() - 20;
            notePanelsHeight = (boardPanel.getColumnPanels().get(counterA).getHeight() - 50) / 5;
            notePanelsDimension = new Dimension(notePanelsWidth, notePanelsHeight);
            for(int counterB = 0; counterB < 4; counterB++){
                notePanels[counterA][counterB] = new Note(new BorderLayout(), palette.getNotePanelsColors().get(counterA).get(counterB), notePanelsDimension, JLabel.CENTER);
                notePanels[counterA][counterB].getLeftButton().addActionListener(this);
                notePanels[counterA][counterB].getRightButton().addActionListener(this);
                notePanels[counterA][counterB].getBottomButton().addActionListener(this);
                boardPanel.getColumnPanels().get(counterA).add(notePanels[counterA][counterB]);
            }
        }
    }

    public void leftDivisionSetup(){

        leftDivisionButtons[0] = new JButton();
        leftDivisionButtons[0].addActionListener(this);
        leftDivisionButtons[0].setBackground(Color.PINK);
        leftDivisionButtons[0].setText("New");
        leftDivisionButtons[0].setPreferredSize(new Dimension(100, 50));
        mainPanel.getWestPanel().setLayout(new FlowLayout());
        mainPanel.getWestPanel().add(leftDivisionButtons[0]);


    }

    public void rightDivisionSetup(){
        rightDivisionButtons[0] = new JButton();
        rightDivisionButtons[0].addActionListener(this);
        rightDivisionButtons[0].setBackground(Color.ORANGE);
        rightDivisionButtons[0].setText("Save");
        rightDivisionButtons[0].setPreferredSize(new Dimension(100, 50));
        rightDivisionButtons[1] = new JButton();
        rightDivisionButtons[1].addActionListener(this);
        rightDivisionButtons[1].setBackground(new Color(230, 230, 250));
        rightDivisionButtons[1].setText("Load");
        rightDivisionButtons[1].setPreferredSize(new Dimension(100, 50));
        mainPanel.getEastPanel().setLayout(new FlowLayout());
        mainPanel.getEastPanel().add(rightDivisionButtons[0]);
        mainPanel.getEastPanel().add(rightDivisionButtons[1]);
    }

    public void resetNotes(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                task = records.retrieveTask(i, j);
                if(task != null){
                    notePanels[i][j].getTitle().setText(task.title);
                    notePanels[i][j].getContents().setText(task.contents);
                    notePanels[i][j].getUser().setText(task.user);
                    notePanels[i][j].setVisible(true);
                } else {
                    notePanels[i][j].setVisible(false);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getSource().toString());

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(event.getSource() == notePanels[i][j].getLeftButton()){
                    if(i == 0){
                        records.removeTask(i, j);
                    } else {
                        records.moveBackTask(i, j);
                    }

                } else if(event.getSource() == notePanels[i][j].getRightButton()){
                    if(i != 3){
                        records.moveForwardTask(i, j);
                    } else {
                        records.removeTask(i, j);
                    }
                } else if(event.getSource() == notePanels[i][j].getBottomButton()){
                    newTask = false;
                    currentPosition[0] = i;
                    currentPosition[1] = j;
                    values = records.retrieveTask(i, j).getValues();
                    editWindow = new EditWindow("Edit Note", values);
                    editWindow.getEnterButton().addActionListener(this);
                    values = editWindow.getValues();
                }
            }
        }

        if(event.getSource() == leftDivisionButtons[0]){
            newTask = true;
            editWindow = new EditWindow("New Note");
            editWindow.getEnterButton().addActionListener(this);
            values = editWindow.getValues();
        }

        if(event.getSource() == editWindow.getEnterButton()){
            editWindow.updateValues();
            values = editWindow.getValues();
            if(newTask){
                records.addLastTask(new Task(values[0], values[1], values[2]), 0);
            } else {
                records.editTask(currentPosition[0], currentPosition[1], values);
            }
            editWindow.dispose();
        }

        if(event.getSource() == rightDivisionButtons[0]){
            saving = true;
            fileWindow = new FileWindow("Save File");
            fileWindow.getEnterButton().addActionListener(this);
        }

        if(event.getSource() == rightDivisionButtons[1]){
            saving = false;
            fileWindow = new FileWindow("Load File");
            fileWindow.getEnterButton().addActionListener(this);
        }
//
        if(event.getSource() == fileWindow.getEnterButton()){
            fileWindow.updateValue();
            fileName = fileWindow.getValue();
            if(saving == true){
                try {
                    records.saveToFile(fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(saving == false){
                records.loadFromFile(fileName);
            }
            fileWindow.dispose();
        }

        resetNotes();
    }
}
