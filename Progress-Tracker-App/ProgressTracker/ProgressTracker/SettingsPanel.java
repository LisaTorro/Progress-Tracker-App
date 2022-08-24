/*
 * Written by:          Thomas Williams
 * Last Updated:        08/24/2022, at 8:28AM(PT)
 * Version:             1.2
 * Coding Module ID(s): 9.1, 9.2, 9.3
 */

package ProgressTracker.ProgressTracker;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import ProgressTracker.*;

public class SettingsPanel extends FivePanel{

    private LinkedList<JButton> southButtons = new LinkedList<>();
    private JLabel  colorSchemeLabel = new JLabel("Color Scheme"),
                    defaultFontLabel = new JLabel("Default Font"),
                    columnCountLabel = new JLabel("Column Count"),
                    noteCountLabel = new JLabel("Note Count"),
                    rowCountLabel = new JLabel("Row Count");
    private JTextArea   colorSchemeInput = new JTextArea(),
                        defaultFontInput = new JTextArea(),
                        columnCountInput = new JTextArea(),
                        noteCountInput = new JTextArea(),
                        rowCountInput = new JTextArea();
    private JButton colorSchemeButton = new JButton("Enter"),
                    defaultFontButton = new JButton("Enter"),
                    columnCountButton = new JButton("Enter"),
                    noteCountButton = new JButton("Enter"),
                    rowCountButton = new JButton("Enter");
    private JPanel  colorSchemeSubPanel = new JPanel(),
                    defaultFontSubPanel = new JPanel(),
                    columnCountSubPanel = new JPanel(),
                    noteCountSubPanel = new JPanel(),
                    rowCountSubPanel = new JPanel();

    public SettingsPanel(MyFrame myFrame){
        super(myFrame);
        getSouthPanel().setLayout(new GridLayout(1, 6, 10, 10));
        String[] newButtonStrings = {"", "To Do Panel", "Board Panel", "Completed Panel", "Settings Panel", ""};
        for(int counter = 0; counter < 6; counter++){
            southButtons.add(new JButton(newButtonStrings[counter]));
            southButtons.get(counter).setPreferredSize(getMyFrame().getSmallDimension());
            getSouthPanel().add(southButtons.get(counter));
            if(counter != 0 && counter != 5){
                southButtons.get(counter).addActionListener(myFrame);
            } else {
                southButtons.get(counter).setEnabled(false);
                southButtons.get(counter).setVisible(false);
            }
        }
        getColorSchemeButton().addActionListener(myFrame);
        getDefaultFontButton().addActionListener(myFrame);
        getColumnCountButton().addActionListener(myFrame);
        getNoteCountButton().addActionListener(myFrame);
        getRowCountButton().addActionListener(myFrame);
        colorSchemeSubPanel.setLayout(new BorderLayout());
        colorSchemeSubPanel.add(colorSchemeLabel, BorderLayout.WEST);
        colorSchemeSubPanel.add(colorSchemeInput, BorderLayout.CENTER);
        colorSchemeSubPanel.add(colorSchemeButton, BorderLayout.EAST);
        defaultFontSubPanel.setLayout(new BorderLayout());
        defaultFontSubPanel.add(defaultFontLabel, BorderLayout.WEST);
        defaultFontSubPanel.add(defaultFontInput, BorderLayout.CENTER);
        defaultFontSubPanel.add(defaultFontButton, BorderLayout.EAST);
        columnCountSubPanel.setLayout(new BorderLayout());
        columnCountSubPanel.add(columnCountLabel, BorderLayout.WEST);
        columnCountSubPanel.add(columnCountInput, BorderLayout.CENTER);
        columnCountSubPanel.add(columnCountButton, BorderLayout.EAST);
        noteCountSubPanel.setLayout(new BorderLayout());
        noteCountSubPanel.add(noteCountLabel, BorderLayout.WEST);
        noteCountSubPanel.add(noteCountInput, BorderLayout.CENTER);
        noteCountSubPanel.add(noteCountButton, BorderLayout.EAST);
        rowCountSubPanel.setLayout(new BorderLayout());
        rowCountSubPanel.add(rowCountLabel, BorderLayout.WEST);
        rowCountSubPanel.add(rowCountInput, BorderLayout.CENTER);
        rowCountSubPanel.add(rowCountButton, BorderLayout.EAST);
        getCenterPanel().setLayout(new GridLayout(5, 1, 10, 10));
        JComponent[] allComponents = {colorSchemeSubPanel, defaultFontSubPanel, columnCountSubPanel, noteCountSubPanel, rowCountSubPanel};
        for(int counter = 0, size = allComponents.length; counter < size; counter++){

            getCenterPanel().add(allComponents[counter]);
        }
        getColorSchemeLabel().setVerticalAlignment(JLabel.NORTH);
        getDefaultFontLabel().setVerticalAlignment(JLabel.NORTH);
        getColumnCountLabel().setVerticalAlignment(JLabel.NORTH);
        getNoteCountLabel().setVerticalAlignment(JLabel.NORTH);
        getRowCountLabel().setVerticalAlignment(JLabel.NORTH);
        Dimension thisDimension = new Dimension(300, 200);
        getColorSchemeLabel().setPreferredSize(thisDimension);
        getDefaultFontLabel().setPreferredSize(thisDimension);
        getColumnCountLabel().setPreferredSize(thisDimension);
        getNoteCountLabel().setPreferredSize(thisDimension);
        getRowCountLabel().setPreferredSize(thisDimension);
        updatePaint();
        updateFonts();
    }
    
    public void updatePaint(){
        super.updatePaint();
        Color columnPanelsColor = getMyFrame().getPalette().getColumnPanelsColor();
        Color buttonColor = getMyFrame().getPalette().getSouthButtonColor();
        getColorSchemeSubPanel().setBackground(columnPanelsColor);
        getColorSchemeLabel().setBackground(columnPanelsColor);
        getColorSchemeInput().setBackground(columnPanelsColor);
        getColorSchemeButton().setBackground(columnPanelsColor);
        getDefaultFontSubPanel().setBackground(columnPanelsColor);
        getDefaultFontLabel().setBackground(columnPanelsColor);
        getDefaultFontInput().setBackground(columnPanelsColor);
        getDefaultFontButton().setBackground(columnPanelsColor);
        getColumnCountSubPanel().setBackground(columnPanelsColor);
        getColumnCountLabel().setBackground(columnPanelsColor);
        getColumnCountInput().setBackground(columnPanelsColor);
        getColumnCountButton().setBackground(columnPanelsColor);
        getNoteCountSubPanel().setBackground(columnPanelsColor);
        getNoteCountLabel().setBackground(columnPanelsColor);
        getNoteCountInput().setBackground(columnPanelsColor);
        getNoteCountButton().setBackground(columnPanelsColor);
        getRowCountSubPanel().setBackground(columnPanelsColor);
        getRowCountLabel().setBackground(columnPanelsColor);
        getRowCountInput().setBackground(columnPanelsColor);
        getRowCountButton().setBackground(columnPanelsColor);
        for(int counter = 0; counter < 6; counter++){
            southButtons.get(counter).setBackground(buttonColor);
        }
    }

    public void updateFonts(){
        Font labelsFont = getMyFrame().getPalette().getLabelsFont();
        Font textAreaFont = getMyFrame().getPalette().getTextAreaFont();
        Font buttonFont = getMyFrame().getPalette().getButtonFont();
        getColorSchemeLabel().setFont(labelsFont);
        getColorSchemeInput().setFont(textAreaFont);
        getColorSchemeButton().setFont(buttonFont);
        getDefaultFontLabel().setFont(labelsFont);
        getDefaultFontInput().setFont(textAreaFont);
        getDefaultFontButton().setFont(buttonFont);
        getColumnCountLabel().setFont(labelsFont);
        getColumnCountInput().setFont(textAreaFont);
        getColumnCountButton().setFont(buttonFont);
        getNoteCountLabel().setFont(labelsFont);
        getNoteCountInput().setFont(textAreaFont);
        getNoteCountButton().setFont(buttonFont);
        getRowCountLabel().setFont(labelsFont);
        getRowCountInput().setFont(textAreaFont);
        getRowCountButton().setFont(buttonFont);
        for(int counter = 0; counter < 6; counter++){
            southButtons.get(counter).setFont(buttonFont);
        }
    }

    public void updateBorders(){

    }

    public LinkedList<JButton> getSouthButtons() {
        return southButtons;
    }

    public void setSouthButtons(LinkedList<JButton> southButtons) {
        this.southButtons = southButtons;
    }

    public JLabel getColorSchemeLabel() {
        return colorSchemeLabel;
    }

    public void setColorSchemeLabel(JLabel colorSchemeLabel) {
        this.colorSchemeLabel = colorSchemeLabel;
    }
    
    public JLabel getDefaultFontLabel() {
        return defaultFontLabel;
    }

    public void setDefaultFontLabel(JLabel defaultFontLabel) {
        this.defaultFontLabel = defaultFontLabel;
    }

    public JLabel getColumnCountLabel() {
        return columnCountLabel;
    }

    public void setColumnCountLabel(JLabel columnCountLabel) {
        this.columnCountLabel = columnCountLabel;
    }

    public JLabel getNoteCountLabel() {
        return noteCountLabel;
    }

    public void setNoteCountLabel(JLabel noteCountLabel) {
        this.noteCountLabel = noteCountLabel;
    }

    public JLabel getRowCountLabel() {
        return rowCountLabel;
    }

    public void setRowCountLabel(JLabel rowCountLabel) {
        this.rowCountLabel = rowCountLabel;
    }
    
    public JTextArea getColorSchemeInput() {
        return colorSchemeInput;
    }

    public void setColorSchemeInput(JTextArea colorSchemeInput) {
        this.colorSchemeInput = colorSchemeInput;
    }
    
    public JTextArea getDefaultFontInput() {
        return defaultFontInput;
    }

    public void setDefaultFontInput(JTextArea defaultFontInput) {
        this.defaultFontInput = defaultFontInput;
    }

    public JTextArea getColumnCountInput() {
        return columnCountInput;
    }

    public void setColumnCountInput(JTextArea columnCountInput) {
        this.columnCountInput = columnCountInput;
    }

    public JTextArea getNoteCountInput() {
        return noteCountInput;
    }

    public void setNoteCountInput(JTextArea noteCountInput) {
        this.noteCountInput = noteCountInput;
    }
    
    public JTextArea getRowCountInput() {
        return rowCountInput;
    }

    public void setRowCountInput(JTextArea rowCountInput) {
        this.rowCountInput = rowCountInput;
    }

    public JButton getColorSchemeButton() {
        return colorSchemeButton;
    }

    public void setColorSchemeButton(JButton colorSchemeButton) {
        this.colorSchemeButton = colorSchemeButton;
    }

    public JButton getDefaultFontButton() {
        return defaultFontButton;
    }

    public void setDefaultFontButton(JButton defaultFontButton) {
        this.defaultFontButton = defaultFontButton;
    }

    public JButton getColumnCountButton() {
        return columnCountButton;
    }

    public void setColumnCountButton(JButton columnCountButton) {
        this.columnCountButton = columnCountButton;
    }

    public JButton getNoteCountButton() {
        return noteCountButton;
    }

    public void setNoteCountButton(JButton noteCountButton) {
        this.noteCountButton = noteCountButton;
    }

    public JButton getRowCountButton() {
        return rowCountButton;
    }

    public void setRowCountButton(JButton rowCountButton) {
        this.rowCountButton = rowCountButton;
    }

    public JPanel getColorSchemeSubPanel() {
        return colorSchemeSubPanel;
    }

    public void setColorSchemeSubPanel(JPanel colorSchemeSubPanel) {
        this.colorSchemeSubPanel = colorSchemeSubPanel;
    }


    public JPanel getDefaultFontSubPanel() {
        return defaultFontSubPanel;
    }

    public void setDefaultFontSubPanel(JPanel defaultFontSubPanel) {
        this.defaultFontSubPanel = defaultFontSubPanel;
    }

    public JPanel getColumnCountSubPanel() {
        return columnCountSubPanel;
    }

    public void setColumnCountSubPanel(JPanel columnCountSubPanel) {
        this.columnCountSubPanel = columnCountSubPanel;
    }

    public JPanel getNoteCountSubPanel() {
        return noteCountSubPanel;
    }

    public void setNoteCountSubPanel(JPanel noteCountSubPanel) {
        this.noteCountSubPanel = noteCountSubPanel;
    }

    public JPanel getRowCountSubPanel() {
        return rowCountSubPanel;
    }

    public void setRowCountSubPanel(JPanel rowCountSubPanel) {
        this.rowCountSubPanel = rowCountSubPanel;
    }
}