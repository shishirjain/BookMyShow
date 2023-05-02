package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
@MappedSuperclass
public class BaseModel {
    @jakarta.persistence.Id
    private long Id;
}
