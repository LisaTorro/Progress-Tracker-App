/*
 * Written by:          Thomas Williams
 * Last Updated:        08/18/2022, at 2:08PM(PT)
 * Version:             1.1
 * Coding Module ID(s): All CM IDs are related to this file.
 */

package ProgressTracker;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import ProgressTracker.ProgressTracker.*;

public class MyFrame extends JFrame implements ActionListener{

    private FivePanel   mainPanel,
                        removePanel;
    private LoginPanel  loginPanel;
    private BoardPanel  boardPanel;
    private ToDoPanel   toDoPanel;
    private CompletedPanel  completedPanel;
    private SettingsPanel   settingsPanel;
    private TaskViewPanel   taskViewPanel;
    private FileWindow  fileWindow;
    private EditWindow  editWindow;
    private int noteCount = 4,
                columnCount = 4,
                rowCount = 16;
    private String  fileName;
    private String[]    values;
    private int[]   currentPosition = new int[2];
    private boolean newTask,
                    saving;
    private Palette palette = new Palette();
    private Dimension   smallDimension = new Dimension(100, 100);
    private Records records = new Records(columnCount + 2);
    private String loginFileName = "LOGIN.txt";
    private LoginHandler loginHandler = new LoginHandler(loginFileName);

    MyFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setResizable(true);
        setVisible(true);
        setEditWindow(new EditWindow(this, ""));
        getEditWindow().setVisible(false);
        setFileWindow(new FileWindow(this, ""));
        getFileWindow().setVisible(false);
        setLoginPanel(new LoginPanel(this));
        setBoardPanel(new BoardPanel(this));
        setToDoPanel(new ToDoPanel(this));
        setCompletedPanel(new CompletedPanel(this));
        setSettingsPanel(new SettingsPanel(this));
        setTaskViewPanel(new TaskViewPanel(this));
        setMainPanel(getLoginPanel());
        add(getMainPanel());
    }

    public void updatePaint(){
        getLoginPanel().updatePaint();
        getToDoPanel().updatePaint();
        getBoardPanel().updatePaint();
        getCompletedPanel().updatePaint();
        getSettingsPanel().updatePaint();
        getTaskViewPanel().updatePaint();
        getEditWindow().updatePaint();
        getFileWindow().updatePaint();
    }

    public void updateFonts(){
        getLoginPanel().updateFonts();
        getToDoPanel().updateFonts();
        getBoardPanel().updateFonts();
        getCompletedPanel().updateFonts();
        getSettingsPanel().updateFonts();
        getTaskViewPanel().updateFonts();
        getEditWindow().updateFonts();
        getFileWindow().updateFonts();
    }

    public void updateBorders(){
        getLoginPanel().updateBorders();
        getToDoPanel().updateBorders();
        getBoardPanel().updateBorders();
        getCompletedPanel().updateBorders();
        getSettingsPanel().updateBorders();
        getTaskViewPanel().updateBorders();
        getEditWindow().updateBorders();
        getFileWindow().updateBorders();
    }

    public void updateNotes(){
        // getLoginPanel().updateNotes();
        getToDoPanel().updateNotes();
        getBoardPanel().updateNotes();
        getCompletedPanel().updateNotes();
        // getSettingsPanel().updateNotes();
        // getTaskViewPanel().updateNotes();
        // getEditWindow().updateNotes();
        // getFileWindow().updateNotes();
    }

    public void updateQuantities(){
        // getLoginPanel().updateQuantities();
        getToDoPanel().updateQuantities();
        getBoardPanel().updateQuantities();
        getCompletedPanel().updateQuantities();
        // getSettingsPanel().updateQuantities();
        // getTaskViewPanel().updateQuantities();
        // getEditWindow().updateQuantities();
        // getFileWindow().updateQuantities();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //  LOGIN PANEL:    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // EVENTUALLY MODIFIY FOR PROCESSING INPUT INFORMATION
        if(event.getSource() == loginPanel.getEnterButton()){
            String  inputUsername = loginPanel.getUsername().getText(),
                    inputPassword = String.valueOf(loginPanel.getPassword().getPassword());
            try {
                if(loginHandler.takeRequest(inputUsername, inputPassword)){
                    switchToPanel(boardPanel);
                }
            } catch (IOException loginException) {
                loginException.printStackTrace();
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //  TODOPANEL:  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for(int counter = 0; counter < rowCount; counter++){
            SmallNotePanel smallNotePanel = toDoPanel.getRowPanels().get(counter).getSmallNotePanel();
            if(event.getSource() == smallNotePanel.getFunctionButton()){
                records.moveForwardTask(0, counter);
            } else if(event.getSource() == smallNotePanel.getTitle()){
                taskViewPanel.modify(records.retrieveTask(0, counter).getValues());
                switchToPanel(taskViewPanel);
            } else if(event.getSource() == smallNotePanel.getContents()){
                newTask = false;
                currentPosition[0] = 0;
                currentPosition[1] = counter;
                values = records.retrieveTask(0, counter).getValues();
                editWindow = new EditWindow(this, "Edit Note", values);
            } else if(event.getSource() == smallNotePanel.getUser()){
                // PLACE HOLDER
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //  BOARD PANEL:    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for(int counterA = 0; counterA < columnCount; counterA++){
            for(int counterB = 0; counterB < noteCount; counterB++){
                if(event.getSource() == boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).getLeftButton()){
                    records.moveBackTask((counterA + 1), counterB);
                } else if(event.getSource() == boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).getRightButton()){
                    records.moveForwardTask((counterA + 1), counterB);
                } else if(event.getSource() == boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).getTitle()){
                    taskViewPanel.modify(records.retrieveTask((counterA + 1), counterB).getValues());
                    switchToPanel(taskViewPanel);
                } else if(event.getSource() == boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).getContents()){
                    newTask = false;
                    currentPosition[0] = counterA + 1;
                    currentPosition[1] = counterB;
                    values = records.retrieveTask((counterA + 1), counterB).getValues();
                    editWindow = new EditWindow(this, "Edit Note", values);
                    // editWindow.getEnterButton().addActionListener(this);
                } else if(event.getSource() == boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).getUser()){
                    // PLACE HOLDER
                }
            }
        }
        if(event.getSource() == boardPanel.getWestButtons().get(0)){
            newTask = true;
            editWindow = new EditWindow(this, "New Note");
            // editWindow.getEnterButton().addActionListener(this);
        }
        if(event.getSource() == boardPanel.getWestButtons().get(1)){
            saving = true;
            fileWindow = new FileWindow(this, "Save File");
            // fileWindow.getEnterButton().addActionListener(this);
        }
        if(event.getSource() == boardPanel.getWestButtons().get(2)){
            saving = false;
            fileWindow = new FileWindow(this, "Load File");
            // fileWindow.getEnterButton().addActionListener(this);
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //  COMPLETED PANEL:    ///////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for(int counter = 0; counter < rowCount; counter++){
            SmallNotePanel smallNotePanel = completedPanel.getRowPanels().get(counter).getSmallNotePanel();
            if(event.getSource() == smallNotePanel.getFunctionButton()){
                records.moveBackTask(columnCount + 1, counter);
            } else if(event.getSource() == smallNotePanel.getTitle()){
                taskViewPanel.modify(records.retrieveTask(columnCount + 1, counter).getValues());
                switchToPanel(taskViewPanel);
            } else if(event.getSource() == smallNotePanel.getContents()){
                newTask = false;
                currentPosition[0] = columnCount + 1;
                currentPosition[1] = counter;
                values = records.retrieveTask(columnCount + 1, counter).getValues();
                editWindow = new EditWindow(this, "Edit Note", values);
                // editWindow.getEnterButton().addActionListener(this);
            } else if(event.getSource() == smallNotePanel.getUser()){
                // PLACE HOLDER
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //  SETTINGS PANEL: ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(event.getSource() == settingsPanel.getColorSchemeButton()){
            palette.setColorScheme(Integer.parseInt(settingsPanel.getColorSchemeInput().getText()));
            updatePaint();
        } else if(event.getSource() == settingsPanel.getDefaultFontButton()){
            palette.setFontScheme(Integer.parseInt(settingsPanel.getDefaultFontInput().getText()));
            updateFonts();
        } else if(event.getSource() == settingsPanel.getColumnCountButton()){
            try {
                records.saveToFile("TEMPORARY.txt");
                int newColumnCount = Integer.parseInt(settingsPanel.getColumnCountInput().getText());
                setColumnCount(newColumnCount);
                toDoPanel = new ToDoPanel(this);
                boardPanel = new BoardPanel(this);
                completedPanel = new CompletedPanel(this);
                records = new Records(getColumnCount() + 2);
                records.loadFromFile("TEMPORARY.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(event.getSource() == settingsPanel.getNoteCountButton()){
            try {
                records.saveToFile("TEMPORARY.txt");
                int newNoteCount = Integer.parseInt(settingsPanel.getNoteCountInput().getText());
                setNoteCount(newNoteCount);
                toDoPanel = new ToDoPanel(this);
                boardPanel = new BoardPanel(this);
                completedPanel = new CompletedPanel(this);
                records = new Records(getColumnCount() + 2);
                records.loadFromFile("TEMPORARY.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(event.getSource() == settingsPanel.getRowCountButton()){
            try {
                records.saveToFile("TEMPORARY.txt");
                int newRowCount = Integer.parseInt(settingsPanel.getRowCountInput().getText());
                setRowCount(newRowCount);
                toDoPanel = new ToDoPanel(this);
                boardPanel = new BoardPanel(this);
                completedPanel = new CompletedPanel(this);
                records = new Records(getColumnCount() + 2);
                records.loadFromFile("TEMPORARY.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //  TASKVIEW PANEL: ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //  EDIT WINDOW:    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(event.getSource() == editWindow.getEnterButton()){
            System.out.println(currentPosition[0] + ":" + currentPosition[1]);
            values = editWindow.getCurrentValue();
            if(newTask){
                records.addLastTask(new Task(values[0], values[1], values[2]), (0 + 1));
            } else {
                records.editTask(currentPosition[0], currentPosition[1], values);
            }
            editWindow.dispose();
        }
        if(event.getSource() == editWindow.getDeleteButton()){
            System.out.println(currentPosition[0] + ":" + currentPosition[1]);
            if(newTask){
            } else{
                records.removeTask(currentPosition[0], currentPosition[1]);
            }
            editWindow.dispose();
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //  FILE WINDOW:    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(event.getSource() == fileWindow.getEnterButton()){
            fileName = fileWindow.getCurrentValue();
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
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // MULTIPLE PANELS: ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        FivePanel[] panels = {toDoPanel, boardPanel, completedPanel, settingsPanel};
        for(int counter = 1; counter < 5; counter++){
            if(event.getSource() == boardPanel.getSouthButtons().get(counter) ||
                event.getSource() == toDoPanel.getSouthButtons().get(counter) ||
                event.getSource() == completedPanel.getSouthButtons().get(counter) ||
                event.getSource() == settingsPanel.getSouthButtons().get(counter) ||
                event.getSource() == taskViewPanel.getSouthButtons().get(counter)){
                switchToPanel(panels[counter - 1]);
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        updateNotes();
    }

    public void switchToPanel(FivePanel inputPanel){
        setRemovePanel(getMainPanel());
        setMainPanel(inputPanel);
        if(getMainPanel() != getRemovePanel()){
            add(getMainPanel());
            remove(getRemovePanel());
        }
        revalidate();
        repaint();
    }

    public FivePanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(FivePanel mainPanel) {
        this.mainPanel = mainPanel;
    }
    
    public FivePanel getRemovePanel() {
        return removePanel;
    }

    public void setRemovePanel(FivePanel removePanel) {
        this.removePanel = removePanel;
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    public void setLoginPanel(LoginPanel loginPanel) {
        this.loginPanel = loginPanel;
    }
    
    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public void setBoardPanel(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }

    public ToDoPanel getToDoPanel() {
        return toDoPanel;
    }

    public void setToDoPanel(ToDoPanel toDoPanel) {
        this.toDoPanel = toDoPanel;
    }
    
    public CompletedPanel getCompletedPanel() {
        return completedPanel;
    }

    public void setCompletedPanel(CompletedPanel completedPanel) {
        this.completedPanel = completedPanel;
    }
    public SettingsPanel getSettingsPanel() {
        return settingsPanel;
    }

    public void setSettingsPanel(SettingsPanel settingsPanel) {
        this.settingsPanel = settingsPanel;
    }

    public TaskViewPanel getTaskViewPanel() {
        return taskViewPanel;
    }
    
    public void setTaskViewPanel(TaskViewPanel taskViewPanel) {
        this.taskViewPanel = taskViewPanel;
    }

    public FileWindow getFileWindow() {
        return fileWindow;
    }

    public void setFileWindow(FileWindow fileWindow) {
        this.fileWindow = fileWindow;
    }

    public EditWindow getEditWindow() {
        return editWindow;
    }

    public void setEditWindow(EditWindow editWindow) {
        this.editWindow = editWindow;
    }

    public int getNoteCount() {
        return noteCount;
    }

    public void setNoteCount(int noteCount) {
        this.noteCount = noteCount;
    }
    
    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    public int[] getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int[] currentPosition) {
        this.currentPosition = currentPosition;
    }
    
    public boolean isNewTask() {
        return newTask;
    }

    public void setNewTask(boolean newTask) {
        this.newTask = newTask;
    }

    public boolean isSaving() {
        return saving;
    }

    public void setSaving(boolean saving) {
        this.saving = saving;
    }

    public Palette getPalette() {
        return palette;
    }

    public void setPalette(Palette palette) {
        this.palette = palette;
    }

    public Dimension getSmallDimension() {
        return smallDimension;
    }

    public void setSmallDimension(Dimension smallDimension) {
        this.smallDimension = smallDimension;
    }

    public Records getRecords() {
        return records;
    }

    public void setRecords(Records records) {
        this.records = records;
    }

    public LoginHandler getLoginHandler() {
        return loginHandler;
    }

    public void setLoginHandler(LoginHandler loginHandler) {
        this.loginHandler = loginHandler;
    }
}