package com.dungeon.lesson.service;

import com.dungeon.lesson.dao.PurchaseDao;
import com.dungeon.lesson.model.Author;
import com.dungeon.lesson.model.Book;
import com.dungeon.lesson.model.Gender;
import com.dungeon.lesson.model.Genre;
import com.dungeon.lesson.model.Purchase;
import com.dungeon.lesson.util.DateFormatUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PurchaseService {
    public static final String BORDER = "----------------------------------------------------------------------------------------------------------------------------------------------"+System.lineSeparator();
    public static final String HEADER = "| id  | название книги  | имя покупателя |      фамилия       |       страна        |     область       | населенный пункт | почтовый индекс |"+System.lineSeparator();
    public static final String PURCHASE_FORMAT = "| %3d | %-15.15s | %-14.14s | %-18.18s | %-19.19s | %-17.17s | %-16.16s |      %5d      |%n";
    private final PurchaseDao purchaseDao;
    private final Scanner scanner = new Scanner(System.in);

    public PurchaseService(Connection connection) {
        purchaseDao = new PurchaseDao(connection);
    }

    public void printPurchases(List<Purchase> purchases) {
        if (purchases.size() > 0) {

            StringBuilder builder = new StringBuilder();
            builder.append(BORDER);
            builder.append(HEADER);
            builder.append(BORDER);
            for (Purchase purchase : purchases) {
                builder.append(PurchaseService.PURCHASE_FORMAT.formatted(purchase.getId(), purchase.getName(), purchase.getBuyerName(), purchase.getLastName(), purchase.getCountry(), purchase.getRegion(), purchase.getLocality(), purchase.getZipCode()));
            }
            builder.append(BORDER);
            System.out.println(builder.toString());

        } else {
            System.out.println("покупки не найдены");
        }
    }
    private void savePurchase(Purchase purchase) {
        try {
            purchaseDao.savePurchase(purchase);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Purchase createPurchase() {
        Purchase purchase=new Purchase();
        System.out.print("введите название книги : ");
        purchase.setName(scanner.nextLine());
        System.out.print("введите имя покупателя:  ");
        purchase.setBuyerName(scanner.nextLine());
        System.out.println("введите фамилию: ");
        purchase.setLastName(scanner.nextLine());
        System.out.print("введите страну: ");
        purchase.setCountry(scanner.nextLine());
        System.out.println("введите регион: ");
        purchase.setRegion(scanner.nextLine());
        System.out.println("ведите город:");
        purchase.setLocality(scanner.nextLine());
        System.out.println("введите почтовый индекс");
        purchase.setZipCode(scanner.nextInt());

        savePurchase(purchase);
        return purchase;
    }
    public List<Purchase>getAllPurchases(){
        List<Purchase>purchases= new LinkedList<>();
        try {
            return purchaseDao.getAllPurchases();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchases;
    }

    private  void deletePurchase(Purchase purchase){
        try{
            purchaseDao.deletePurchase(purchase);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deletePurchases() {
        List<Purchase> purchases = getAllPurchases();
        printPurchases(purchases);
        System.out.println("выберите историю покупок: ");
        boolean isCorrect = false;
        do {
            int delete = scanner.nextInt();
            if (delete > 0 && delete <= purchases.size()) {
                Purchase purchase= purchases.get(delete - 1);
                deletePurchase(purchase);
                isCorrect = true;
            } else {
                System.out.println("введите существующий номер: ");
            }
        } while (!isCorrect);
        System.out.println("книга удалена ");
    }


    public List<Purchase> searchPurchasesNames(String name){
        List<Purchase> purchases = new LinkedList<>();
        try {
            return purchaseDao.searchPurchasesNames( name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchases;

    }

    public List<Purchase> searchBuyerNames(String buyerName){
        List<Purchase> purchases = new LinkedList<>();
        try {
            return purchaseDao.searchBuyerNames(buyerName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchases;

    }

    public List<Purchase> searchLastNames(String lastName){
        List<Purchase> purchases = new LinkedList<>();
        try {
            return purchaseDao.searchLastNames(lastName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchases;

    }

    public List<Purchase> searchCountry(String country){
        List<Purchase> purchases = new LinkedList<>();
        try {
            return purchaseDao.searchCountry(country);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchases;

    }

    public List<Purchase> searchRegions(String region){
        List<Purchase> purchases = new LinkedList<>();
        try {
            return purchaseDao.searchRegions(region);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchases;

    }

    public List<Purchase> searchLocality(String locality){
        List<Purchase> purchases = new LinkedList<>();
        try {
            return purchaseDao.searchLocality(locality);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchases;

    }
    public List<Purchase> searchZipCodes(int zipCode){
        List<Purchase> purchases = new LinkedList<>();
        try {
            return purchaseDao.searchZipCodes(zipCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchases;

    }
}
