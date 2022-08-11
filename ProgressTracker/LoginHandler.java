package ProgressTracker;

import java.io.*;
import java.util.*;

public class LoginHandler {

    String fileName;
    String currentUsername;
    String currentPassword;
    String allUserData;
    File file;
    FileWriter fileWriter;
    boolean hasChanged = false;
    String[] currentData = new String[2];
    LinkedList<String[]> users = new LinkedList<>();
    String output;
    String seperatingString = "~";

    public LoginHandler(String fileName){
        this.fileName = fileName;
        loadFromFile();
    }

    public void loadFromFile(){
        try{
            file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                currentData = data.split("~");
                users.add(currentData);
            }
            scanner.close();
        } catch (IOException exception){
            System.out.println("An error occured, unable to read from file.");
            exception.printStackTrace();
        }
    }

    public void saveToFile(String fileName) throws IOException {
        if(hasChanged){
            file = new File(fileName);
            fileWriter = new FileWriter(fileName, false);
            fileWriter.write(allDataToString());
            fileWriter.close();
        }
    }

    public String allDataToString(){
        output = "";
        int size = users.size();
        for(int counter = 0; counter < size; counter++){
            output += users.get(counter)[0];
            output += seperatingString;
            output += users.get(counter)[1];
            output += "\n";
        }
        return output;
    }
}