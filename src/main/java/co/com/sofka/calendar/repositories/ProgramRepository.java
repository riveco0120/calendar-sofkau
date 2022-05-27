package co.com.sofka.calendar.repositories;

import co.com.sofka.calendar.collections.Program;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProgramRepository <T> {

    Flux<T> findbyId(String id);


}