package ru.student.service;

import javax.xml.ws.Endpoint;

public class CalculationPublisher {
    public static void main(String[] args) {
        //
        Endpoint.publish("http://localhost:1111/wss/calculation", new CalculationImpl());
    }
}
