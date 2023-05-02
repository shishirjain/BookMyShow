package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    @ManyToOne
    private Show show;
    @OneToMany
    private List<Payment> payments;
    @ManyToMany
    private List<ShowSeat> showSeats;
    private double Amount;
    private Date BookingDate;
    private Time BookingTime;
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;
}
