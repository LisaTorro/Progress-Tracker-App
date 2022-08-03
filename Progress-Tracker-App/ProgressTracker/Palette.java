// Reviewed on 08/03/2022 at 11:34AM

package ProgressTracker;

import java.awt.*;
import java.util.*;

public class Palette {
/*====================================================================================================================================*/
    private Color mainPanelColor;
    private LinkedList<Color> layoutPanelsColors = new LinkedList<>();
    private LinkedList<Color> columnPanelsColors = new LinkedList<>();
    private LinkedList<Color> rowPanelsColors = new LinkedList<>();
    private LinkedList<Color> westButtonColors = new LinkedList<>();
    private LinkedList<Color> southButtonColors = new LinkedList<>();
    private LinkedList<LinkedList<Color>> notePanelsColors = new LinkedList<>();
/*====================================================================================================================================*/
    public Palette(){
        newColors();
    }

    public void oldColors(){
        layoutPanelsColors = new LinkedList<>();
        columnPanelsColors = new LinkedList<>();
        rowPanelsColors = new LinkedList<>();
        notePanelsColors = new LinkedList<>();
        int colorValue;
        mainPanelColor = Color.BLACK;
        colorValue = 200;
        for(int counter = 0; counter < 5; counter++){
            layoutPanelsColors.add(new Color(colorValue, colorValue, colorValue));
            colorValue -= 20;
        }
        colorValue = 40;
        for(int counter = 0; counter < 4; counter++){
            columnPanelsColors.add(new Color(colorValue, colorValue, colorValue));
            colorValue += 20;
        }
        colorValue = 255;
        for(int counter = 0; counter < 16; counter++){
            rowPanelsColors.add(new Color(colorValue, colorValue, colorValue));
            colorValue -= 5;
        }
        colorValue = 255;
        for(int counter = 0; counter < 4; counter++){
            notePanelsColors.add(new LinkedList<Color>());
        }
        for(int i = 0; i < 4; i++){
            notePanelsColors.get(0).add(new Color(colorValue, colorValue, colorValue));
            notePanelsColors.get(1).add(new Color(colorValue,0,0));
            notePanelsColors.get(2).add(new Color(0, colorValue,0));
            notePanelsColors.get(3).add(new Color(0,0, colorValue));
            colorValue -= 20;
        }
    }

    public void newColors(){
        Color blackCoral = new Color(73, 88, 103);
        Color blueYonder = new Color(87, 115, 153);
        Color beauBlue = new Color(189, 213, 234);
        Color ghostWhite = new Color(247, 247, 255);
        Color orangeRedCrayola = new Color(254, 95, 85);
        mainPanelColor = blackCoral;
        layoutPanelsColors = new LinkedList<>();
        for(int counter = 0; counter < 5; counter++){
            layoutPanelsColors.add(blueYonder);
        }
        columnPanelsColors = new LinkedList<>();
        for(int counter = 0; counter < 4; counter++){
            columnPanelsColors.add(beauBlue);
        }
        rowPanelsColors = new LinkedList<>();
        for(int counter = 0; counter < 16; counter++){
            rowPanelsColors.add(ghostWhite);
        }
        westButtonColors = new LinkedList<>();
        for(int counter = 0; counter < 3; counter++){
            westButtonColors.add(orangeRedCrayola);
        }
        southButtonColors = new LinkedList<>();
        for(int counter = 0; counter < 4; counter++){
            southButtonColors.add(orangeRedCrayola);
        }
        notePanelsColors = new LinkedList<>();
        for(int counterA = 0; counterA < 4; counterA++){
            notePanelsColors.add(new LinkedList<>());
            for(int counterB = 0; counterB < 4; counterB++){
                notePanelsColors.get(counterA).add(ghostWhite);
            }
        }
    }
    /*------------------------------------------------------------------------------*/
    public Color getMainPanelColor() {
        return mainPanelColor;
    }

    public void setMainPanelColor(Color mainPanelColor) {
        this.mainPanelColor = mainPanelColor;
    }
    
    public LinkedList<Color> getLayoutPanelsColors() {
        return layoutPanelsColors;
    }

    public void setLayoutPanelsColors(LinkedList<Color> layoutPanelsColors) {
        this.layoutPanelsColors = layoutPanelsColors;
    }
    
    public LinkedList<Color> getColumnPanelsColors() {
        return columnPanelsColors;
    }

    public void setColumnPanelsColors(LinkedList<Color> columnPanelsColors) {
        this.columnPanelsColors = columnPanelsColors;
    }
    
    public LinkedList<Color> getRowPanelsColors() {
        return rowPanelsColors;
    }

    public void setRowPanelsColors(LinkedList<Color> rowPanelsColors) {
        this.rowPanelsColors = rowPanelsColors;
    }

    public LinkedList<Color> getWestButtonColors() {
        return westButtonColors;
    }

    public void setWestButtonColors(LinkedList<Color> westButtonColors) {
        this.westButtonColors = westButtonColors;
    }
    
    public LinkedList<Color> getSouthButtonColors() {
        return southButtonColors;
    }

    public void setSouthButtonColors(LinkedList<Color> southButtonColors) {
        this.southButtonColors = southButtonColors;
    }
    
    public LinkedList<LinkedList<Color>> getNotePanelsColors() {
        return notePanelsColors;
    }

    public void setNotePanelsColors(LinkedList<LinkedList<Color>> notePanelsColors) {
        this.notePanelsColors = notePanelsColors;
    }
    /*------------------------------------------------------------------------------*/
    public Color getLayoutPanelsColors(int index) {
        return layoutPanelsColors.get(index);
    }
    
    public Color getColumnPanelsColors(int index) {
        return columnPanelsColors.get(index);
    }
    
    public Color  getRowPanelsColors(int index) {
        return rowPanelsColors.get(index);
    }

    public Color getWestButtonColors(int index) {
        return westButtonColors.get(index);
    }

    public Color getSouthButtonColors(int index) {
        return southButtonColors.get(index);
    }
    
    public Color getNotePanelsColors(int indexA, int indexB) {
        return notePanelsColors.get(indexA).get(indexB);
    }
}