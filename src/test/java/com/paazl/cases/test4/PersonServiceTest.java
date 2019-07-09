package com.paazl.cases.test4;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.paazl.cases.test4.DateUtil.stringToDate;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonServiceTest {

    private List<Person> INPUT = Arrays.asList(
            new Person("test1", "Amsterdam", "NL", 0, stringToDate("31/07/2014")),
            new Person("test2", "London", "UK", 1, stringToDate("31/12/2013"))
    );

    private List<Person> EXPECTED = Arrays.asList(
            new Person("test1", "Amsterdam", "NL", 1, stringToDate("01/08/2014")),
            new Person("test2", "London", "UK", 2, stringToDate("01/01/2014"))
    );

    @Test
    public void shouldReturnListWithIncreasedNumberByOne() {

        List<Person> actual = PersonService.increaseNumberAndDate(INPUT);
        assertThat(actual.get(0).getNumber(), is(EXPECTED.get(0).getNumber()));
        assertThat(actual.get(1).getNumber(), is(EXPECTED.get(1).getNumber()));
    }

    @Test
    public void shouldReturnListWithIncreasedDateByOneDay() {

        List<Person> actual = PersonService.increaseNumberAndDate(INPUT);
        assertThat(actual.get(0).getDate(), is(EXPECTED.get(0).getDate()));
        assertThat(actual.get(1).getDate(), is(EXPECTED.get(1).getDate()));
    }

    @Test
    public void shouldKeepOtherListValuesWithoutChanges() {

        List<Person> actual = PersonService.increaseNumberAndDate(INPUT);
        assertThat(actual.get(0).getName(), is(INPUT.get(0).getName()));
        assertThat(actual.get(0).getCity(), is(INPUT.get(0).getCity()));
        assertThat(actual.get(0).getCountry(), is(INPUT.get(0).getCountry()));
    }

}