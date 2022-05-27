package co.com.sofka.calendar.repositories;

import co.com.sofka.calendar.collections.Program;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReactiveProgramRepository implements ProgramRepository<Program> {

    private final List<Program> programs;

    public ReactiveProgramRepository(Program... programs) {
        this.programs =new ArrayList<>(Arrays.asList(programs));
    }

    public ReactiveProgramRepository(){
        programs = new ArrayList<>(Arrays.asList(Program.DDD,Program.REACTIVA,Program.PRUEBAS_UNI));
    }

    @Override
    public Flux<Program> findbyId(String id) {

        Program program = programs.stream()
                .filter(item->item.getId().equals(id))
                .findFirst().orElseThrow(
                        ()->new IllegalArgumentException("El programa academnico no existe"));
        return Flux.just(program);
    }
}
