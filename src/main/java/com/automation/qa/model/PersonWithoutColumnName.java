package com.automation.qa.model;

import com.opencsv.bean.CsvBindByPosition;

public class PersonWithoutColumnName implements IPerson{

    @CsvBindByPosition(position = 0, required = true)
    private String firstName;
    @CsvBindByPosition(position = 1, required = true)
    private String lastName;
    @CsvBindByPosition(position = 2, required = true)
    private String city;
    @CsvBindByPosition(position = 3, required = true)
    private int age;
    @CsvBindByPosition(position = 4, required = true)
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
