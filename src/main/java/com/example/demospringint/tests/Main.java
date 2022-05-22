package com.example.demospringint.tests;

import reactor.core.publisher.Mono;

public class Main {
    public static void main(String[] args) {
        Mono.just("Craig")
                .map(n -> n.toUpperCase())
                .map(cn -> "Hello, " + cn + "!")
                .subscribe(System.out::println);
    }

    static void testParent(Parent parent) {
        System.out.println(parent.calculate(120));;
    }
}
