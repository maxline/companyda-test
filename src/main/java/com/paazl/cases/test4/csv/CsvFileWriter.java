package com.paazl.cases.test4.csv;

import com.paazl.cases.test4.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static com.paazl.cases.test4.DateUtil.dateToString;

public class CsvFileWriter {

    private static final String DELIMITER = ";";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "name;city;country;number;date";

    public static void writeCsvFile(String fileName, List<Person> persons) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Person person : persons) {
                writeLine(fileWriter, person);
            }

            System.out.println("CSV file " + fileName + " was created successfully!!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    private static void writeLine(FileWriter fileWriter, Person person) throws IOException {

        fileWriter.append(person.getName());
        fileWriter.append(DELIMITER);
        fileWriter.append(person.getCity());
        fileWriter.append(DELIMITER);
        fileWriter.append(person.getCountry());
        fileWriter.append(DELIMITER);
        fileWriter.append(String.valueOf(person.getNumber()));
        fileWriter.append(DELIMITER);
        fileWriter.append(dateToString(person.getDate()));

        fileWriter.append(NEW_LINE_SEPARATOR);
    }
}
