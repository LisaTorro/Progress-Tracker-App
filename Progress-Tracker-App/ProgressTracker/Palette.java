/*
 * Written by:          Thomas Williams
 * Last Updated:        08/18/2022, at 11:30AM(PT)
 * Version:             1.0
 * Coding Module ID(s): 9.2, 9.3, and many others more passively.
 */

package ProgressTracker;

import java.awt.*;

public class Palette {

    private Color   mainPanelColor,
                    layoutPanelsColor,
                    columnPanelsColor,
                    rowPanelsColor,
                    westButtonColor,
                    southButtonColor,
                    notePanelsColor;
    private Font    buttonFont,
                    labelsFont,
                    textAreaFont;

    public Palette(){
        setColorScheme(2);
        setFontScheme(3);
    }

    public void setColorScheme(int input){
        switch(input){
            case 1:
                setColorSchemeOne();
                break;
            case 2:
                setColorSchemeTwo();
                break;
            case 3:
                setColorSchemeThree();
                break;
            case 4:
                setColorSchemeFour();
                break;
            case 5:
                setColorSchemeFive();
                break;
        }
        
    }

    public void setColorSchemeOne(){
        Color lavenderGray = Color.decode("#C9CAD9");
        Color lavenderBlue = Color.decode("#D1D2F9");
        Color babyBlueEyes = Color.decode("#A3BCF9");
        Color blueGray = Color.decode("#7796CB");
        Color darkBlueGray = Color.decode("#576490");
        setMainPanelColor(darkBlueGray);
        setLayoutPanelsColor(blueGray);
        setColumnPanelsColor(babyBlueEyes);
        setRowPanelsColor(babyBlueEyes);
        setWestButtonColor(lavenderBlue);
        setSouthButtonColor(lavenderBlue);
        setNotePanelsColor(lavenderGray);
    }

    public void setColorSchemeTwo(){
        Color blackCoral = Color.decode("#495867");
        Color blueYonder = Color.decode("#577399");
        Color beauBlue = Color.decode("#BDD5EA");
        Color ghostWhite = Color.decode("#F7F7FF");
        Color orangeRedCrayola = Color.decode("#FE5F55");
        setMainPanelColor(blackCoral);
        setLayoutPanelsColor(blueYonder);
        setColumnPanelsColor(beauBlue);
        setRowPanelsColor(beauBlue);
        setWestButtonColor(orangeRedCrayola);
        setSouthButtonColor(orangeRedCrayola);
        setNotePanelsColor(ghostWhite);
    }

    public void setColorSchemeThree(){
        Color goldCrayola = Color.decode("#DCC48E");
        Color beige = Color.decode("#EAEFD3");
        Color laurelGreen = Color.decode("#B3C0A4");
        Color independence = Color.decode("#505168");
        Color darkPurple = Color.decode("#27233A");
        setMainPanelColor(darkPurple);
        setLayoutPanelsColor(independence);
        setColumnPanelsColor(laurelGreen);
        setRowPanelsColor(laurelGreen);
        setWestButtonColor(goldCrayola);
        setSouthButtonColor(goldCrayola);
        setNotePanelsColor(beige);
    }

    public void setColorSchemeFour(){
        Color oldLavender = Color.decode("#7C6C77");
        Color grullo = Color.decode("#AAA694");
        Color sage = Color.decode("#D1D0A3");
        Color paleSpringBud = Color.decode("#EBF8B8");
        Color yellowCrayola = Color.decode("#FFE787");
        setMainPanelColor(oldLavender);
        setLayoutPanelsColor(grullo);
        setColumnPanelsColor(sage);
        setRowPanelsColor(sage);
        setWestButtonColor(yellowCrayola);
        setSouthButtonColor(yellowCrayola);
        setNotePanelsColor(paleSpringBud);
    }

    public void setColorSchemeFive(){
        Color babyPink = Color.decode("#D3AB9E");
        Color silverPink = Color.decode("#EAC9C1");
        Color champagnePink = Color.decode("#EBD8D0");
        Color snow = Color.decode("#FFFBFF");
        Color white = Color.decode("#FEFEFF");
        setMainPanelColor(silverPink);
        setLayoutPanelsColor(babyPink);
        setColumnPanelsColor(champagnePink);
        setRowPanelsColor(champagnePink);
        setWestButtonColor(white);
        setSouthButtonColor(white);
        setNotePanelsColor(snow);
    }

    public void setFontScheme(int input){
        switch(input){
            case 1:
                setFontSchemeOne();
                break;
            case 2:
                setFontSchemeTwo();
                break;
            case 3:
                setFontSchemeThree();
                break;
            case 4:
                setFontSchemeFour();
        }
    }

    public void setFontSchemeOne(){
        Font defaultFont = new Font("Arial", Font.PLAIN , 32);
        setButtonFont(defaultFont);
        setLabelsFont(defaultFont);
        setTextAreaFont(defaultFont);
    }

    public void setFontSchemeTwo(){
        Font defaultFont = new Font("Times", Font.ITALIC , 28);
        setButtonFont(defaultFont);
        setLabelsFont(defaultFont);
        setTextAreaFont(defaultFont);
    }

    public void setFontSchemeThree(){
        Font defaultFont = new Font("Serif", Font.BOLD , 24);
        setButtonFont(defaultFont);
        setLabelsFont(defaultFont);
        setTextAreaFont(defaultFont);
    }

    public void setFontSchemeFour(){
        Font setLabelsFont = new Font("Serif", Font.PLAIN , 24);
        Font setButtonFont = new Font("Serif", Font.BOLD , 24);
        Font setTextAreaFont = new Font("Serif", Font.ITALIC , 24);
        setButtonFont(setButtonFont);
        setLabelsFont(setLabelsFont);
        setTextAreaFont(setTextAreaFont);
    }
    
    public Color getMainPanelColor() {
        return mainPanelColor;
    }

    public void setMainPanelColor(Color mainPanelColor) {
        this.mainPanelColor = mainPanelColor;
    }
    
    public Color getLayoutPanelsColor() {
        return layoutPanelsColor;
    }

    public void setLayoutPanelsColor(Color layoutPanelsColor) {
        this.layoutPanelsColor = layoutPanelsColor;
    }
    
    public Color getColumnPanelsColor() {
        return columnPanelsColor;
    }

    public void setColumnPanelsColor(Color columnPanelsColor) {
        this.columnPanelsColor = columnPanelsColor;
    }
    
    public Color getRowPanelsColor() {
        return rowPanelsColor;
    }

    public void setRowPanelsColor(Color rowPanelsColor) {
        this.rowPanelsColor = rowPanelsColor;
    }

    public Color getWestButtonColor() {
        return westButtonColor;
    }

    public void setWestButtonColor(Color westButtonColor) {
        this.westButtonColor = westButtonColor;
    }
    
    public Color getSouthButtonColor() {
        return southButtonColor;
    }

    public void setSouthButtonColor(Color southButtonColor) {
        this.southButtonColor = southButtonColor;
    }
    
    public Color getNotePanelsColor() {
        return notePanelsColor;
    }

    public void setNotePanelsColor(Color notePanelsColor) {
        this.notePanelsColor = notePanelsColor;
    }  

    public Font getButtonFont() {
        return buttonFont;
    }

    public void setButtonFont(Font buttonFont) {
        this.buttonFont = buttonFont;
    }

    public Font getLabelsFont() {
        return labelsFont;
    }

    public void setLabelsFont(Font labelsFont) {
        this.labelsFont = labelsFont;
    }

    public Font getTextAreaFont() {
        return textAreaFont;
    }

    public void setTextAreaFont(Font textAreaFont) {
        this.textAreaFont = textAreaFont;
    }
}