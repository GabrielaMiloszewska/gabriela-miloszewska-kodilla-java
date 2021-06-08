package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {

    private final List<Country> continent = new ArrayList<>();

    public void addCountry(Country country) {
        continent.add(country);
    }

    public boolean removeCountry(Country country) {
        return continent.remove(country);
    }

    public List<Country> getContinent() {
        return continent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Continent)) return false;

        Continent continent1 = (Continent) o;

        return continent != null ? continent.equals(continent1.continent) : continent1.continent == null;
    }

}
