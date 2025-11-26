package com.eudes.screenmatch.exercicios.interfaces;

public class Ex003 {
    public static void main(String[] args) {
        IConverteMaiuscula converteMaiuscula = String::toUpperCase;

        System.out.println(converteMaiuscula.converteMaiuscula("castelo"));
    }
}
