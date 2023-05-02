package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Actor extends BaseModel{

    String name;
}
