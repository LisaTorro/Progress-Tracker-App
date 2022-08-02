// Reviewed on 08/02/2022 at 9:13 AM
// More attention should be given to resetNotes and actionPreformed.

package ProgressTracker;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import ProgressTracker.Panels.*;

public class MyFrame extends JFrame implements ActionListener{
/*== Main Panels =====================================================================================================================*/
    FivePanel mainPanel, removePanel;
    LoginPanel loginPanel;
    BoardPanel boardPanel;
    ToDoPanel toDoPanel;
    CompletedPanel completedPanel;
    SettingsPanel settingsPanel;
    TaskViewPanel taskViewPanel;
/*== Additional Windows ==============================================================================================================*/
    FileWindow fileWindow;
    EditWindow editWindow;
/*== Records =========================================================================================================================*/
    Records records = new Records();
    Task task;
    Palette palette = new Palette();
/*== Setup Variables =================================================================================================================*/
    int columnCount = 4, noteCount = 4;
    int rowCount = 16;
/*== Saving Variables ================================================================================================================*/
    String fileName = "SaveFile.txt";
    String[] values = new String[3];
    int[] currentPosition = new int[2];
    boolean newTask, saving;
/*====================================================================================================================================*/

    MyFrame(){
        windowSetup();
        panelsSetup();
        editAndFileWindowSetup();
        resetNotes();
    }

    public void windowSetup(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setResizable(true);
        this.setVisible(true);
    }

    public void panelsSetup(){
        loginPanel = new LoginPanel(this);
        boardPanel = new BoardPanel(this, records, columnCount, noteCount);
        toDoPanel = new ToDoPanel(this, records, rowCount);
        completedPanel = new CompletedPanel(this, records, rowCount);
        settingsPanel = new SettingsPanel(this, records, rowCount);
        taskViewPanel = new TaskViewPanel(this, records, rowCount);
        mainPanel = loginPanel;
        add(mainPanel);
    }

    public void editAndFileWindowSetup(){
        editWindow = new EditWindow("");
        editWindow.setVisible(false);
        fileWindow = new FileWindow("");
        fileWindow.setVisible(false);
    }

    // Right now this goes through every column, and for each column it goes through every note, and for each note it updates.
    // If each task had a function to do the appropriate thing this could be a lot simpler.
    public void resetNotes(){
        for(int counterA = 0; counterA < 4; counterA++){
            for(int counterB = 0; counterB < 4; counterB++){
                task = records.retrieveTask(counterA, counterB);
                if(task != null){
                    boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).getTitle().setText(task.getTitle());
                    boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).getContents().setText(task.getContents());
                    boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).getUser().setText(task.getUser());
                    boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).setVisible(true);
                } else {
                    boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).setVisible(false);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // System.out.println(event.getSource().toString());
        /*----------------------------------------------------------------------------------------------------------------------------*/    
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
        /*----------------------------------------------------------------------------------------------------------------------------*/
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
        /*----------------------------------------------------------------------------------------------------------------------------*/
        FivePanel[] panels = {boardPanel, toDoPanel, completedPanel, settingsPanel};
        for(int counter = 0; counter < 4; counter++){
            if(event.getSource() == boardPanel.getSouthButtons().get(counter) ||
                event.getSource() == toDoPanel.getSouthButtons().get(counter) ||
                event.getSource() == completedPanel.getSouthButtons().get(counter) ||
                event.getSource() == settingsPanel.getSouthButtons().get(counter) ||
                event.getSource() == taskViewPanel.getSouthButtons().get(counter)){
                removePanel = mainPanel;
                mainPanel = panels[counter];
                if(mainPanel != removePanel){
                    add(mainPanel);
                    remove(removePanel);
                }
                revalidate();
                repaint();
            }
        }
        /*----------------------------------------------------------------------------------------------------------------------------*/
        if(event.getSource() == loginPanel.getEnterButton()){
            removePanel = mainPanel;
            mainPanel = boardPanel;
            add(mainPanel);
            remove(removePanel);
            revalidate();
            repaint();
        }
        /*----------------------------------------------------------------------------------------------------------------------------*/
        resetNotes();
    }
}