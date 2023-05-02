package com.example.demo.Repositories;

import com.example.demo.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {
    List<ShowSeat> findAllByIdIn(List<Long> showSeatIds);
    //if the showseat passed in a parameter doesn't have id
    //create a new row
    //else it update show seat with id new*
    ShowSeat save(ShowSeat showSeat);
}
