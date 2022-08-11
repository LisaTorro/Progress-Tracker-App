// Reviewed on 

package ProgressTracker.Panels;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import ProgressTracker.*;

public class TaskViewPanel extends FivePanel{

    LinkedList<JButton> southButtons = new LinkedList<>();
    LinkedList<JPanel> buffers = new LinkedList<>();
    Dimension panelDimension = new Dimension(100, 100);
    Palette palette = new Palette();
    Records records;

    // SCREEN DISPLAY:
    JTextArea title = new JTextArea();
    JTextArea contents = new JTextArea();
    JTextArea user = new JTextArea();

    public TaskViewPanel(MyFrame myFrame, Records records, int rowCount){
        super(myFrame);
        this.records = records;
        /*
         * This is not the format I should use.
         * What I probably should do is use "new BorderLayout()".
         * Then I would do something like:
         * add(title, BorderLayout.NORTH);
         * add(user, BorderLayout.CENTER);
         * add(contents, BorderLayout.SOUTH);
         * Dimension smallDimension = new Dimension(50, 50);
         * title.setPreferedSize(smallDimension);
         * user.setPreferedSize(smallDimension);
         */
        getSouthPanel().setLayout(new GridLayout(1, 4, 10, 10));
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
        getNorthPanel().setBackground(Color.YELLOW);

        getCenterPanel().setLayout(new BorderLayout());
        Dimension smallLines = new DimensionUIResource(500, 50);
        title.setPreferredSize(smallLines);
        user.setPreferredSize(smallLines);
        getCenterPanel().add(title, BorderLayout.NORTH);
        getCenterPanel().add(user, BorderLayout.CENTER);
        getCenterPanel().add(contents, BorderLayout.SOUTH);

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

    public Dimension getPanelDimension() {
        return panelDimension;
    }

    public void setPanelDimension(Dimension panelDimension) {
        this.panelDimension = panelDimension;
    }
    
    public Palette getPalette() {
        return palette;
    }

    public void setPalette(Palette palette) {
        this.palette = palette;
    }

    public Records getRecords() {
        return records;
    }

    public void setRecords(Records records) {
        this.records = records;
    }

    public void modify(String[] values) {

        title.setText(values[0]);
        contents.setText(values[1]);
        user.setText(values[2]);

    }
}