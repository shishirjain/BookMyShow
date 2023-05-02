package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Show show;

    private double price;
    @ManyToOne
    private SeatType seatType;
}
