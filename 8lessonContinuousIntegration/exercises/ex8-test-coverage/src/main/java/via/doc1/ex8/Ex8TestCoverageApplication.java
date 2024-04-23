package via.doc1.ex8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@RestController
public class Ex8TestCoverageApplication {

    @RequestMapping("/")
    public String index() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return "<body><h1>DevOps and Cloud</h1> " +
                "<h2>Dockerizing Spring Boot Backend Application.</h2>" +
                "<h2> " + currentDateTime.format(formatter) + " </h2>" +
                "<p>With Docker, we can containerize SEP4 back-end and front-end applications.</p></body>";
    }
    public static void main(String[] args) {
        SpringApplication.run(Ex8TestCoverageApplication.class, args);
    }

}
