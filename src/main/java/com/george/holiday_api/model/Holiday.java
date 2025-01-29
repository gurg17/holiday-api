package com.george.holiday_api.model;

import java.time.LocalDate;
import java.util.Objects;

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

    // Override equals() to compare holidays based on date and name
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Holiday holiday = (Holiday) obj;
        return Objects.equals(date, holiday.date) && Objects.equals(name, holiday.name);
    }

    // Override hashCode() to match equals() implementation
    @Override
    public int hashCode() {
        return Objects.hash(date, name);
    }
}
