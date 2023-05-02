package com.example.demo.Repositories;

import com.example.demo.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface showRepository extends JpaRepository<Show,Long> {
    Show findByIdEquals(Long id);
}
