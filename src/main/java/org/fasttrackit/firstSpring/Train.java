package org.fasttrackit.firstSpring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Train {
    private final Engine engine;

    public Train(@Qualifier("defaultEngine") Engine engine) {
        System.out.println("Building train");
        System.out.println(engine);
        this.engine = engine;
    }
}
