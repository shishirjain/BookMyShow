package com.example.demo.Service;

import com.example.demo.Models.Show;
import com.example.demo.Models.ShowSeat;
import com.example.demo.Models.ShowSeatType;
import com.example.demo.Repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketPriceCalculator {
    private ShowSeatTypeRepository showSeatTypeRepository;
    @Autowired
    public TicketPriceCalculator(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository=showSeatTypeRepository;
    }
   public double calculateTicketPrice(List<ShowSeat> showSeats){
            Show show= showSeats.get(0).getShow();
            double amount=0;
            //1 get the ShowSeatType objects for this show
            List<ShowSeatType> showSeatTypes=showSeatTypeRepository.findAllByShowEquals(show);

            //2 Add the price and done
            for(ShowSeat showSeat:showSeats){
                for(ShowSeatType showSeatType:showSeatTypes){
                    if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                        amount+=showSeatType.getPrice();
                    }
                }
            }
   return  amount;}
}
