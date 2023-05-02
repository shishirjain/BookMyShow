package com.example.demo.Repositories;

import com.example.demo.Models.Show;
import com.example.demo.Models.ShowSeat;
import com.example.demo.Models.ShowSeatType;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;

import java.util.List;
@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType,Long> {
     @Lock(LockModeType.PESSIMISTIC_WRITE)
     List<ShowSeatType> findAllByShowEquals(Show show);
}
