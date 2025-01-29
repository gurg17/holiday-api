package com.george.holiday_api.model;

import java.time.LocalDate;

public class Holiday {
    private LocalDate date;
    private String localName;
    private String name;
    private String countryCode;

    // * Constructors
    public Holiday(LocalDate date, String localName, String name, String countryCode) {
        this.date = date;
        this.localName = localName;
        this.name = name;
        this.countryCode = countryCode;
    }

    // * Getters
    public LocalDate getDate() {
        return date;
    }

    public String getLocalName() {
        return localName;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    // * Setters
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
