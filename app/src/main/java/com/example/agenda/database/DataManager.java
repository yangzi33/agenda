package com.example.agenda.database;

import android.os.Build;
import android.service.autofill.UserData;

import androidx.annotation.RequiresApi;

import com.example.agenda.user.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataManager {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static List<User> readUserData() {
        List<User> users = new ArrayList<>();
        Path pathToFile = Paths.get("com/example/agenda/data/userdata");
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                User curr_user = new User(attributes[0], attributes[1], attributes[2], attributes[3]);
                users.add(curr_user); //
                line = br.readLine(); } }
             catch (IOException ioe) { ioe.printStackTrace(); } return users;


//        String userPath = "userdata";
//        File userFile = new File(userPath);
//        ArrayList<User> ret = new ArrayList<>();
//        if (userFile.exists()) {
//            try {
//                Scanner scanner = new Scanner(userFile);
//                int lineCount = 0;
//                while (scanner.hasNextLine()) {
//                    String curr_line = scanner.nextLine().trim();
//                    String[] attributes = curr_line.split(",");
//                    if (attributes.length == 4) {
//                        String email = attributes[0];
//                        String username = attributes[1];
//                        String password = attributes[2];
//                        String userId = attributes[3];
//
//                        User curr_user = new User(email, username, password, userId);
//                        ret.add(curr_user);
//                    } else {
//                        System.out.println("Invalid line: " + lineCount);
//                    }
//                    lineCount++;
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            return ret;
//        } else {
//            System.out.println("Path does not exist.");
//            return ret;
//        }
    }

}
