// Reviewed on 08/03/2022 at 1:59PM

package ProgressTracker;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import ProgressTracker.Panels.*;

public class MyFrame extends JFrame implements ActionListener{
/*== Main Panels =====================================================================================================================*/
    private FivePanel mainPanel;
    private FivePanel removePanel;
    private LoginPanel loginPanel;
    private BoardPanel boardPanel;
    private ToDoPanel toDoPanel;
    private CompletedPanel completedPanel;
    private SettingsPanel settingsPanel;
    private TaskViewPanel taskViewPanel;
    /*== Additional Windows ==========================================================================================================*/
    private FileWindow fileWindow;
    private EditWindow editWindow;
    /*== Setup Variables =============================================================================================================*/
    private int noteCount = 4;
    private int columnCount = 4;
    private int rowCount = 16;
    /*== Saving Variables ============================================================================================================*/
    private String fileName = "SaveFile.txt";
    private String[] values = new String[3];
    private int[] currentPosition = new int[2];
    private boolean newTask, saving;
    /*== Records =====================================================================================================================*/
    Task task;
    Records records = new Records(columnCount + 2); // I think this will be the correct input
    Palette palette = new Palette();
    /*================================================================================================================================*/
    MyFrame(){
        windowSetup();
        panelsSetup();
        editAndFileWindowSetup();
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
        settingsPanel = new SettingsPanel(this, records);
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
    //
    // Right now the way that rows work is different from columns, but it would be better if they were made more similar.
    public void resetNotes(){
        for(int counterA = 0; counterA < columnCount; counterA++){
            for(int counterB = 0; counterB < noteCount; counterB++){
                task = records.retrieveTask((counterA + 1), counterB);
                if(task != null){
                    boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).getTitle().setText(task.getTitle());
                    boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).getContents().setText(task.getContents());
                    boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).getUser().setText(task.getUser());
                    boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).setVisible(true);
                } else {
                    boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).setVisible(false);
                }
            }
        }for(int counter = 0; counter < 16; counter++){
            task = records.retrieveTask(0, counter);
            if(task != null){
                toDoPanel.getRowPanels().get(counter).setBackground(palette.getRowPanelsColors(counter));
                toDoPanel.getRowPanels().get(counter).getFunctionButton().setVisible(true);
                toDoPanel.getRowPanels().get(counter).getEditButton().setVisible(true);
                toDoPanel.getRowPanels().get(counter).getTitle().setVisible(true);
                toDoPanel.getRowPanels().get(counter).getContents().setVisible(true);
                toDoPanel.getRowPanels().get(counter).getUser().setVisible(true);
                toDoPanel.getRowPanels().get(counter).getTitle().setText(task.getTitle());
                toDoPanel.getRowPanels().get(counter).getContents().setText(task.getContents());
                toDoPanel.getRowPanels().get(counter).getUser().setText(task.getUser());
                toDoPanel.getRowPanels().get(counter).getFunctionButton().setText("==>");
                toDoPanel.getRowPanels().get(counter).setVisible(true);
            } else {
                // toDoPanel.getRowPanels().get(counter).setVisible(false);
                toDoPanel.getRowPanels().get(counter).getTitle().setVisible(false);
                toDoPanel.getRowPanels().get(counter).getContents().setVisible(false);
                toDoPanel.getRowPanels().get(counter).getUser().setVisible(false);
                toDoPanel.getRowPanels().get(counter).setBackground(palette.getColumnPanelsColors(0));
                toDoPanel.getRowPanels().get(counter).getFunctionButton().setVisible(false);
                toDoPanel.getRowPanels().get(counter).getEditButton().setVisible(false);
            }
        }
        for(int counter = 0; counter < 16; counter++){
            task = records.retrieveTask(columnCount + 1, counter);
            if(task != null){
                completedPanel.getRowPanels().get(counter).setBackground(palette.getRowPanelsColors(counter));
                completedPanel.getRowPanels().get(counter).getFunctionButton().setVisible(true);
                completedPanel.getRowPanels().get(counter).getEditButton().setVisible(true);
                completedPanel.getRowPanels().get(counter).getTitle().setVisible(true);
                completedPanel.getRowPanels().get(counter).getContents().setVisible(true);
                completedPanel.getRowPanels().get(counter).getUser().setVisible(true);
                completedPanel.getRowPanels().get(counter).getTitle().setText(task.getTitle());
                completedPanel.getRowPanels().get(counter).getContents().setText(task.getContents());
                completedPanel.getRowPanels().get(counter).getUser().setText(task.getUser());
                completedPanel.getRowPanels().get(counter).getFunctionButton().setText("<==");
                completedPanel.getRowPanels().get(counter).setVisible(true);
            } else {
                //completedPanel.getRowPanels().get(counter).setVisible(false);
                completedPanel.getRowPanels().get(counter).getTitle().setVisible(false);
                completedPanel.getRowPanels().get(counter).getContents().setVisible(false);
                completedPanel.getRowPanels().get(counter).getUser().setVisible(false);
                completedPanel.getRowPanels().get(counter).setBackground(palette.getColumnPanelsColors(0));
                completedPanel.getRowPanels().get(counter).getFunctionButton().setVisible(false);
                completedPanel.getRowPanels().get(counter).getEditButton().setVisible(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        for(int counterA = 0; counterA < 4; counterA++){
            for(int counterB = 0; counterB < 4; counterB++){
                if(event.getSource() == boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).getLeftButton()){
                    records.moveBackTask((counterA + 1), counterB);
                } else if(event.getSource() == boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).getRightButton()){
                    records.moveForwardTask((counterA + 1), counterB);
                } else if(event.getSource() == boardPanel.getColumnPanels().get(counterA).getNotePanels().get(counterB).getBottomButton()){
                    newTask = false;
                    currentPosition[0] = counterA + 1;
                    currentPosition[1] = counterB;
                    values = records.retrieveTask((counterA + 1), counterB).getValues();
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
            // values = editWindow.getValues(); // <-------------------------------------------------------------------------------------
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

        if(event.getSource() == editWindow.getEnterButton()){
            editWindow.updateValues();
            values = editWindow.getValues();
            if(newTask){
                records.addLastTask(new Task(values[0], values[1], values[2]), (0 + 1));    // This I think is right.
            } else {
                records.editTask(currentPosition[0], currentPosition[1], values);     // This I think is right.
            }
            editWindow.dispose();
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

        FivePanel[] panels = {toDoPanel, boardPanel, completedPanel, settingsPanel};
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

        if(event.getSource() == loginPanel.getEnterButton()){
            removePanel = mainPanel;
            mainPanel = boardPanel;
            add(mainPanel);
            remove(removePanel);
            revalidate();
            repaint();
        }

        for(int counter = 0; counter < 16; counter++){
            if(event.getSource() == toDoPanel.getRowPanels().get(counter).getEditButton()){
                newTask = false;
                currentPosition[0] = 0;
                currentPosition[1] = counter;
                values = records.retrieveTask(0, counter).getValues();
                editWindow = new EditWindow("Edit Note", values);
                editWindow.getEnterButton().addActionListener(this);
                values = editWindow.getValues();
            } else if(event.getSource() == toDoPanel.getRowPanels().get(counter).getFunctionButton()){
                records.moveForwardTask(0, counter);
            }
        }

        for(int counter = 0; counter < 16; counter++){
            if(event.getSource() == completedPanel.getRowPanels().get(counter).getEditButton()){
                newTask = false;
                currentPosition[0] = columnCount + 1;
                currentPosition[1] = counter;
                values = records.retrieveTask(columnCount + 1, counter).getValues();
                editWindow = new EditWindow("Edit Note", values);
                editWindow.getEnterButton().addActionListener(this);
                values = editWindow.getValues();
            } else if(event.getSource() == completedPanel.getRowPanels().get(counter).getFunctionButton()){
                records.moveBackTask(columnCount + 1, counter);
            }
        }

        resetNotes();
    }
    //===============================================================================================================================//
    //===============================================================================================================================//
    //===============================================================================================================================//
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
}