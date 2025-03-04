package co.com.sofka.calendar;

import co.com.sofka.calendar.services.SchedulerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class CalendarApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger((CalendarApplication.class));
    public static void main(String[] args) {
        SpringApplication.run(CalendarApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SchedulerService prueba = new SchedulerService();
        //prueba.fluxPrueba();
        prueba.generateCalendar("2526", LocalDate.parse("2022-05-27"));
    }
}
