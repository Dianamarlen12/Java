package com.ids.examen2.service;

import com.ids.examen2.exception.ResourceNotFoundException;
import com.ids.examen2.model.Airport;
import com.ids.examen2.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport updateAirport(Airport airport) {
        Optional<Airport> airportDb = this.airportRepository.findById(airport.getId_airport());

        if (airportDb.isPresent()){
            Airport airportUpdate = airportDb.get();
            airportUpdate.setId_airport(airport.getId_airport());
            airportUpdate.setName(airport.getName());
            airportUpdate.setCode(airport.getCode());
            airportRepository.save(airportUpdate);
            return airportUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + airport.getId_airport());
        }
    }

    @Override
    public List<Airport> getAllAirports() {
        return this.airportRepository.findAll();
    }

    @Override
    public Airport getAirportById(long airportId) {
        Optional<Airport> airportDB = this.airportRepository.findById(airportId);

        if (airportDB.isPresent()) {
            return airportDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + airportId);
        }
    }

    @Override
    public void deleteAirport(long id_airport) {
        Optional<Airport> airportDB = this.airportRepository.findById(id_airport);

        if (airportDB.isPresent()) {
            this.airportRepository.delete(airportDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + id_airport);
        }
    }
}