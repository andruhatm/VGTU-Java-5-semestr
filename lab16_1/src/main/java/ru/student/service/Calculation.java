package ru.student.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Calculation {
    @WebMethod
    double add (double a, double b);

    @WebMethod
    double subtraction (double a, double b);

    @WebMethod
    double multiplication (double a, double b);

    @WebMethod
    double division (double a, double b);
}
