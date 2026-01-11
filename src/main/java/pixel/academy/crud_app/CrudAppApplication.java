package pixel.academy.crud_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app.dao.StudentDAO;
import pixel.academy.crud_app.entity.Student;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

    @Bean
    public CommandLineRunner comandLineRunner (StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);

            createMultipleStudents(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {

        // create a Student object
        System.out.println("Creating new student object ...");
        Student newStudent = new Student("Ion", "Schimbator", "ionschimbator98@gmail.com");

        // save the Student object in the database using DAO
        System.out.println("Saving the student ...");
        studentDAO.save(newStudent);

        // display the saved student ID
        System.out.println("Saved student. Generated id:" + newStudent.getId());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        // create a Student objects
        System.out.println("Creating 3 student objects ...");
        Student newStudent1 = new Student("Sandu", "Cotorobai", "sandu@gmail.com");
        Student newStudent2 = new Student("Mihai", "Mihalici", "mihai@gmail.com");
        Student newStudent3 = new Student("Maria", "Miarbela", "maria@gmail.com");

        // save the Student objects in the database
        System.out.println("Saving the students ...");
        studentDAO.save(newStudent1);
        studentDAO.save(newStudent2);
        studentDAO.save(newStudent3);

    }
}
