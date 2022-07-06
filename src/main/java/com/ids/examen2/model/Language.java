package com.ids.examen2.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "languaje")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_language;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "languageName", cascade = CascadeType.PERSIST)
    private List<Employee> lenguage;

    public List<Employee> getLenguage() {
        return lenguage;
    }

    public void setLenguage(List<Employee> lenguage) {
        this.lenguage = lenguage;
    }

    public long getId_language() {
        return id_language;
    }

    public void setId_language(long id_language) {
        this.id_language = id_language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

