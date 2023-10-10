package com.example.transportead;

public class Reservations {

    private String ReservationDate ;
    private String PassengerName ;
    private String PhoneNumber  ;
    private String Destination ;
    private String Time ;

    public Reservations(){}

    public Reservations(String reservationDate, String passengerName, String phoneNumber, String destination, String time) {
        ReservationDate = reservationDate;
        PassengerName = passengerName;
        PhoneNumber = phoneNumber;
        Destination = destination;
        Time = time;
    }

    public String getReservationDate() {
        return ReservationDate;
    }

    public void setReservationDate(String reservationDate) {
        ReservationDate = reservationDate;
    }

    public String getPassengerName() {
        return PassengerName;
    }

    public void setPassengerName(String passengerName) {
        PassengerName = passengerName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
