// Reviewed on 07/22/2022 -TW

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Records {

    LinkedList<LinkedList<Task>> records = new LinkedList<LinkedList<Task>>();

    File file;
    FileWriter fileWriter;

    String output = "", seperatingString = "~";
    String[] dataItems = new String[4];

    Records(){
        for(int i = 0; i < 4; i++){
            records.addFirst(new LinkedList<Task>());
        }
    }
    
    public LinkedList<Task> retrieveTaskList(int outterIndex){
        if(outterIndex < records.size()){
            return records.get(outterIndex);
        }
        // System.out.println("Linked List does not contain that many Linked Lists!");
        return null;
    }

    public Task retrieveTask(int outterIndex, int innerIndex){
        LinkedList<Task> linkedList = retrieveTaskList(outterIndex);
        if(innerIndex < linkedList.size()){
            return linkedList.get(innerIndex);
        }
        // System.out.println("Linked List does not contain that many Tasks! (retrieve)");
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
        System.out.println("Linked List does not contain that many Tasks! (remove)");
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
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < records.get(i).size(); j++){
                output += i + seperatingString;
                output += retrieveTask(i, j).getTitle() + seperatingString;
                output += retrieveTask(i, j).getContents() + seperatingString;
                output += retrieveTask(i, j).getUser() + seperatingString + "\n";
            }
        }
        return output;
    }

    public void saveToFile(String fileName) throws IOException {
        file = new File(fileName);
        fileWriter = new FileWriter(fileName);
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