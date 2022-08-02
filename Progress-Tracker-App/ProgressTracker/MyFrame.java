package ProgressTracker;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import ProgressTracker.Panels.*;

public class MyFrame extends JFrame implements ActionListener{

    /*==Old Variables==================================================================================================================*/
    String fileName = "SaveFile.txt";
    Records records = new Records();
    Task task;
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
    ToDoPanel toDoPanel;
    CompletedPanel completedPanel;
    int columnCount = 4, noteCount = 4;
    int rowCount = 16;
    

    MyFrame(){

        windowSetup();
        boardPanel = new BoardPanel(this, records, columnCount, noteCount);
        toDoPanel = new ToDoPanel(this, records, rowCount);
        completedPanel = new CompletedPanel(this, records, rowCount);
        mainPanel = boardPanel;
        add(mainPanel);
        editAndFileWindowSetup();
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

    public void resetNotes(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                task = records.retrieveTask(i, j);
                if(task != null){
                    boardPanel.getColumnPanels().get(i).getNotePanels().get(j).getTitle().setText(task.title);
                    boardPanel.getColumnPanels().get(i).getNotePanels().get(j).getContents().setText(task.contents);
                    boardPanel.getColumnPanels().get(i).getNotePanels().get(j).getUser().setText(task.user);
                    boardPanel.getColumnPanels().get(i).getNotePanels().get(j).setVisible(true);
                } else {
                    boardPanel.getColumnPanels().get(i).getNotePanels().get(j).setVisible(false);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getSource().toString());

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(event.getSource() == boardPanel.getColumnPanels().get(i).getNotePanels().get(j).getLeftButton()){
                    if(i == 0){
                        records.removeTask(i, j);
                    } else {
                        records.moveBackTask(i, j);
                    }

                } else if(event.getSource() == boardPanel.getColumnPanels().get(i).getNotePanels().get(j).getRightButton()){
                    if(i != 3){
                        records.moveForwardTask(i, j);
                    } else {
                        records.removeTask(i, j);
                    }
                } else if(event.getSource() == boardPanel.getColumnPanels().get(i).getNotePanels().get(j).getBottomButton()){
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

        if(event.getSource() == boardPanel.getWestButtons().get(0)){
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

        if(event.getSource() == boardPanel.getWestButtons().get(1)){
            saving = true;
            fileWindow = new FileWindow("Save File");
            fileWindow.getEnterButton().addActionListener(this);
        }

        if(event.getSource() == boardPanel.getWestButtons().get(2)){
            saving = false;
            fileWindow = new FileWindow("Load File");
            fileWindow.getEnterButton().addActionListener(this);
        }

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

        if(event.getSource() == boardPanel.getSouthButtons().get(0)){
            mainPanel = toDoPanel;
            add(mainPanel);
            remove(boardPanel);
            revalidate();
            repaint();
        }

        if(event.getSource() == boardPanel.getSouthButtons().get(1)){
            mainPanel = completedPanel;
            add(mainPanel);
            remove(boardPanel);
            revalidate();
            repaint();
        }

        if(event.getSource() == toDoPanel.getSouthButtons().get(0)){
            mainPanel = boardPanel;
            add(mainPanel);
            remove(toDoPanel);
            revalidate();
            repaint();
        }

        if(event.getSource() == completedPanel.getSouthButtons().get(0)){
            mainPanel = boardPanel;
            add(mainPanel);
            remove(completedPanel);
            revalidate();
            repaint();
        }

        resetNotes();
    }
}
