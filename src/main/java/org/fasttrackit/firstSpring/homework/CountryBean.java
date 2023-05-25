package org.fasttrackit.firstSpring.homework;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration

public class CountryBean{
    @Bean
    public String filename() {
        return "countries2.txt";
    }


}
