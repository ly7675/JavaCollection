package com.mtxul.it.methodology.patterns.creator.builder.builders;

import com.mtxul.it.methodology.patterns.creator.builder.cars.Car;
import com.mtxul.it.methodology.patterns.creator.builder.cars.CarType;
import com.mtxul.it.methodology.patterns.creator.builder.components.Engine;
import com.mtxul.it.methodology.patterns.creator.builder.components.GPSNavigator;
import com.mtxul.it.methodology.patterns.creator.builder.components.Transmission;
import com.mtxul.it.methodology.patterns.creator.builder.components.TripComputer;

public class CarBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Car getResult() {
        return new Car(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}