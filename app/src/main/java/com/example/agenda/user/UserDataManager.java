package com.example.agenda.user;

import android.service.autofill.UserData;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UserDataManager {

//    path: ".com/example/agenda/data/userdata.csv"

    public static ArrayList<User> readUserData(String path) {
        File userFile = new File(path);
        ArrayList<User> ret = new ArrayList<>();
        if (userFile.exists()) {
            try {
                Scanner scanner = new Scanner(userFile);
                int lineCount = 0;
                while (scanner.hasNextLine()) {
                    String curr_line = scanner.nextLine().trim();
                    String[] attributes = curr_line.split(",");
                    if (attributes.length == 4) {
                        String email = attributes[0];
                        String username = attributes[1];
                        String password = attributes[2];
                        String userId = attributes[3];

                        User curr_user = new User(email, username, password, userId);
                        ret.add(curr_user);
                    } else {
                        System.out.println("Invalid line: " + lineCount);
                    }
                    lineCount++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return ret;
        } else {
            System.out.println("Path does not exist.");
            return null;
        }
    }

}
