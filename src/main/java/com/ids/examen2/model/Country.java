package com.ids.examen2.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_country;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idairport")
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_airport")
    private List<Airport> airport;


    public List<Airport> getAirport() {
        return airport;
    }

    public void setAirport(List<Airport> airport) {
        this.airport = airport;
    }



    public long getId_country() {
        return id_country;
    }

    public void setId_country(long id_country) {
        this.id_country = id_country;
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

