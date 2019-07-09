package com.paazl.cases.test4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Person {
    private String name;
    private String city;
    private String country;
    private int number;
    private LocalDate date;

    public Person() {
    }

    public Person(String name, String city, String country, int number, LocalDate date) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.number = number;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getNumber() == person.getNumber() &&
                getName().equals(person.getName()) &&
                Objects.equals(getCity(), person.getCity()) &&
                Objects.equals(getCountry(), person.getCountry()) &&
                Objects.equals(getDate(), person.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCity(), getCountry(), getNumber(), getDate());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", number=" + number +
                ", date='" + date + '\'' +
                '}';
    }
}
