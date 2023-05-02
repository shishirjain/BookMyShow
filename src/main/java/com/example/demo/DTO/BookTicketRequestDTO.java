package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookTicketRequestDTO {
    private Long showId;
    private List<Long> showSeatId;
}
