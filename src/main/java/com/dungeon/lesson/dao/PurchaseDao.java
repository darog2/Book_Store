package com.dungeon.lesson.dao;

import com.dungeon.lesson.model.Purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PurchaseDao {
    private static final String INSERT_PURCHASE =
            "insert into purchases(name,buyer_name,last_name,country,region,locality,zip_code) values(?,?,?,?,?,?,?);";
    private static final String DELETE_PURCHASE = "delete from  purchases where  id = ?;";
    private static final String SELECT = "select id,name,buyer_name,last_name,country,region,locality,zip_code from purchases order by id;";
    private static final String SEARCH_NAME = "select id,name,buyer_name,last_name,country,region,locality,zip_code from purchases where lower(name) like(?);";
    private static final String SEARCH_BUYER_NAME = "select id,name,buyer_name,last_name,country,region,locality,zip_code from purchases where lower(buyer_name) like(?);";
    private static final String SEARCH_LAST_NAME = "select id,name,buyer_name,last_name,country,region,locality,zip_code from purchases where lower(last_name) like(?);";
    private static final String SEARCH_COUNTRY = "select id,name,buyer_name,last_name,country,region,locality,zip_code from purchases where lower(country) like(?);";
    private static final String SEARCH_REGION = "select id,name,buyer_name,last_name,country,region,locality,zip_code from purchases where lower(region) like(?);";
    private static final String SEARCH_LOCALITY = "select id,name,buyer_name,last_name,country,region,locality,zip_code from purchases where lower(locality) like(?);";
    private static final String SEARCH_ZIP_CODE = "select id,name,buyer_name,last_name,country,region,locality,zip_code from purchases where (zip_code)=? ;";
    private final Connection connection;


    public PurchaseDao(Connection connection) {
        this.connection = connection;
    }

    public void savePurchase(Purchase purchase) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_PURCHASE);
        statement.setString(1, purchase.getName());
        statement.setString(2, purchase.getBuyerName());
        statement.setString(3, purchase.getLastName());
        statement.setString(4, purchase.getCountry());
        statement.setString(5, purchase.getRegion());
        statement.setString(6, purchase.getLocality());
        statement.setInt(7, purchase.getZipCode());
        statement.executeUpdate();
        statement.close();
    }

    public List<Purchase> getAllPurchases() throws SQLException {
        List<Purchase> purchases = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement(SELECT);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Purchase purchase = new Purchase(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getInt(8));
            purchases.add(purchase);
        }
        resultSet.close();
        statement.close();
        return purchases;
    }

    public void deletePurchase(Purchase purchase) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DELETE_PURCHASE);
        statement.setInt(1, purchase.getId());
        statement.executeUpdate();
        statement.close();
    }

    public List<Purchase> searchPurchasesNames(String name) throws SQLException {
        List<Purchase> purchases = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement(SEARCH_NAME);
        statement.setString(1, "%" + name + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Purchase purchase = new Purchase(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getInt(8));
            purchases.add(purchase);
        }
        resultSet.close();
        statement.close();
        return purchases;
    }

    public List<Purchase> searchBuyerNames(String buyerName) throws SQLException {
        List<Purchase> purchases = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement(SEARCH_BUYER_NAME);
        statement.setString(1, "%" + buyerName + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Purchase purchase = new Purchase(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getInt(8));
            purchases.add(purchase);
        }
        resultSet.close();
        statement.close();
        return purchases;
    }

    public List<Purchase> searchLastNames(String lastName) throws SQLException {
        List<Purchase> purchases = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement( SEARCH_LAST_NAME);
        statement.setString(1, "%" + lastName + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Purchase purchase = new Purchase(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getInt(8));
            purchases.add(purchase);
        }
        resultSet.close();
        statement.close();
        return purchases;
    }

    public List<Purchase> searchCountry(String country) throws SQLException {
        List<Purchase> purchases = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement( SEARCH_COUNTRY);
        statement.setString(1, "%" + country + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Purchase purchase = new Purchase(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getInt(8));
            purchases.add(purchase);
        }
        resultSet.close();
        statement.close();
        return purchases;
    }

    public List<Purchase> searchRegions(String region) throws SQLException {
        List<Purchase> purchases = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement( SEARCH_REGION);
        statement.setString(1, "%" + region + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Purchase purchase = new Purchase(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getInt(8));
            purchases.add(purchase);
        }
        resultSet.close();
        statement.close();
        return purchases;
    }

    public List<Purchase> searchLocality(String locality) throws SQLException {
        List<Purchase> purchases = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement( SEARCH_LOCALITY);
        statement.setString(1, "%" + locality + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Purchase purchase = new Purchase(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getInt(8));
            purchases.add(purchase);
        }
        resultSet.close();
        statement.close();
        return purchases;
    }

    public List<Purchase> searchZipCodes(int zipCode) throws SQLException {
        List<Purchase> purchases = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement( SEARCH_ZIP_CODE);
        statement.setInt(1, zipCode);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Purchase purchase = new Purchase(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getInt(8));
            purchases.add(purchase);
        }
        resultSet.close();
        statement.close();
        return purchases;
    }

}
