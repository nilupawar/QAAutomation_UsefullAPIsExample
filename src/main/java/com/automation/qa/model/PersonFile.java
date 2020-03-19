package com.automation.qa.model;

import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PersonFile {
    private static final Logger LOG = LoggerFactory.getLogger(PersonFile.class);

    private List<IPerson> persons = new ArrayList<>();
    Path personFilePath;

    public PersonFile(Path personFilePath){
        this.personFilePath = personFilePath;
    }

    public void parsePersonWithColumnName() throws IOException {
        if(!persons.isEmpty()){
            LOG.info("File has already been processed, you can get all persons by calling right getter method");
        }
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(personFilePath)))) {
            persons = new CsvToBeanBuilder<IPerson>(reader)
                    .withType(PersonWithColumnName.class)
                    .withQuoteChar('"')
                    .withIgnoreQuotations(false)
                    .withSeparator(',')
                    .withSkipLines(0)
                    .build()
                    .parse();
        }
    }

    public void parsePersonWithoutColumnName() throws IOException {
        if(!persons.isEmpty()){
            LOG.info("File has already been processed, you can get all persons by calling right getter method");
        }
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(personFilePath)))) {
            persons = new CsvToBeanBuilder<IPerson>(reader)
                    .withType(PersonWithoutColumnName.class)
                    .withQuoteChar('"')
                    .withIgnoreQuotations(false)
                    .withSeparator(',')
                    .withSkipLines(0)
                    .build()
                    .parse();
        }
    }


    public void parsePersonWithoutColumnNameLombok() throws IOException {
        if(!persons.isEmpty()){
            LOG.info("File has already been processed, you can get all persons by calling right getter method");
        }
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(personFilePath)))) {
            persons = new CsvToBeanBuilder<IPerson>(reader)
                    .withType(PersonWithLombok.class)
                    .withQuoteChar('"')
                    .withIgnoreQuotations(false)
                    .withSeparator(',')
                    .withSkipLines(0)
                    .build()
                    .parse();
        }
    }

    public List<IPerson> getPersons(){
        return persons;
    }

}
