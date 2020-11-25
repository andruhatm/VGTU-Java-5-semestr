package ru.student.client;

import ru.student.service.Calculation;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
    public static void main(String[] args) throws MalformedURLException {
        //запрашивает адрес и создает сервис
        URL url = new URL("http://localhost:1111/wss/calculation?wsdl");
        QName qName = new QName("http://service.student.ru/", "CalculationImplService");
        Service service = Service.create(url, qName);
        Calculation calculation = service.getPort(Calculation.class);

        System.out.println("1 + 2: " + calculation.add(1, 2));
        System.out.println("3 - 2: " + calculation.division(3, 2));
        System.out.println("2 * 2: " + calculation.multiplication(5, 2));
        System.out.println("8 / 4: " + calculation.division(8, 4));
    }

}
