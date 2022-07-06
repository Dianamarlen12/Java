package com.ids.examen2.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_employee;

    @Column(name = "surname")
    private String surname;

    @Column(name = "firstname")
    private String firstname;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "languagesEmployee",
                joinColumns = @JoinColumn(name = "id_employee"),
                inverseJoinColumns = @JoinColumn(name = "id_lenguage"))
    private List<Language> languageName;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_country")
    private Country country;


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Language> getLanguageName() {
        return languageName;
    }

    public void setLanguageName(List<Language> languageName) {
        this.languageName = languageName;
    }

    public long getId_employee() {
        return id_employee;
    }

    public void setId_employee(long id_employee) {
        this.id_employee = id_employee;
    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

}



