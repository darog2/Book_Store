package com.dungeon.lesson;


import com.dungeon.lesson.service.ConsoleService;

public class Main {
    public static void main(String[] args) {
        Configuration.initConnection();
        ConsoleService consoleService = new ConsoleService();
        consoleService.mainProcess();
        Configuration.closeConnection();


    }
}
