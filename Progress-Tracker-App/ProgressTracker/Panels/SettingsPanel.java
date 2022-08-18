/*
 * Written by:      Thomas Williams
 * Last Updated:    08/18/2022, at 1:57PM(PT)
 * Version:         1.0
 */

package ProgressTracker.Panels;

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
        getCenterPanel().setLayout(new GridLayout(5, 3, 10, 10));
        getCenterPanel().add(colorSchemeLabel);
        getCenterPanel().add(colorSchemeInput);
        getCenterPanel().add(colorSchemeButton);
        getCenterPanel().add(defaultFontLabel);
        getCenterPanel().add(defaultFontInput);
        getCenterPanel().add(defaultFontButton);
        getCenterPanel().add(columnCountLabel);
        getCenterPanel().add(columnCountInput);
        getCenterPanel().add(columnCountButton);
        getCenterPanel().add(noteCountLabel);
        getCenterPanel().add(noteCountInput);
        getCenterPanel().add(noteCountButton);
        getCenterPanel().add(rowCountLabel);
        getCenterPanel().add(rowCountInput);
        getCenterPanel().add(rowCountButton);
        updatePaint();
        updateFonts();
    }
    
    public void updatePaint(){
        super.updatePaint();
        Color columnPanelsColor = getMyFrame().getPalette().getColumnPanelsColor();
        Color buttonColor = getMyFrame().getPalette().getSouthButtonColor();
        getColorSchemeLabel().setBackground(columnPanelsColor);
        getColorSchemeInput().setBackground(columnPanelsColor);
        getColorSchemeButton().setBackground(columnPanelsColor);
        getDefaultFontLabel().setBackground(columnPanelsColor);
        getDefaultFontInput().setBackground(columnPanelsColor);
        getDefaultFontButton().setBackground(columnPanelsColor);
        getColumnCountLabel().setBackground(columnPanelsColor);
        getColumnCountInput().setBackground(columnPanelsColor);
        getColumnCountButton().setBackground(columnPanelsColor);
        getNoteCountLabel().setBackground(columnPanelsColor);
        getNoteCountInput().setBackground(columnPanelsColor);
        getNoteCountButton().setBackground(columnPanelsColor);
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
        getColumnCountButton().setFont(textAreaFont);
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
}