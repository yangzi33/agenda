//package com.example.agenda.Main;
//
//import alert.AlertManager;
//import event.EventManager;
//import event.ReadWriteCSV;
//import features.*;
//import user.User;
//import user.UserManager;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
public class Calendar {
//
//    // =============== Constants ===============
//    private static final List<String> USER_OPTIONS = Arrays.asList(
//            "Logout", "Menu", "Settings", "Exit");
//    private static final List<String> MENU = Arrays.asList("Create", "View",
//            "Search", "Delete Event", "Leave");
//
//    // =============== Local Storage ===============
//    public static User loggedInUser = null;
//
//    private static ArrayList<User> allUsers = new ArrayList<>();
//
//    // =============== Manager Instances ===============
//    private static UserManager userManager = new UserManager();
//
//    // =============== main.User Methods ===============
//
//    /**
//     * Login or Register. If register, write to the stored user data.
//     *
//     * @param scanner - the scanner object to read from console input
//     */
//    private static void loginOrRegister(Scanner scanner) {
//        boolean success = false;
//
//        // Do not let user pass until they've successfully logged in or registered.
//        while (!success || loggedInUser == null) {
//            System.out.println("Please LogIn / Register / Exit");
//            String input = scanner.nextLine().trim();
//
//            if (input.equalsIgnoreCase("login")) {
//                // login
//                success = login(scanner);
//            } else if (input.equalsIgnoreCase("register")) {
//                // register and save new user list
//                success = register(scanner);
//                if (success) {
//                    if (!userManager.writeUserData(allUsers)) {
//                        System.out.println("Warning: Failed to write data. " +
//                                "This could cause data losses.");
//                    }
//                }
//            }else if(input.equalsIgnoreCase("exit")){
//                System.exit(1);
//            } else{
//                System.out.println("Invalid Input! Please input [login] / [register] / [Exit]");
//            }
//        }
//
//        System.out.println("Login Success! Welcome, " + loggedInUser.getUsername());
//    }
//
//    /**
//     * Prompt the user for username and password for login.
//     *
//     * @param scanner - the scanner object to read from console input
//     * @return - true if the login was successful, false otherwise.
//     */
//    private static boolean login(Scanner scanner) {
//        System.out.println("Please input User Name");
//        String userName = scanner.nextLine().trim();
//        System.out.println("Please input Password");
//        String password = scanner.nextLine().trim();
//
//        // There might be cases where two users have the same name but
//        // different uid. We have to check all of them.
//        boolean foundUser = false, loggedIn = false;
//        for (User currUser : allUsers) {
//            if (currUser.getUsername().equals(userName)) {
//                foundUser = true;
//                if (currUser.getPassword().equals(password)) {
//                    loggedInUser = currUser;
//                    loggedIn = true;
//                    ReadWriteFeature helper = new ReadWriteFeature();
//                    helper.readMemoData(loggedInUser.events);
//                    helper.readTagData(loggedInUser.events);
//                    ReadWriteCSV.readEventData();
//                }
//            }
//        }
//
//        if (!loggedIn) {
//            if (!foundUser) {
//                System.out.println(userName + " not found. Please try again.");
//            } else {
//                System.out.println("Invalid Password. Please try again.");
//            }
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * Prompt to register a new user. Check for commas in the user input since
//     * they will ruin the csv text file.
//     *
//     * @param scanner - the scanner object to read from console input
//     * @return - true if register success, false otherwise
//     */
//    private static boolean register(Scanner scanner) {
//        System.out.println("Please input Email");
//        String email = scanner.nextLine().trim();
//        if (email.contains(",")) {
//            System.out.println("Email cannot contain comma [,]!");
//            return false;
//        }
//
//        System.out.println("Please input User Name");
//        String userName = scanner.nextLine().trim();
//        if (userName.contains(",")) {
//            System.out.println("User Name cannot contain comma [,]!");
//            return false;
//        }
//
//        System.out.println("Please input Password");
//        String password = scanner.nextLine().trim();
//        if (password.contains(",")) {
//            System.out.println("Password cannot contain comma [,]!");
//            return false;
//        }
//
//        int uidNum = allUsers.size() + 1;
//        String uid = User.USER_UID_PRETEXT + uidNum;
//
//        loggedInUser = new User(email, userName, password, uid);
//        loggedInUser.events = new EventManager();
//        allUsers.add(loggedInUser);
//        return true;
//    }
//
//    /**
//     * Log out the current user
//     */
//    private static void logOut() {
//        ReadWriteFeature.writeMemotData(loggedInUser.events.memos.allMemos);
//        ReadWriteFeature.writeTagData(loggedInUser.events.tags.allTags);
//        ReadWriteCSV.writeEventData(EventManager.allEvents);
//        loggedInUser = null;
//    }
//
//    /**
//     * Deletes the user from the system
//     * Note: Not within the scope of phase 1
//     */
//    private static void deleteUser() {
//
//    }
//
//    /**
//     * The entry point of the program.
//     *
//     * @param args - arguments of the program
//     */
//    public static void main(String[] args) {
//        // On startup, read all the stored Users / Events
//        System.out.println("Initializing ...");
//        allUsers = userManager.readUserData();
//        AlertManager.allAlerts = AlertManager.readAlertData();
//        System.out.println("Initialization Done");
//        String userInput = "";
//
//        while (!userInput.equalsIgnoreCase("exit")) {
//            Scanner scanner = new Scanner(System.in);
//
//            // 1. Prompt user for Login / Register
//            if (loggedInUser == null) {
//                // DEBUG: if we input exit here the program won't exit
//                // will look at this another time..
//                loginOrRegister(scanner);
//            }
//
//            // 2. If the user is already logged in, display the various options.
//            mainmenu();
//
//        }
//    }
//    public static void mainmenu(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please choose form the following options:");
//        System.out.println(USER_OPTIONS.toString());
//        String userInput = scanner.nextLine();
//        switch (userInput.toLowerCase()) {
//            case "logout":
//                logOut();
//                loginOrRegister(scanner);
//            case "menu":
//                MenuOption();
//            case "exit":
//                logOut();
//                System.exit(0);
//            default:
//                // We don't need to do anything here
//        }
//
//    }
//
//    public static void MenuOption(){
//        View view = new View();
//        Search search = new Search();
//        Create create = new Create();
//        System.out.println("What do you want to do:");
//        System.out.println(MENU.toString());
//        Scanner scanner = new Scanner(System.in);
//        String userInput = scanner.nextLine();
//        switch (userInput.toLowerCase()){
//            case "create":
//                create.CreatingProcedure();
//            case "view":
//                view.viewProcedure();
//            case "search":
//                search.SearchProcedure();
//            case"delete event":
//            case "leave":
//                mainmenu();
//            default:
//                MenuOption();
//
//
//        }
//
//
//    }
}
