package com.example.demo.Service;

import com.example.demo.Exceptions.SeatNotAvailableException;
import com.example.demo.Models.*;
import com.example.demo.Repositories.ShowSeatRepository;
import com.example.demo.Repositories.TicketRepository;
import com.example.demo.Repositories.showRepository;
import jakarta.persistence.LockModeType;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.LockMode;
import org.springframework.data.relational.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class TicketService {
    private showRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private TicketPriceCalculator ticketPriceCalculator;
@Autowired
    private TicketRepository ticketRepository;
    public  TicketService(showRepository showRepository,ShowSeatRepository showSeatRepository,TicketPriceCalculator
                          ticketPriceCalculator,TicketRepository ticketRepository){
        this.showRepository=showRepository;
        this.showSeatRepository=showSeatRepository;
        this.ticketPriceCalculator=ticketPriceCalculator;
        this.ticketRepository=ticketRepository;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long showId, List<Long> showSeatIds) throws SeatNotAvailableException {
        //1.Get show with that id

        Show show=showRepository.findByIdEquals(showId);
        //2. Show seat with those ids

        List<ShowSeat> showSeats=showSeatRepository.findAllByIdIn(showSeatIds);
        //3. Check if all seats are available
        for(ShowSeat showSeat:showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.Available)){
                throw new SeatNotAvailableException("Show seat"+showSeat.getId()+"is not available");
            }
        }
        //4.1.If available
        //      set status to locked
        //      create a ticket and save it to db

        for(ShowSeat showSeat:showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.Locked);
            showSeatRepository.save(showSeat);
        }
        Ticket ticket=new Ticket();
        ticket.setTicketStatus(TicketStatus.In_Process);
        ticket.setShow(show);
        ticket.setBookingDate(new Date());
        ticket.setAmount(ticketPriceCalculator.calculateTicketPrice(showSeats));
        ticket.setShowSeats(showSeats);
        Ticket savedTicket= ticketRepository.save(ticket);
        //4.2 If not:
        //      throw exception
        return savedTicket;
    }
}
