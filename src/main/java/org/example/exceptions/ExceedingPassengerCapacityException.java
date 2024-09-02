package org.example.exceptions;

public class ExceedingPassengerCapacityException extends Exception
{
    public ExceedingPassengerCapacityException(String message) {
        super(message);
    }
}
