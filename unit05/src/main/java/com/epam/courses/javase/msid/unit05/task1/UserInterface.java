package com.epam.courses.javase.msid.unit05.task1;

import java.util.Scanner;

public class UserInterface {
    private final static Scanner scanner = new Scanner(System.in);
    private final static String title = "This program allow to see files and directories \nof file system, create or remove txt files and write to end of file.";

    private enum MenuItems {
        SHOW_DIRECTORIES, SHOW_FILES, CREATE_TXT_FILE, WRITE_TO_TXT_FILE, REMOVE_TXT_FILE
    }

    public static void main(String[] args) {
        showTitle();
        while (true) {
            showMenu();
            askTaskAndDoSelected();
            askToExit();
        }
    }

    private static void showTitle() {
        System.out.println(title);
    }

    private static void askToExit() {
        System.out.println("wanna do something els? [y/n]");
        if (scanner.nextLine().equalsIgnoreCase("n")) {
            System.exit(0);
        }
    }

    private static void showMenu() {
        System.out.println("menu items:");
        for (MenuItems item : MenuItems.values()) {
            System.out.println(item.ordinal() + " " + item);
        }
    }

    private static void askTaskAndDoSelected() {
        int selected = Integer.parseInt(scanner.nextLine());
        switch (MenuItems.values()[selected]) {
            case SHOW_DIRECTORIES:
                showDirectory();
                break;
            case SHOW_FILES:
                showFiles();
                break;
            case CREATE_TXT_FILE:
                createTxt();
                break;
            case REMOVE_TXT_FILE:
                removeTxt();
                break;
            case WRITE_TO_TXT_FILE:
                writeToTxt();
                break;
            default:
                System.out.println("please select menu item");
        }

    }

    private static void showDirectory() {
    }

    private static void showFiles() {
    }

    private static void writeToTxt() {

    }

    private static void removeTxt() {
    }

    private static void createTxt() {

    }
}