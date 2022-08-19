/*
 * Written by:          Thomas Williams
 * Last Updated:        08/18/2022, at 11:34AM(PT)
 * Version:             1.0
 * Coding Module ID(s): 
 */

package ProgressTracker;

import java.io.*;
import java.util.*;

public class Records {

    private LinkedList<LinkedList<Task>>    records = new LinkedList<LinkedList<Task>>();
    private String  seperatingString = "~",
                    replacementString = "`";
    private int columnCount;

    Records(int columnCount){
        this.columnCount = columnCount;
        for(int counter = 0; counter < columnCount; counter++){
            records.addFirst(new LinkedList<Task>());
        }
    }
    
    public LinkedList<Task> retrieveTaskList(int outterIndex){
        if(outterIndex < records.size()){
            return records.get(outterIndex);
        }
        return null;
    }

    public Task retrieveTask(int outterIndex, int innerIndex){
        LinkedList<Task> linkedList = retrieveTaskList(outterIndex);
        if(innerIndex < linkedList.size()){
            return linkedList.get(innerIndex);
        }
        return null;
    }

    public void addLastTask(Task task, int outterIndex){
        LinkedList<Task> linkedList = retrieveTaskList(outterIndex);
        linkedList.addLast(task);
    }

    public void removeTask(int outterIndex, int innerIndex){
        LinkedList<Task> linkedList = retrieveTaskList(outterIndex);
        if(innerIndex < linkedList.size()){
            linkedList.remove(innerIndex);
        }
    }

    public void moveLastTask(int outterIndex, int innerIndex, int newOutterIndex){
        Task task = retrieveTask(outterIndex, innerIndex);
        removeTask(outterIndex, innerIndex);
        addLastTask(task, newOutterIndex);
    }

    public void moveBackTask(int outterIndex, int innerIndex){
        moveLastTask(outterIndex, innerIndex, outterIndex - 1);
    }

    public void moveForwardTask(int outterIndex, int innerIndex){
        moveLastTask(outterIndex, innerIndex, outterIndex + 1);
    }

    public void editTask(int outterIndex, int innerIndex, String[] values){
        retrieveTask(outterIndex, innerIndex).setTitle(values[0]);
        retrieveTask(outterIndex, innerIndex).setContents(values[1]);
        retrieveTask(outterIndex, innerIndex).setUser(values[2]);
    }

    public String allDataToString(){
        String output = "";
        for(int counterA = 0; counterA < columnCount; counterA++){
            for(int counterB = 0; counterB < records.get(counterA).size(); counterB++){
                output += counterA + seperatingString;
                output += replaceNewLines(retrieveTask(counterA, counterB).getTitle() + seperatingString);
                output += replaceNewLines(retrieveTask(counterA, counterB).getContents() + seperatingString);
                output += replaceNewLines(retrieveTask(counterA, counterB).getUser() + seperatingString);
                output += "\n";
            }
        }
        return output;
    }

    public void saveToFile(String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, false);
        fileWriter.write(allDataToString());
        fileWriter.close();
    }

    public void loadFromFile(String fileName){
        try{
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                String [] dataItems = data.split("~");
                records.get(Integer.parseInt(dataItems[0])).addLast(new Task(unreplaceNewLines(dataItems[1]), unreplaceNewLines(dataItems[2]), unreplaceNewLines(dataItems[3])));
            }
            scanner.close();
        } catch (IOException exception){
            System.out.println("An error occured, unable to read from file.");
            exception.printStackTrace();
        }
    }

    public String replaceNewLines(String input){
        return input.replaceAll("\n", "`");
    }

    public String unreplaceNewLines(String input){
        return input.replaceAll("`", "\n");
    }

    public LinkedList<LinkedList<Task>> getRecords() {
        return records;
    }

    public void setRecords(LinkedList<LinkedList<Task>> records) {
        this.records = records;
    }

    public String getSeperatingString() {
        return seperatingString;
    }

    public void setSeperatingString(String seperatingString) {
        this.seperatingString = seperatingString;
    }

    public String getReplacementString() {
        return replacementString;
    }

    public void setReplacementString(String replacementString) {
        this.replacementString = replacementString;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }
}