package pixel.academy.crud_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app.dao.StudentDAO;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

    @Bean
    public CommandLineRunner comandLineRunner (StudentDAO studentDAO) {
        return runner -> {
            createStudent(studentDAO);
        };
    }

    private  void createStudent(StudentDAO studentDAO) {

    }

}
