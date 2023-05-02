package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    @ManyToOne
    private SeatType seatType;
    private int row;
    private int col;
    private String name;

}
