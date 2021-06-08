package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {

    private final List<Continent> world = new ArrayList<>();

    public void addContinent(Continent continent) {
        world.add(continent);
    }

    public boolean removeContinent(Continent continent) {
        return world.remove(continent);
    }

    public BigDecimal getPeopleQuantity() {
        return (BigDecimal) world.stream()
        .flatMap(continent -> continent.getContinent().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof World)) return false;

        World world1 = (World) o;

        return world != null ? world.equals(world1.world) : world1.world == null;
    }

}
