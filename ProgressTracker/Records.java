// Reviewed on 08/03/2022 at 12:39PM
// I could probably remove a few of the class variables and make things work different ways.
// There are also certainly more efficient ways for the functions to work.

package ProgressTracker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Records {

    private LinkedList<LinkedList<Task>> records = new LinkedList<LinkedList<Task>>();
    private File file;
    private FileWriter fileWriter;
    private String output = "";
    private String seperatingString = "~";
    private String[] dataItems = new String[4];
    private int columnCount;

    Records(int columnCount){
        this.columnCount = columnCount;
        for(int counter = 0; counter < columnCount; counter++){
            records.addFirst(new LinkedList<Task>());
        }
    }

    public LinkedList<LinkedList<Task>> getRecords() {
        return records;
    }

    public void setRecords(LinkedList<LinkedList<Task>> records) {
        this.records = records;
    }
    
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }


    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }
    
    public String getOutput() {
        return output;
    }


    public void setOutput(String output) {
        this.output = output;
    }

    public String getSeperatingString() {
        return seperatingString;
    }


    public void setSeperatingString(String seperatingString) {
        this.seperatingString = seperatingString;
    }
    
    public String[] getDataItems() {
        return dataItems;
    }


    public void setDataItems(String[] dataItems) {
        this.dataItems = dataItems;
    }

    public int getColumnCount() {
        return columnCount;
    }


    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }
    //********************************************************************************************************************************/
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
        output = "";
        for(int counterA = 0; counterA < columnCount; counterA++){
            for(int counterB = 0; counterB < records.get(counterA).size(); counterB++){
                output += counterA + seperatingString;
                output += retrieveTask(counterA, counterB).getTitle() + seperatingString;
                output += retrieveTask(counterA, counterB).getContents() + seperatingString;
                output += retrieveTask(counterA, counterB).getUser() + seperatingString + "\n";
            }
        }
        return output;
    }

    public void saveToFile(String fileName) throws IOException {
        file = new File(fileName);
        fileWriter = new FileWriter(fileName, false);
        fileWriter.write(allDataToString());
        fileWriter.close();
    }

    public void loadFromFile(String fileName){
        try{
            file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                dataItems = data.split("~");
                records.get(Integer.parseInt(dataItems[0])).addLast(new Task(dataItems[1], dataItems[2], dataItems[3]));
            }
            scanner.close();
        } catch (IOException exception){
            System.out.println("An error occured, unable to read from file.");
            exception.printStackTrace();
        }
    }
}