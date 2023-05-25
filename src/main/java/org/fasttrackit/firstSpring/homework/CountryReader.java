package org.fasttrackit.firstSpring.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Component
public class CountryReader {
    private String filename;

    public List<Country> readCountry() throws IOException {
        List<Country> countryList = new ArrayList<>();

        ClassPathResource resource = new ClassPathResource("countries2.txt");
        Path file = resource.getFile().toPath();

        try (Stream<String> lines = Files.lines(file)) {
            lines.forEach(line -> {
                String[] data = line.split("\\|");
                if (data.length >= 6) {
                    String name = data[0];
                    String capital = data[1];
                    int population = Integer.parseInt(data[2]);
                    double area = Double.parseDouble(data[3]);
                    String continent = data[4];

                    List<String> neighbours = new ArrayList<>();
                    if (StringUtils.hasText(data[5])) {
                        String[] neighbourData = data[5].split("~");
                        for (String neighbour : neighbourData) {
                            neighbours.add(neighbour);
                        }
                    }

                    Country country = new Country();
                    country.setId(UUID.randomUUID().toString());
                    country.setName(name);
                    country.setCapital(capital);
                    country.setPopulation(population);
                    country.setArea(area);
                    country.setContinent(continent);
                    country.setNeighbours(neighbours);

                    countryList.add(country);
                } else {
                    System.out.println("Invalid data : " + line);
                    return;


                }
            });
        }
        return countryList;
    }
}
