// Reviewed on 08/02/2022 at 9:24 AM

package ProgressTracker.Panels;

import java.awt.*;
import javax.swing.JPanel;
import ProgressTracker.MyFrame;
import ProgressTracker.Palette;

public class FivePanel extends JPanel{
/*====================================================================================================================================*/
    MyFrame myFrame;
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
        /*---------------------------------------------------------------------*/
        setLayout(new BorderLayout());
        /*---------------------------------------------------------------------*/
        centerPanel.setPreferredSize(panelDimension);
        northPanel.setPreferredSize(panelDimension);
        eastPanel.setPreferredSize(panelDimension);
        southPanel.setPreferredSize(panelDimension);
        westPanel.setPreferredSize(panelDimension);
        /*---------------------------------------------------------------------*/
        setBackground(palette.getMainPanelColor());
        centerPanel.setBackground(palette.getLayoutPanelsColors(2));
        northPanel.setBackground(palette.getLayoutPanelsColors(0));
        eastPanel.setBackground(palette.getLayoutPanelsColors(3));
        southPanel.setBackground(palette.getLayoutPanelsColors(4));
        westPanel.setBackground(palette.getLayoutPanelsColors(1));
        /*---------------------------------------------------------------------*/
        add(centerPanel, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);
        add(eastPanel, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);
        add(westPanel, BorderLayout.WEST);
    }
    /*+++++++++++++++++++++++++++++++++++++++++++++*/
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