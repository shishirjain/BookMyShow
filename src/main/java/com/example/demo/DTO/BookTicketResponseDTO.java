package com.example.demo.DTO;

import com.example.demo.Models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDTO {
    private String status;
    private Ticket ticket;
}
