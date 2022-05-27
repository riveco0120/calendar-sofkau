package co.com.sofka.calendar.services;

import co.com.sofka.calendar.collections.CourseTime;
import co.com.sofka.calendar.collections.Program;
import co.com.sofka.calendar.collections.Time;
import co.com.sofka.calendar.model.ProgramDate;
import co.com.sofka.calendar.repositories.ProgramRepository;
import co.com.sofka.calendar.repositories.ReactiveProgramRepository;
import com.google.gson.Gson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SchedulerServiceTest {

    SchedulerService workshop = new SchedulerService();
    ProgramRepository repository = new ReactiveProgramRepository();

    PrintStream originalConsole = System.out;

    @Nullable //null when not useful
    ByteArrayOutputStream logConsole;

    @AfterEach
    public void afterEach() {
        if (logConsole != null) {
            originalConsole.println(logConsole.toString());
            System.setOut(originalConsole);
            logConsole = null;
        }
    }

    @Test
        //TODO: modificar el test para que el act sea reactivo, usando stepverifier
    public void generateCalendar() {
        var programId = "2526";
        var startDate = LocalDate.of(2022, 1, 1);


        Flux<ProgramDate> flux = workshop.generateCalendar(programId,startDate);

        StepVerifier.create(flux).expectNextCount(1).expectComplete();

        Flux<String> json = Flux.just(getSnapResult());

        StepVerifier.create(json).expectNext(new Gson().toJson(flux)).expectComplete();

    }

    private String getSnapResult() {
        return "[{\"categoryName\":\"Desarrollo\",\"date\":{\"year\":2022,\"month\":1,\"day\":15}}]";
    }
    //}

    @Test
    void programNoFound() {
        var programId = "xxxx";
        var startDate = LocalDate.of(2022, 1, 1);

        Flux<ProgramDate> flux = workshop.generateCalendar(programId,startDate);

        StepVerifier.create(flux).expectError(RuntimeException.class);

        StepVerifier.create(flux).expectErrorMessage("El programa academnico no existe");



    }

/*
    //no tocar
    private Program getProgramDummy() {
        var program = new Program();
        program.setId("xxxx");
        program.setName("Programa 2022");
        program.setCourses(new ArrayList<>());
        var timesForCourse1 = new ArrayList<Time>();
        timesForCourse1.add(new Time("1", 2, "Principios", List.of()));
        timesForCourse1.add(new Time("2", 2, "Bases", List.of()));
        timesForCourse1.add(new Time("3", 4, "Fundamentos", List.of()));
        timesForCourse1.add(new Time("3", 5, "Fundamentos avazandos", List.of()));

        program.getCourses().add(new CourseTime("xxx-z", "Introducción", timesForCourse1));
        return program;
    }
/*
    //no tocar
    private String getSnapResult() {
        return "[{\"categoryName\":\"Principios\",\"date\":{\"year\":2022,\"month\":1,\"day\":3}},{\"categoryName\":\"Principios\",\"date\":{\"year\":2022,\"month\":1,\"day\":4}},{\"categoryName\":\"Bases\",\"date\":{\"year\":2022,\"month\":1,\"day\":5}},{\"categoryName\":\"Bases\",\"date\":{\"year\":2022,\"month\":1,\"day\":6}},{\"categoryName\":\"Fundamentos\",\"date\":{\"year\":2022,\"month\":1,\"day\":7}},{\"categoryName\":\"Fundamentos\",\"date\":{\"year\":2022,\"month\":1,\"day\":10}},{\"categoryName\":\"Fundamentos\",\"date\":{\"year\":2022,\"month\":1,\"day\":11}},{\"categoryName\":\"Fundamentos\",\"date\":{\"year\":2022,\"month\":1,\"day\":12}},{\"categoryName\":\"Fundamentos avazandos\",\"date\":{\"year\":2022,\"month\":1,\"day\":13}},{\"categoryName\":\"Fundamentos avazandos\",\"date\":{\"year\":2022,\"month\":1,\"day\":14}},{\"categoryName\":\"Fundamentos avazandos\",\"date\":{\"year\":2022,\"month\":1,\"day\":17}},{\"categoryName\":\"Fundamentos avazandos\",\"date\":{\"year\":2022,\"month\":1,\"day\":18}},{\"categoryName\":\"Fundamentos avazandos\",\"date\":{\"year\":2022,\"month\":1,\"day\":19}}]";
    }

*/
}