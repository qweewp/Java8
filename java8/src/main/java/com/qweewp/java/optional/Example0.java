package com.qweewp.java.optional;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

public class Example0 {
    class ImperativeStyle {
        public String getPersonCarInsuranceName(Person person) {
            String name = "Unknown";
            if (ofNullable(person).isPresent()) {
                if (person.getCar().isPresent()) {
                    if (person.getCar().get().getInsurance().isPresent()) {
                        name = person.getCar().get().getInsurance().get().getName();
                    }
                }
            }
            return name;
        }
    }

    class UsingIfPresent {
        public String getPersonCarInsuranceName(Person person) {
            final StringBuilder builder = new StringBuilder();
            ofNullable(person).ifPresent(
                    p -> p.getCar().ifPresent(
                            c -> c.getInsurance().ifPresent(
                                    i -> builder.append(i.getName())
                            )
                    )
            );
            return builder.toString();
        }
    }

    class UsingGet {
        public String getPersonCarInsuranceName(Person person) {
            return ofNullable(person)
                    .map(Person::getCar)
                    .map(car -> car.get().getInsurance())
                    .map(insurance -> insurance.get().getName())
                    .orElse("Unknown");
        }
    }

    class UsingOrElse {
        public String getPersonCarInsuranceName(Person person) {
            return ofNullable(person)
                    .map(Person::getCar)
                    .map(car -> car.orElse(new Car()).getInsurance())
                    .map(insurance -> insurance.orElse(new Insurance()).getName())
                    .orElse("Unknown");
        }
    }

    class Person {
        public Optional<Car> getCar() {
            return empty(); //stub
        }
    }

    class Car {
        public Optional<Insurance> getInsurance() {
            return empty(); //stub
        }
    }

    class Insurance {
        public String getName() {
            return ""; //stub
        }
    }
}
