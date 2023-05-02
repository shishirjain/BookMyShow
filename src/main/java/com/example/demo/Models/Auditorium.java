package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity

public class Auditorium extends BaseModel{
    private String Name;
    @OneToMany(mappedBy ="auditorium")
    private List<Show> shows;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;
    @OneToMany
    private List<Seat> seats;
}
