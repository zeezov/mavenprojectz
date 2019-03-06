package com.cybertek;

import com.github.javafaker.Faker;

public class FakerTest {

    public static void main(String[] args) {

        Faker faker = new com.github.javafaker.Faker();

        System.out.println(faker.address().fullAddress());

        System.out.println(faker.name().firstName());




    }

}
