package via.doc1.dockerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerDemoApplication {
	@RequestMapping("/")
	public String index() {
		return "<body><h1> Containerization and Orchestration</h1>" +
			"<h2> Dockerize and Deploy Spring Boot Backend Application.</h2>" +
		"<p>With docker, we can containerize SEP4 backend and frontend applications.</p>" +
		"<p›We can also deploy the applications to <b>Kubernetes Cluster</b>.</p>" +
			"</body>";
	}
	public static void main(String[] args) {
		SpringApplication.run(DockerDemoApplication.class, args);
	}
}
