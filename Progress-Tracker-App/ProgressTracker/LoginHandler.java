/*
 * Written by:          Thomas Williams
 * Last Updated:        08/18/2022, at 11:24AM(PT)
 * Version:             1.0
 * Coding Module ID(s): 
 */

package ProgressTracker;

import java.io.*;
import java.util.*;

public class LoginHandler {

    private String loginFileName;

    public LoginHandler(String loginFileName) {
        setLoginFileName(loginFileName);
        try {
            File theFile = new File("LOGIN.txt");
            if (theFile.createNewFile()){
                System.out.println("The file is created successfully!");
            }
            else{
                System.out.println("The file already exists.");
            }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
    }

    public boolean takeRequest(String inputUsername, String inputPassword) throws IOException{
        boolean output = false;
        boolean shouldAdd = true;
        String cipheredPassword = "", currentLine, currentLineUsername, currentLinePassword;
        int cipherValue = 3;
        File loginsFile = new File(getLoginFileName());
        Scanner loginsScanner = new Scanner(loginsFile);
        for(int counter = 0; counter < inputPassword.length(); counter++){
            cipheredPassword += ((char) inputPassword.codePointAt(counter) + cipherValue);
        }
        while(loginsScanner.hasNextLine()){
            currentLine = loginsScanner.nextLine();
            currentLineUsername = currentLine.split(":")[0];
            currentLinePassword = currentLine.split(":")[1];
            if(inputUsername.equals(currentLineUsername)){
                if(cipheredPassword.equals(currentLinePassword)){
                    output = true;
                    shouldAdd = false;
                } else {
                    shouldAdd = false;
                }
            }
        }
        if(shouldAdd){
            FileWriter fileWriter = new FileWriter(getLoginFileName(), true);
            fileWriter.write(inputUsername + ":" + cipheredPassword + "\n");
            fileWriter.close();
            output = true;
        }
        loginsScanner.close();
        return output;
    }

    public String getLoginFileName() {
        return loginFileName;
    }

    public void setLoginFileName(String loginFileName) {
        this.loginFileName = loginFileName;
    }
}