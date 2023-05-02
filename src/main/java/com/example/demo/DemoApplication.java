package com.example.demo;

import com.example.demo.Controller.TicketController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class DemoApplication implements CommandLineRunner {
    private TicketController ticketController;
    @Autowired
    public DemoApplication(TicketController ticketController){
        this.ticketController=ticketController;

    }

    public static void main(String[] args) {

         SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //HW
        //1.Create a movie
        //2.Create a city
        //3.Create a theater
        //4.Add auditorium to the theater(create theatre)
        //5.Create 50 seats in above auditorium
        //6.Create a show
        //showControlller.createShow(Long movieId, Date StartTime, 
    }
}
