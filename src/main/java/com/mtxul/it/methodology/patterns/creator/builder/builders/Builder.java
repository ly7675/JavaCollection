package com.mtxul.it.methodology.patterns.creator.builder.builders;

import com.mtxul.it.methodology.patterns.creator.builder.cars.CarType;
import com.mtxul.it.methodology.patterns.creator.builder.components.Engine;
import com.mtxul.it.methodology.patterns.creator.builder.components.GPSNavigator;
import com.mtxul.it.methodology.patterns.creator.builder.components.Transmission;
import com.mtxul.it.methodology.patterns.creator.builder.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);
}
