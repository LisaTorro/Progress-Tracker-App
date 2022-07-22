import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{

    // SAVE FILE
    String fileName = "SaveFile.txt";

    // Variables for the full screen.
    JPanel mainPanel;
    Color mainPanelColor;

    // Variables for the main divisions of the screen. (North, East, South, West, Center)
    JPanel[] layoutPanels = new JPanel[5];
    Color[] layoutPanelsColors = new Color[5];
    String[] layoutPanelsValues = {BorderLayout.NORTH, BorderLayout.WEST, BorderLayout.CENTER, BorderLayout.EAST, BorderLayout.SOUTH};
    // int layoutPanelsWidth = 100, layoutPanelsHeight = 100;
    Dimension layoutPanelsDimension = new Dimension(100, 100);

    // Variables for the columns.
    JPanel[] columnPanels = new JPanel[4];
    Color[] columnPanelsColors = new Color[4];

    // Variables for the notes.
    Note[][] notePanels = new Note[4][4];
    Color[][] notePanelsColors = new Color[4][4];
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

    MyFrame(){

        // ARTIFICIALLY STOCKING RECORDS
        // records.stock();

        setColors();

        windowSetup();

        screenSetup();

        divisionSetup();

        leftDivisionSetup();

        rightDivisionSetup();

        columnSetup();

        notesSetup();        

        resetNotes();
    }

    public void setColors(){
        mainPanelColor = Color.BLACK;
        int colorValue = 200;
        for(int i = 0; i < 5; i++){
            layoutPanelsColors[i] = new Color(colorValue, colorValue, colorValue);
            colorValue -= 20;
        }
        colorValue = 40;
        for(int i = 0; i < 4; i++){
            columnPanelsColors[i] = new Color(colorValue, colorValue, colorValue);
            colorValue += 20;
        }
        colorValue = 255;
        for(int i = 0; i < 4; i++){
            notePanelsColors[0][i] = new Color(colorValue, colorValue, colorValue);
            notePanelsColors[1][i] = new Color(colorValue,0,0);
            notePanelsColors[2][i] = new Color(0, colorValue,0);
            notePanelsColors[3][i] = new Color(0,0, colorValue);
            colorValue -= 20;
        }

    }

    public void windowSetup(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setResizable(true);
        this.setVisible(true);
    }

    public void screenSetup(){
        mainPanel = new JPanel(new BorderLayout());
        this.add(mainPanel);
    }

    public void divisionSetup(){
        for(int i = 0; i < 5; i++){
            layoutPanels[i] = new JPanel();
            layoutPanels[i].setPreferredSize(layoutPanelsDimension);
            layoutPanels[i].setBackground(layoutPanelsColors[i]);
            mainPanel.add(layoutPanels[i], layoutPanelsValues[i]);
        }
    }

    public void columnSetup(){
        layoutPanels[2].setLayout(new GridLayout(1, 4, 10, 10));
        for(int i = 0; i < 4; i++){
            columnPanels[i] = new JPanel();
            columnPanels[i].setLayout(new GridLayout(4, 1, 10, 10));
            columnPanels[i].setBackground(columnPanelsColors[i]);
            layoutPanels[2].add(columnPanels[i]);
        }
    }
    
    public void notesSetup(){
        for(int i = 0; i < 4; i++){
            notePanelsWidth =  columnPanels[i].getWidth() - 20;
            notePanelsHeight = (columnPanels[i].getHeight() - 50) / 5;
            notePanelsDimension = new Dimension(notePanelsWidth, notePanelsHeight);
            for(int j = 0; j < 4; j++){
                notePanels[i][j] = new Note(new BorderLayout(), notePanelsColors[i][j], notePanelsDimension, JLabel.CENTER);
                notePanels[i][j].getLeftButton().addActionListener(this);
                notePanels[i][j].getRightButton().addActionListener(this);
                notePanels[i][j].getBottomButton().addActionListener(this);
                columnPanels[i].add(notePanels[i][j]);
            }
        }
    }

    public void leftDivisionSetup(){

        leftDivisionButtons[0] = new JButton();
        leftDivisionButtons[0].addActionListener(this);
        leftDivisionButtons[0].setBackground(Color.PINK);
        leftDivisionButtons[0].setPreferredSize(new Dimension(50, 50));
        layoutPanels[1].setLayout(new FlowLayout());
        layoutPanels[1].add(leftDivisionButtons[0]);


    }

    public void rightDivisionSetup(){
        rightDivisionButtons[0] = new JButton();
        rightDivisionButtons[0].addActionListener(this);
        rightDivisionButtons[0].setBackground(Color.ORANGE);
        rightDivisionButtons[0].setPreferredSize(new Dimension(50, 50));
        rightDivisionButtons[1] = new JButton();
        rightDivisionButtons[1].addActionListener(this);
        rightDivisionButtons[1].setBackground(new Color(230, 230, 250));
        rightDivisionButtons[1].setPreferredSize(new Dimension(50, 50));
        layoutPanels[3].setLayout(new FlowLayout());
        layoutPanels[3].add(rightDivisionButtons[0]);
        layoutPanels[3].add(rightDivisionButtons[1]);
    }

    public void resetNotes(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                task = records.getTask(i, j);
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
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource().toString());

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(e.getSource() == notePanels[i][j].getLeftButton()){
                    if(i == 0){
                        records.removeTask(i, j);
                    } else {
                        records.moveBackTask(i, j);
                    }

                } else if(e.getSource() == notePanels[i][j].getRightButton()){
                    if(i != 3){
                        records.moveForwardTask(i, j);
                    } else {
                        records.removeTask(i, j);
                    }
                } else if(e.getSource() == notePanels[i][j].getBottomButton()){
                    newTask = false;
                    currentPosition[0] = i;
                    currentPosition[1] = j;
                    values = records.getTask(i, j).getValues();
                    editWindow = new EditWindow("Edit Note", values);
                    editWindow.getEnterButton().addActionListener(this);
                    values = editWindow.getValues();
                }
            }
        }

        if(e.getSource() == leftDivisionButtons[0]){
            newTask = true;
            editWindow = new EditWindow("New Note");
            editWindow.getEnterButton().addActionListener(this);
            values = editWindow.getValues();
        }

        if(e.getSource() == editWindow.getEnterButton()){
            editWindow.updateValues();
            values = editWindow.getValues();
            if(newTask){
                records.addTask(new Task(values[0], values[1], values[2]));
            } else {
                records.editTask(currentPosition[0], currentPosition[1], values);
            }
            editWindow.dispose();
        }

        if(e.getSource() == rightDivisionButtons[0]){
            try {
                records.saveToFile(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(e.getSource() == rightDivisionButtons[1]){
            try {
                records.loadFromFile(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        resetNotes();
    }
}