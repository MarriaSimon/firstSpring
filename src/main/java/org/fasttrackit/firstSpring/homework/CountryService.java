package org.fasttrackit.firstSpring.homework;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class CountryService {

    private final CountryReader countryReader;
    private final List<Country> countries;

    //   @Autowired
    public CountryService(CountryReader countryReader) throws IOException {
        this.countries = countryReader.readCountry();
        this.countryReader = countryReader;
    }


    //list all countries:  -> returns a list of country objects
    public List<Country> getAllCountries() {
        return countries;
    }

    //list all country names :  -> returns a list of strings
    public List<String> getCountryName() {
        return countries.stream()
                .map(Country::getName)
                .toList();
    }

    // get capital of a country :  -> returns a string
    public String getCapital(String countryName) {
        return countries.stream()
                .filter(country -> country.getName().contains(countryName))
                .findFirst()
                .map(Country::getCapital)
                .orElse(null);
    }

    //- get population of a country : -> returns a long
    public int getPopulation(String countryName) {
        return countries.stream()
                .filter(country -> country.getName().contains(countryName))
                .map(Country::getPopulation)
                .findFirst()
                .orElse(0);
    }

    // - get countries in continent : -> returns list of Country objects
    public List<Country> getCountriesFromContinent(String continentName) {
        return countries.stream()
                .filter(country -> country.getContinent().equals(continentName))
                .collect(Collectors.toList());
    }

    //  - get country neighbours :  -> returns list of Strings
    public List<String> getNeighbours(String countryName) {
        return countries.stream()
                .filter(country -> country.getName().equals(countryName))
                .flatMap(country -> country.getNeighbours().stream())
                .toList();
    }

    // get countries in <continent> with population larger than <population> : -> returns list of Country objects
    public List<Country> getCountriesWithPopulation(String continentName, int populationNumber) {
        return countries.stream()
                .filter(country -> country.getContinent().equals(continentName)
                        && country.getPopulation() > populationNumber)
                .toList();
    }

    // get countries that neighbor X but not neighbor Y :-> returns list of Country objects
    public List<Country> getCountryWithSpecificNeighbours(String neighbourX, String neighbourY) {
        return countries.stream()
                .filter(country -> country.getNeighbours().contains(neighbourX)
                        && !country.getNeighbours().contains(neighbourY))
                .toList();

    }

}
