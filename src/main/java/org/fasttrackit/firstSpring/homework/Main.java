package org.fasttrackit.firstSpring.homework;

import org.springframework.stereotype.Component;

@Component
public class Main {
    private final CountryService countryService;

    public Main(CountryService countryService) {
        this.countryService = countryService;
        //test methods

        System.out.println(countryService.getAllCountries());
        System.out.println(countryService.getCountryName());
        System.out.println(countryService.getCapital("Slovenia"));
        System.out.println(countryService.getPopulation("Slovenia"));
        System.out.println(countryService.getCountriesFromContinent("Asia"));
        System.out.println(countryService.getNeighbours("Slovenia"));
        System.out.println(countryService.getCountriesWithPopulation("Asia" , 2520300 ));
        System.out.println(countryService.getCountryWithSpecificNeighbours("PAK" ,"UZB" ));





    }
}
