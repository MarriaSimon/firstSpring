package org.fasttrackit.firstSpring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private final Engine engine;

    public Car(@Qualifier("defaultEngine") Engine engine) {
        System.out.println("Building car");
        System.out.println(engine);
        this.engine = engine;
    }
}
