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
import java.util.List;
import java.util.Objects;

public class ReadDelimitedFile {

    private static final Logger LOG = LoggerFactory.getLogger(ReadDelimitedFile.class);

    public static void main(String[] args) throws URISyntaxException, IOException {
        Path fileWithHeader = Paths.get(Objects.requireNonNull(ReadDelimitedFile.class.getClassLoader().getResource("WithHeaderDelimitedFile.txt")).toURI());
        Path fileWithoutHeader = Paths.get(Objects.requireNonNull(ReadDelimitedFile.class.getClassLoader().getResource("WithoutHeaderDelimitedFile.txt")).toURI());

        PersonFile personFileWithHeader = new PersonFile(fileWithHeader);
        PersonFile personFileWithoutHeader = new PersonFile(fileWithoutHeader);

        personFileWithHeader.parsePersonWithColumnName();
        personFileWithoutHeader.parsePersonWithoutColumnName();

        List<IPerson> personFileWithHeaderList = personFileWithHeader.getPersons();
        List<IPerson> personFileWithoutHeaderList = personFileWithoutHeader.getPersons();

        System.out.println("-------------------- Users in with Header file --------------------");
        personFileWithHeaderList.forEach(person -> System.out.println(person.getFirstName()));

        System.out.println("-------------------- Users in without Header file --------------------");
        personFileWithoutHeaderList.forEach(person -> System.out.println(person.getFirstName()));
    }
}
