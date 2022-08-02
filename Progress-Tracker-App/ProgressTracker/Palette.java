// Reviewed on 08/02/2022 at 9:26 AM

package ProgressTracker;

import java.awt.*;
import java.util.*;

public class Palette {
/*====================================================================================================================================*/
    private Color mainPanelColor;
    private LinkedList<Color> layoutPanelsColors = new LinkedList<>();
    private LinkedList<Color> columnPanelsColors = new LinkedList<>();
    private LinkedList<Color> rowPanelsColors = new LinkedList<>();
    private LinkedList<LinkedList<Color>> notePanelsColors = new LinkedList<>();
/*====================================================================================================================================*/
    public Palette(){

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
    
    public Color getNotePanelsColors(int indexA, int indexB) {
        return notePanelsColors.get(indexA).get(indexB);
    }
}