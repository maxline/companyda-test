package com.paazl.cases.test4.csv;

import com.paazl.cases.test4.ParserException;
import com.paazl.cases.test4.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import static com.paazl.cases.test4.DateUtil.stringToDate;

public class CsvFileParser {

    private static final String DELIMITER = ";";
    private static final int COLUMNS_NUMBER = 5;

    public static List<Person> parseCsv(String csvFileToRead) throws ParserException {

        List<Person> persons = new ArrayList<>();

        try (FileReader reader = new FileReader(csvFileToRead);
             BufferedReader br = new BufferedReader(reader)) {

            skipHeaderLine(br);

            String line;
            while ((line = br.readLine()) != null) {
                persons.add(readPerson(line));
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return persons;
    }

    private static void skipHeaderLine(BufferedReader br) throws IOException {
        br.readLine();
    }

    private static Person readPerson(String line) throws ParserException {
        String[] personCsv = line.split(DELIMITER);

        Person person = new Person();

        if (!isValidLine(personCsv)) {
            throw new ParserException();
        }

        person.setName(personCsv[0]);
        person.setCity(personCsv[1]);
        person.setCountry(personCsv[2]);

        try {
            person.setNumber(Integer.valueOf(personCsv[3]));
        } catch (NumberFormatException e) {
            throw new ParserException();
        }

        try {
            person.setDate(stringToDate(personCsv[4]));
        } catch (DateTimeParseException e) {
            throw new ParserException();
        }

        return person;
    }

    private static boolean isValidLine(String[] personCsv) {
        return personCsv.length == COLUMNS_NUMBER; //dummy validation
    }

}
