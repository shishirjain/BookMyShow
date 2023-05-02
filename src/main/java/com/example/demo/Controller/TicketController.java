package com.example.demo.Controller;

import com.example.demo.DTO.BookTicketRequestDTO;
import com.example.demo.DTO.BookTicketResponseDTO;
import com.example.demo.Exceptions.SeatNotAvailableException;
import com.example.demo.Models.Ticket;
import com.example.demo.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketController {

    private TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }
    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO request){
        Long showId=request.getShowId();
        List<Long> showSeatIds=request.getShowSeatId();
        try{
            Ticket ticket= ticketService.bookTicket(showId,showSeatIds);

            BookTicketResponseDTO response=new BookTicketResponseDTO();
            response.setStatus("SUCCESS");
            response.setTicket(ticket);
            return  response;
        }
        catch(SeatNotAvailableException exception){
            BookTicketResponseDTO response=new BookTicketResponseDTO();
            response.setStatus("FALIURE");
            return response;
        }

        return null;
    }
}
