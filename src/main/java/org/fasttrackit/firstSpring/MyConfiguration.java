package org.fasttrackit.firstSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyConfiguration {
    @Bean
    @Primary
  public Engine myEngine(){
      return new Engine(200);
  }
}
