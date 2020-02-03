package com.automation.qa.model;

import com.opencsv.bean.CsvBindByName;

public class PersonWithColumnName implements IPerson {

    @CsvBindByName(column = "First_Name",required = true)
    private String firstName;
    @CsvBindByName(column = "Last_Name",required = true)
    private String lastName;
    @CsvBindByName(column = "City",required = true)
    private String city;
    @CsvBindByName(column = "Age",required = true)
    private int age;
    @CsvBindByName(column = "Occupation",required = true)
    private String occupation;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }
}
