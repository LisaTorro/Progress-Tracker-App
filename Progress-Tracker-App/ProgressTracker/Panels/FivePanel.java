// Reviewed on 08/12/2022 at 10:26AM

package ProgressTracker.Panels;

import java.awt.*;
import javax.swing.*;
import ProgressTracker.*;

public class FivePanel extends JPanel{

    private MyFrame myFrame;
    private JPanel[] allPanels = new JPanel[5];

    public FivePanel(MyFrame myFrame){
        this.myFrame = myFrame;
        setLayout(new BorderLayout());
        String[] allBorderLayouts = {BorderLayout.NORTH, BorderLayout.WEST, BorderLayout.CENTER, BorderLayout.EAST, BorderLayout.SOUTH};
        for(int counter = 0; counter < 5; counter++){
            allPanels[counter] = new JPanel();
            allPanels[counter].setPreferredSize(getMyFrame().getSmallDimension());
            add(allPanels[counter], allBorderLayouts[counter]);
        }
    }

    public void updatePaint(){
        Color mainPanelColor = getMyFrame().getPalette().getMainPanelColor();
        Color layoutPanelColor = getMyFrame().getPalette().getLayoutPanelsColor();
        setBackground(mainPanelColor);
        for(int counter = 0; counter < 5; counter++){
            allPanels[counter].setBackground(layoutPanelColor);
        }
    }

    public MyFrame getMyFrame() {
        return myFrame;
    }

    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }
    
    public JPanel getCenterPanel() {
        return allPanels[2];
    }
    
    public void setCenterPanel(JPanel centerPanel) {
        this.allPanels[2] = centerPanel;
    }
    
    public JPanel getNorthPanel() {
        return allPanels[0];
    }

    public void setNorthPanel(JPanel northPanel) {
        this.allPanels[0] = northPanel;
    }
    
    public JPanel getEastPanel() {
        return allPanels[3];
    }

    public void setEastPanel(JPanel eastPanel) {
        this.allPanels[3] = eastPanel;
    }

    public JPanel getSouthPanel() {
        return allPanels[4];
    }

    public void setSouthPanel(JPanel southPanel) {
        this.allPanels[4] = southPanel;
    }

    public JPanel getWestPanel() {
        return allPanels[1];
    }

    public void setWestPanel(JPanel westPanel) {
        this.allPanels[1] = westPanel;
    }

    public JPanel getPanel(int inputInt){
        return allPanels[inputInt];
    }

    public void setPanel(JPanel inputJPanel, int inputInt){
        this.allPanels[inputInt] = inputJPanel;
    }
}