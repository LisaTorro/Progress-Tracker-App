// Reviewed on 08/11/2022 at 12:01PM

package ProgressTracker.Panels;

import java.awt.*;
import javax.swing.JPanel;
import ProgressTracker.MyFrame;
import ProgressTracker.Palette;

public class FivePanel extends JPanel{
/*====================================================================================================================================*/
    private MyFrame myFrame;

    private JPanel[] allPanels = new JPanel[5];
    /* private JPanel centerPanel = new JPanel(); private JPanel northPanel = new JPanel(); private JPanel eastPanel = new JPanel(); private JPanel southPanel = new JPanel(); private JPanel westPanel = new JPanel(); */
    private Dimension panelDimension = new Dimension(100, 100);
    private Palette palette = new Palette();
/*====================================================================================================================================*/
    public FivePanel(MyFrame myFrame){
        this.myFrame = myFrame;
        setLayout(new BorderLayout());
        setBackground(palette.getMainPanelColor());
        String[] allBorderLayouts = {BorderLayout.NORTH, BorderLayout.WEST, BorderLayout.CENTER, BorderLayout.EAST, BorderLayout.SOUTH};
        Color[] allColors = {palette.getLayoutPanelsColors(0), palette.getLayoutPanelsColors(1), palette.getLayoutPanelsColors(2), palette.getLayoutPanelsColors(3), palette.getLayoutPanelsColors(4)};
        for(int counter = 0; counter < 5; counter++){
            allPanels[counter] = new JPanel();
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