package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    private String Name;
    private String Address;
    @OneToMany
    private List<Auditorium> auditoriums;
    private String Company;


}
