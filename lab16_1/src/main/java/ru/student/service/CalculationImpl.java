package ru.student.service;

import javax.jws.WebService;

@WebService(endpointInterface = "ru.student.service.Calculation")
public class CalculationImpl implements Calculation{
    @Override
    public double add (double a, double b){
        return a + b;
    }

    @Override
    public double subtraction(double a, double b) {
        return a - b;
    }

    @Override
    public double multiplication(double a, double b) {
        return a * b;
    }

    @Override
    public double division(double a, double b) {
        return a / b;
    }
}
