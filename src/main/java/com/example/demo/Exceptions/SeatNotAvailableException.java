package com.example.demo.Exceptions;

public class SeatNotAvailableException extends Exception{
    public SeatNotAvailableException(String message){
         super(message);
    }
}
