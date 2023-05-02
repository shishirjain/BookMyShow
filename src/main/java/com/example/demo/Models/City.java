package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class City extends BaseModel{
    private String Name;
    @OneToMany
    private List<Theater> theaters;
}
