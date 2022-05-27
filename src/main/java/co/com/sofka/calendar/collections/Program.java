package co.com.sofka.calendar.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Program {

    public static final Program DDD = new Program("2526", "Training No Bilingue",
            List.of(new CourseTime("005", "Domain Driven Design",List.of(new Time("01", 15, "Desarrollo",
                    List.of("http://www.domain.com.co"))))));
    public static final Program REACTIVA = new Program("2526", "Training No Bilingue",
            List.of(new CourseTime("008", "Programacion Reactiva",List.of(new Time("01", 8, "Desarrollo",
                    List.of("http://www.reactiva.com.co"))))));
    public static final Program PRUEBAS_UNI = new Program("2526", "Training No Bilingue",
            List.of(new CourseTime("010", "Pruebas Unitarias",List.of(new Time("01", 8, "Desarrollo",
                    List.of("http://www.unitarias.com.co"))))));

    @Id
    private String id;
    private String name;
    private List<CourseTime> courses;

    public Program() {

    }

    public Program(String id, String name, List<CourseTime> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseTime> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseTime> courses) {
        this.courses = courses;
    }
}
