package com.paazl.cases.test4;

import com.paazl.cases.test4.csv.CsvFileWriter;
import com.paazl.cases.test4.csv.CsvFileParser;

import java.util.List;

public class Main {


    /*
     * Read and parse "testdata.csv" (located in
     * src/main/resources/com/paazl/cases/test4) into a list of POJOs. Increase
     * each POJO's "number" field by 1, and move the "date" field one day ahead.
     * Write the results to a file named "testdata.new.csv".
     */
    public static void main(String[] args) throws ParserException {

        String csvFileToRead = "src/main/resources/com/paazl/cases/test4/testdata.csv";
        String csvFileToWrite = "src/main/resources/com/paazl/cases/test4/testdata.new.csv";

        List<Person> persons = CsvFileParser.parseCsv(csvFileToRead);
        List<Person> modifiedPersons = PersonService.increaseNumberAndDate(persons);
        CsvFileWriter.writeCsvFile(csvFileToWrite, modifiedPersons);
    }
}