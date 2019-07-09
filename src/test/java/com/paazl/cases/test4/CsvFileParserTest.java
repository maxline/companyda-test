package com.paazl.cases.test4;

import com.paazl.cases.test4.csv.CsvFileParser;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.paazl.cases.test4.DateUtil.stringToDate;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CsvFileParserTest {

    private static final String PATH = "src/test/resources/com/paazl/cases/test4/";

    @Test
    public void shouldReturnCorrectPersonsLists() throws ParserException {
        String csvFileToRead = PATH + "testdata.csv";

        List<Person> expected = Arrays.asList(
                new Person("test1", "Amsterdam", "NL", 0, stringToDate("31/07/2014")),
                new Person("test2", "London", "UK", 1, stringToDate("31/12/2013"))
        );

        List<Person> actual = CsvFileParser.parseCsv(csvFileToRead);

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnEmptyListWhenCsvFileIsEmpty() throws ParserException {
        String csvFileToRead = PATH + "testdata_emptydata.csv";
        List<Person> actual = CsvFileParser.parseCsv(csvFileToRead);
        assertThat(actual, IsEmptyCollection.empty());
    }

    @Test
    public void shouldReturnEmptyListWhenDataInFileIsEmpty() throws ParserException {
        String csvFileToRead = PATH + "testdata_emptyfile.csv";
        List<Person> actual = CsvFileParser.parseCsv(csvFileToRead);
        assertThat(actual, IsEmptyCollection.empty());
    }

    @Test
    public void shouldThrowParserExceptionWhenLineIsBroken() {
        String csvFileToRead = PATH + "testdata_broken_line.csv";

        assertThrows(ParserException.class, () -> CsvFileParser.parseCsv(csvFileToRead));
    }

    @Test
    public void shouldThrowParserExceptionWhenDateValueIsBroken() {
        String csvFileToRead = PATH + "testdata_broken_date.csv";

        assertThrows(ParserException.class, () -> CsvFileParser.parseCsv(csvFileToRead));
    }
}