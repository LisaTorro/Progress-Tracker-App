// Reviewed on 08/03/2022 at 1:00PM

package ProgressTracker.Panels;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import ProgressTracker.*;

public class ToDoPanel extends FivePanel{

    private LinkedList<RowPanel> rowPanels = new LinkedList<>();
    private LinkedList<JButton> southButtons = new LinkedList<>();
    private LinkedList<JPanel> buffers = new LinkedList<>();
    private Records records;
    private int rowCount;
    private Palette palette = new Palette();
    private Dimension panelDimension = new Dimension(100, 100);

    public ToDoPanel(MyFrame myFrame, Records records, int rowCount){
        super(myFrame);
        this.records = records;
        this.rowCount = rowCount;
        getCenterPanel().setLayout(new GridLayout(16, 1, 10, 10));
        for(int counter = 0; counter < rowCount; counter++){
            rowPanels.add(new RowPanel(myFrame, records, counter));
            rowPanels.get(counter).setBackground(palette.getRowPanelsColors().get(counter));
            getCenterPanel().add(rowPanels.get(counter));
        }
        getSouthPanel().setLayout(new GridLayout(1, 6, 10, 10));
        JPanel firstPanel = new JPanel();
        JPanel lastPanel = new JPanel();
        firstPanel.setBackground(palette.getLayoutPanelsColors(0));
        lastPanel.setBackground(palette.getLayoutPanelsColors(0));
        buffers.add(firstPanel);
        buffers.add(lastPanel);
        getSouthPanel().add(buffers.get(0));
        String[] newButtonStrings = {"To Do Panel", "Board Panel", "Completed Panel", "Settings Panel"};
        Color[] newButtonColors = {palette.getSouthButtonColors(0), palette.getSouthButtonColors(1), palette.getSouthButtonColors(2), palette.getSouthButtonColors(3)};
        for(int counter = 0; counter < 4; counter++){
            southButtons.add(new JButton(newButtonStrings[counter]));
            southButtons.get(counter).addActionListener(myFrame);
            southButtons.get(counter).setBackground(newButtonColors[counter]);
            southButtons.get(counter).setPreferredSize(panelDimension);
            getSouthPanel().add(southButtons.get(counter));
        }
        getSouthPanel().add(buffers.get(1));

        getNorthPanel().setBackground(Color.RED);
    }

    public LinkedList<RowPanel> getRowPanels() {
        return rowPanels;
    }

    public void setRowPanels(LinkedList<RowPanel> rowPanels) {
        this.rowPanels = rowPanels;
    }

    public LinkedList<JButton> getSouthButtons() {
        return southButtons;
    }

    public void setSouthButtons(LinkedList<JButton> southButtons) {
        this.southButtons = southButtons;
    }
    
    public LinkedList<JPanel> getBuffers() {
        return buffers;
    }

    public void setBuffers(LinkedList<JPanel> buffers) {
        this.buffers = buffers;
    }

    public Records getRecords() {
        return records;
    }

    public void setRecords(Records records) {
        this.records = records;
    }
    
    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public Palette getPalette() {
        return palette;
    }

    public void setPalette(Palette palette) {
        this.palette = palette;
    }

    public Dimension getPanelDimension() {
        return panelDimension;
    }

    public void setPanelDimension(Dimension panelDimension) {
        this.panelDimension = panelDimension;
    }
}