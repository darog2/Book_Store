package com.dungeon.lesson.model;

public class Purchase {
    private int id;
    private String name;
    private String buyerName;
    private String lastName;
    private String country;
    private String region;
    private String locality;
    private int zipCode;

    public Purchase() {
    }

    public Purchase(int id, String name, String buyerName, String lastName, String country, String region, String locality, int zipCode) {
        this.id = id;
        this.name = name;
        this.buyerName = buyerName;
        this.lastName = lastName;
        this.country = country;
        this.region = region;
        this.locality = locality;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", locality='" + locality + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
