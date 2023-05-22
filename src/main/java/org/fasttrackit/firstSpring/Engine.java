package org.fasttrackit.firstSpring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("defaultEngine")

public class Engine {
    private int horsePower;

    @Value("${one.custom.property}")
    private String myProperty;

    public Engine() {
        System.out.println("Building default engine");
        horsePower = 100;
    }

    public Engine(int horsePower) {
        System.out.println("Building custom engine");
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "horsePower=" + horsePower +
                '}';
    }
}
