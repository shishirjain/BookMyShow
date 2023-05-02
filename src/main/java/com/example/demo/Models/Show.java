package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
public class Show extends BaseModel{
    @ManyToOne
    private Auditorium auditorium;
    private Date StartTime;
    private Date EndTime;
    @ManyToOne
    private Movie movie;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;
}
