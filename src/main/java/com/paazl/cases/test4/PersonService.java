package com.paazl.cases.test4;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {

    public static List<Person> increaseNumberAndDate(List<Person> persons) {

        return null == persons ? null : persons.stream()
                .map(PersonService::createModifiedPerson)
                .collect(Collectors.toList());
    }

    private static Person createModifiedPerson(Person p) {
        return new Person(p.getName(), p.getCity(), p.getCountry(), increaseNumber(p), increaseDate(p));
    }

    private static LocalDate increaseDate(Person p) {
        return p.getDate().plusDays(1);
    }

    private static  int increaseNumber(Person p) {
        return p.getNumber() + 1;
    }
}
