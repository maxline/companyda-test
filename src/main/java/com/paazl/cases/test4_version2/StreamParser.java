package com.paazl.cases.test4_version2;

import com.paazl.cases.test4.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.paazl.cases.test4.DateUtil.stringToDate;

public class StreamParser {
    /*
     * Another version of Parser implementation that using streams
     * This is not called from Main, just example
     */
    private static final String DELIMITER = ";";
    private static final int HEADER_LINE = 1;
    private Function<String, Person> mapToItem = (line) -> {
        String[] personCsv = line.split(DELIMITER);
        Person person = new Person();

        person.setName(personCsv[0]);
        person.setCity(personCsv[1]);
        person.setCountry(personCsv[2]);
        person.setNumber(Integer.valueOf(personCsv[3]));
        person.setDate(stringToDate(personCsv[4]));

        return person;
    };

    public List<Person> parseCsv(String inputFile) {

        List<Person> persons = new ArrayList<>();
        try (InputStream inputFS = new FileInputStream(inputFile);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputFS))) {

            persons = br.lines().skip(HEADER_LINE).map(mapToItem).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return persons;
    }

}
