package com.dungeon.lesson;


import com.dungeon.lesson.service.MainMenuService;

public class Main {
    public static void main(String[] args) {
        Configuration.initConnection();
        MainMenuService consoleService = new MainMenuService();
        consoleService.mainProcess();
        Configuration.closeConnection();


    }
}
