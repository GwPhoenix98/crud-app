package pixel.academy.crud_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app.dao.StudentDAO;
import pixel.academy.crud_app.entity.Student;

import java.util.List;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

    @Bean
    public CommandLineRunner comandLineRunner (StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);

            queryForStudentsByLastName(studentDAO);
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

    private void readStudent(StudentDAO studentDAO) {

        // creates a Student object
        System.out.println("Creating new student object ...");
        Student newStudent = new Student("Mircea", "Popescu", "mirceaap@pixel.academy");

        // save the student in the database
        System.out.println("Saved the student ...");
        studentDAO.save(newStudent);

        // displays the saved student ID
        int theID = newStudent.getId();
        System.out.println("Saved student. Generated id: " + theID);

        // retrieve student based on ID
        System.out.println("Retrieving student with id: " + theID);
        Student myStudent = studentDAO.findById(theID);

        // display student details
        System.out.println("Found the student: " + myStudent);

    }

    private void queryForStudents(StudentDAO studentDAO) {

        // get the list of students
        List<Student> theStudents = studentDAO.findALL();

        // display the list of students
        for (Student newStudent : theStudents) {
            System.out.println(newStudent);
        }
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        // return list of students
        List<Student> theStudent = studentDAO.findByLastName("Schimbator");

        // display list of students
        for(Student newStudent : theStudent) {
            System.out.println(newStudent);
        }
    }
}
