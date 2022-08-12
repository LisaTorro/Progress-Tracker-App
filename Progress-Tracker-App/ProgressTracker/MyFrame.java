// Reviewed on 08/12/2022

package ProgressTracker;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import ProgressTracker.Panels.*;

public class MyFrame extends JFrame implements ActionListener{
    private FivePanel mainPanel;
    private FivePanel removePanel;
    private LoginPanel loginPanel;
    private BoardPanel boardPanel;
    private ToDoPanel toDoPanel;
    private CompletedPanel completedPanel;
    private SettingsPanel settingsPanel;
    private TaskViewPanel taskViewPanel;
    private FileWindow fileWindow;
    private EditWindow editWindow;
    private int noteCount = 4;
    private int columnCount = 4;
    private int rowCount = 16;
    private String fileName;// <------------------------------------------------------------------------------------------------
    private String[] values;// <------------------------------------------------------------------------------------------------
    private int[] currentPosition = new int[2];
    private boolean newTask;
    private boolean saving;
    private Task task;
    private Palette palette = new Palette();
    private Dimension smallDimension = new Dimension(100, 100);
    private Records records = new Records(columnCount + 2);

    MyFrame(){
        windowSetup();
        editAndFileWindowSetup();
        panelsSetup();
    }

    public void windowSetup(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setResizable(true);
        this.setVisible(true);
    }

    public void editAndFileWindowSetup(){
        editWindow = new EditWindow(this, "");
        editWindow.setVisible(false);
        fileWindow = new FileWindow(this, "");
        fileWindow.setVisible(false);
    }

    public void panelsSetup(){
        loginPanel = new LoginPanel(this);
        boardPanel = new BoardPanel(this);
        toDoPanel = new ToDoPanel(this);
        completedPanel = new CompletedPanel(this);
        settingsPanel = new SettingsPanel(this);
        taskViewPanel = new TaskViewPanel(this);
        mainPanel = loginPanel;
        add(mainPanel);
    }

    public void updatePaint(){
        loginPanel.updatePaint();
        toDoPanel.updatePaint();
        boardPanel.updatePaint();
        completedPanel.updatePaint();
        settingsPanel.updatePaint();
        taskViewPanel.updatePaint();
        editWindow.updatePaint();
        fileWindow.updatePaint();
    }

    public void updateFonts(){
        loginPanel.updateFonts();
        toDoPanel.updateFonts();
        boardPanel.updateFonts();
        completedPanel.updateFonts();
        settingsPanel.updateFonts();
        taskViewPanel.updateFonts();
        editWindow.updateFonts();
        fileWindow.updateFonts();
    }

    public void updateBorders(){
        loginPanel.updateBorders();
        toDoPanel.updateBorders();
        boardPanel.updateBorders();
        completedPanel.updateBorders();
        settingsPanel.updateBorders();
        taskViewPanel.updateBorders();
        editWindow.updateBorders();
        fileWindow.updateBorders();
    }

    public void updateNotes(){
        toDoPanel.updateNotes();
        boardPanel.updateNotes();
        completedPanel.updateNotes();
    }

    public void updateColumnCount(){
        boardPanel.updateColumnCount();
    }

    public void updateNoteCount(){
        boardPanel.updateNoteCount();
    }

    public void updateRowCount(){

    }

    // THIS IS BEING PHASED OUT
    public void resetNotes(){
        for(int counter = 0; counter < rowCount; counter++){
            task = records.retrieveTask(0, counter);
            if(task != null){
                toDoPanel.getRowPanels().get(counter).setBackground(palette.getRowPanelsColor());
                toDoPanel.getRowPanels().get(counter).getFunctionButton().setVisible(true);
                toDoPanel.getRowPanels().get(counter).getTitle().setVisible(true);
                toDoPanel.getRowPanels().get(counter).getContents().setVisible(true);
                toDoPanel.getRowPanels().get(counter).getUser().setVisible(true);
                toDoPanel.getRowPanels().get(counter).getTitle().setText(task.getTitle());
                toDoPanel.getRowPanels().get(counter).getContents().setText(task.getContents());
                toDoPanel.getRowPanels().get(counter).getUser().setText(task.getUser());
                toDoPanel.getRowPanels().get(counter).getFunctionButton().setText("==>");
                toDoPanel.getRowPanels().get(counter).setVisible(true);
            } else {
                toDoPanel.getRowPanels().get(counter).getTitle().setVisible(false);
                toDoPanel.getRowPanels().get(counter).getContents().setVisible(false);
                toDoPanel.getRowPanels().get(counter).getUser().setVisible(false);
                toDoPanel.getRowPanels().get(counter).setBackground(palette.getColumnPanelsColor());
                toDoPanel.getRowPanels().get(counter).getFunctionButton().setVisible(false);
            }
        }
        for(int counter = 0; counter < rowCount; counter++){
            task = records.retrieveTask(columnCount + 1, counter);
            if(task != null){
                completedPanel.getRowPanels().get(counter).setBackground(palette.getRowPanelsColor());
                completedPanel.getRowPanels().get(counter).getFunctionButton().setVisible(true);
                completedPanel.getRowPanels().get(counter).getTitle().setVisible(true);
                completedPanel.getRowPanels().get(counter).getContents().setVisible(true);
                completedPanel.getRowPanels().get(counter).getUser().setVisible(true);
                completedPanel.getRowPanels().get(counter).getTitle().setText(task.getTitle());
                completedPanel.getRowPanels().get(counter).getContents().setText(task.getContents());
                completedPanel.getRowPanels().get(counter).getUser().setText(task.getUser());
                completedPanel.getRowPanels().get(counter).getFunctionButton().setText("<==");
                completedPanel.getRowPanels().get(counter).setVisible(true);
            } else {
                completedPanel.getRowPanels().get(counter).getTitle().setVisible(false);
                completedPanel.getRowPanels().get(counter).getContents().setVisible(false);
                completedPanel.getRowPanels().get(counter).getUser().setVisible(false);
                completedPanel.getRowPanels().get(counter).setBackground(palette.getColumnPanelsColor());
                completedPanel.getRowPanels().get(counter).getFunctionButton().setVisible(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //  LOGIN PANEL:    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // EVENTUALLY MODIFIY FOR PROCESSING INPUT INFORMATION
        if(event.getSource() == loginPanel.getEnterButton()){
            removePanel = mainPanel;
            mainPanel = boardPanel;
            add(mainPanel);
            remove(removePanel);
            revalidate();
            repaint();
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //  TODOPANEL:  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for(int counter = 0; counter < rowCount; counter++){
            if(event.getSource() == toDoPanel.getRowPanels().get(counter).getFunctionButton()){
                records.moveForwardTask(0, counter);
            } else if(event.getSource() == toDoPanel.getRowPanels().get(counter).getTitle()){
                taskViewPanel.modify(records.retrieveTask(0, counter).getValues());
                removePanel = mainPanel;
                mainPanel = taskViewPanel;
                add(mainPanel);
                remove(removePanel);
                revalidate();
                repaint();
            } else if(event.getSource() == toDoPanel.getRowPanels().get(counter).getContents()){
                newTask = false;
                currentPosition[0] = 0;
                currentPosition[1] = counter;
                values = records.retrieveTask(0, counter).getValues();
                editWindow = new EditWindow(this, "Edit Note", values);
                editWindow.getEnterButton().addActionListener(this);
            } else if(event.getSource() == toDoPanel.getRowPanels().get(counter).getUser()){
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
                    removePanel = mainPanel;
                    mainPanel = taskViewPanel;
                    add(mainPanel);
                    remove(removePanel);
                    revalidate();
                    repaint();
                } else if(event.getSource() == boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).getContents()){
                    newTask = false;
                    currentPosition[0] = counterA + 1;
                    currentPosition[1] = counterB;
                    values = records.retrieveTask((counterA + 1), counterB).getValues();
                    editWindow = new EditWindow(this, "Edit Note", values);
                    editWindow.getEnterButton().addActionListener(this);
                } else if(event.getSource() == boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).getUser()){
                    // PLACE HOLDER
                }
            }
        }
        if(event.getSource() == boardPanel.getWestButtons().get(0)){
            newTask = true;
            editWindow = new EditWindow(this, "New Note");
            editWindow.getEnterButton().addActionListener(this);
        }
        if(event.getSource() == boardPanel.getWestButtons().get(1)){
            saving = true;
            fileWindow = new FileWindow(this, "Save File");
            fileWindow.getEnterButton().addActionListener(this);
        }
        if(event.getSource() == boardPanel.getWestButtons().get(2)){
            saving = false;
            fileWindow = new FileWindow(this, "Load File");
            fileWindow.getEnterButton().addActionListener(this);
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //  COMPLETED PANEL:    ///////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for(int counter = 0; counter < rowCount; counter++){
            if(event.getSource() == completedPanel.getRowPanels().get(counter).getFunctionButton()){
                records.moveBackTask(columnCount + 1, counter);
            } else if(event.getSource() == completedPanel.getRowPanels().get(counter).getTitle()){
                taskViewPanel.modify(records.retrieveTask(columnCount + 1, counter).getValues());
                removePanel = mainPanel;
                mainPanel = taskViewPanel;
                add(mainPanel);
                remove(removePanel);
                revalidate();
                repaint();
            } else if(event.getSource() == completedPanel.getRowPanels().get(counter).getContents()){
                newTask = false;
                currentPosition[0] = columnCount + 1;
                currentPosition[1] = counter;
                values = records.retrieveTask(columnCount + 1, counter).getValues();
                editWindow = new EditWindow(this, "Edit Note", values);
                editWindow.getEnterButton().addActionListener(this);
            } else if(event.getSource() == completedPanel.getRowPanels().get(counter).getUser()){
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
        /*
        } else if(event.getSource() == settingsPanel.getColumnCountButton()){
            setColumnCount(Integer.parseInt(settingsPanel.getColumnCountInput().getText()));
            try{
                records.saveToFile("REBUILD.txt");
            } catch(IOException e){
                e.printStackTrace();
            }
            records.loadFromFile("REBUILD.txt");
            updateColumnCount();
        } else if(event.getSource() == settingsPanel.getRowCountButton()){
            setRowCount(Integer.parseInt(settingsPanel.getRowCountInput().getText()));


        }
        */
    }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //  TASKVIEW PANEL: ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //  EDIT WINDOW:    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(event.getSource() == editWindow.getEnterButton()){
            values = editWindow.getCurrentValue();
            if(newTask){
                records.addLastTask(new Task(values[0], values[1], values[2]), (0 + 1));
            } else {
                records.editTask(currentPosition[0], currentPosition[1], values);
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
                removePanel = mainPanel;
                mainPanel = panels[counter - 1];
                if(mainPanel != removePanel){
                    add(mainPanel);
                    remove(removePanel);
                }
                revalidate();
                repaint();
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        resetNotes();
        updateNotes();
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
}