package co.com.sofka.calendar.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import static java.util.List.*;

@Document
public class Program {

   // {\"categoryName\":\"Principios\",\"date\":{\"year\":2022,\"month\":1,\"day\":3}},{\"categoryName\":\"Principios\",\"date\":{\"year\":2022,\"month\":1,\"day\":4}},{\"categoryName\":\"Bases\",\"date\":{\"year\":2022,\"month\":1,\"day\":5}},{\"categoryName\":\"Bases\",\"date\":{\"year\":2022,\"month\":1,\"day\":6}},{\"categoryName\":\"Fundamentos\",\"date\":{\"year\":2022,\"month\":1,\"day\":7}},{\"categoryName\":\"Fundamentos\",\"date\":{\"year\":2022,\"month\":1,\"day\":10}},{\"categoryName\":\"Fundamentos\",\"date\":{\"year\":2022,\"month\":1,\"day\":11}},{\"categoryName\":\"Fundamentos\",\"date\":{\"year\":2022,\"month\":1,\"day\":12}},{\"categoryName\":\"Fundamentos avazandos\",\"date\":{\"year\":2022,\"month\":1,\"day\":13}},{\"categoryName\":\"Fundamentos avazandos\",\"date\":{\"year\":2022,\"month\":1,\"day\":14}},{\"categoryName\":\"Fundamentos avazandos\",\"date\":{\"year\":2022,\"month\":1,\"day\":17}},{\"categoryName\":\"Fundamentos avazandos\",\"date\":{\"year\":2022,\"month\":1,\"day\":18}},{\"categoryName\":\"Fundamentos avazandos\",\"date\":{\"year\":2022,\"month\":1,\"day\":19}}]";
    public static final Program DDD = new Program("2526", "Training No Bilingue",
            of(new CourseTime("005", "Domain Driven Design", of(new Time("01", 15, "Desarrollo",
                    of("http://www.domain.com.co"))))));
    public static final Program REACTIVA = new Program("2526", "Training No Bilingue",
            of(new CourseTime("008", "Programacion Reactiva", of(new Time("01", 8, "Desarrollo",
                    of("http://www.reactiva.com.co"))))));
    public static final Program PRUEBAS_UNI = new Program("2526", "Training No Bilingue",
            of(new CourseTime("010", "Pruebas Unitarias", of(new Time("01", 8, "Desarrollo",
                    of("http://www.unitarias.com.co"))))));

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

    @Override
    public String toString() {
        return "Program{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }

    
}
