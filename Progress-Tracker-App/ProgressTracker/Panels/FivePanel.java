// Reviewed on 08/03/2022 at 12:28PM
// For future improvements I could get rid of each named JPanel, but I could rework the functions to still function as if they were named.

package ProgressTracker.Panels;

import java.awt.*;
import javax.swing.JPanel;
import ProgressTracker.MyFrame;
import ProgressTracker.Palette;

public class FivePanel extends JPanel{
/*====================================================================================================================================*/
    private MyFrame myFrame;
    private JPanel centerPanel = new JPanel();
    private JPanel northPanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private JPanel westPanel = new JPanel();
    private Dimension panelDimension = new Dimension(100, 100);
    private Palette palette = new Palette();
/*====================================================================================================================================*/
    public FivePanel(MyFrame myFrame){
        this.myFrame = myFrame;
        setLayout(new BorderLayout());
        setBackground(palette.getMainPanelColor());
        JPanel[] allPanels = {northPanel, westPanel, centerPanel, eastPanel, southPanel};
        Color[] allColors = {palette.getLayoutPanelsColors(0), palette.getLayoutPanelsColors(1), palette.getLayoutPanelsColors(2), palette.getLayoutPanelsColors(3), palette.getLayoutPanelsColors(4)};
        String[] allBorderLayouts = {BorderLayout.NORTH, BorderLayout.WEST, BorderLayout.CENTER, BorderLayout.EAST, BorderLayout.SOUTH};
        for(int counter = 0; counter < 5; counter++){
            allPanels[counter].setPreferredSize(panelDimension);
            allPanels[counter].setBackground(allColors[counter]);
            add(allPanels[counter], allBorderLayouts[counter]);
        }
    }
    public MyFrame getMyFrame() {
        return myFrame;
    }

    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }
    
    public JPanel getCenterPanel() {
        return centerPanel;
    }
    
    public void setCenterPanel(JPanel centerPanel) {
        this.centerPanel = centerPanel;
    }
    
    public JPanel getNorthPanel() {
        return northPanel;
    }

    public void setNorthPanel(JPanel northPanel) {
        this.northPanel = northPanel;
    }
    
    public JPanel getEastPanel() {
        return eastPanel;
    }

    public void setEastPanel(JPanel eastPanel) {
        this.eastPanel = eastPanel;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }

    public void setSouthPanel(JPanel southPanel) {
        this.southPanel = southPanel;
    }

    public JPanel getWestPanel() {
        return westPanel;
    }

    public void setWestPanel(JPanel westPanel) {
        this.westPanel = westPanel;
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
}