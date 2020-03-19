package com.automation.qa.example;

import com.automation.qa.model.IPerson;
import com.automation.qa.model.PersonFile;
import com.automation.qa.model.PersonWithColumnName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ReadDelimitedFile {

    private static final Logger LOG = LoggerFactory.getLogger(ReadDelimitedFile.class);

    public static void main(String[] args) throws URISyntaxException, IOException {
        Path fileWithHeader = Paths.get(Objects.requireNonNull(ReadDelimitedFile.class.getClassLoader().getResource("WithHeaderDelimitedFile.txt")).toURI());
        Path fileWithoutHeader = Paths.get(Objects.requireNonNull(ReadDelimitedFile.class.getClassLoader().getResource("WithoutHeaderDelimitedFile.txt")).toURI());


        PersonFile personFileWithHeader = new PersonFile(fileWithHeader);
        PersonFile personFileWithoutHeader = new PersonFile(fileWithoutHeader);
        PersonFile personFileUsingLombok = new PersonFile(fileWithoutHeader);

        personFileWithHeader.parsePersonWithColumnName();
        personFileWithoutHeader.parsePersonWithoutColumnName();
        personFileUsingLombok.parsePersonWithoutColumnNameLombok();

        List<IPerson> personFileWithHeaderList = personFileWithHeader.getPersons();
        List<IPerson> personFileWithoutHeaderList = personFileWithoutHeader.getPersons();
        List<IPerson> personFileLombokList = personFileUsingLombok.getPersons();

        System.out.println("-------------------- Users in with Header file --------------------");
        personFileWithHeaderList.forEach(person -> System.out.println(person.getFirstName()));

        System.out.println("-------------------- Users in without Header file --------------------");
        personFileWithoutHeaderList.forEach(person -> System.out.println(person.getFirstName()));

        System.out.println("-------------------- Users in without Header file - Lombok --------------------");
        personFileLombokList.forEach(person -> System.out.println(person.getFirstName()));

    }

    private <T extends String> void myMethod(T  y, int a){
        System.out.println("Static method invoked " + y + a);
    }
}
