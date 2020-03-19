package com.automation.qa.model;


import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;

@Getter
public class PersonWithLombok implements IPerson{
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
}
