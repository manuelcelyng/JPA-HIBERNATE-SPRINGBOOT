package com.celyngcoding.jpa;

import com.celyngcoding.jpa.models.Author;
import com.celyngcoding.jpa.models.Video;
import com.celyngcoding.jpa.repositories.AuthorRepository;
import com.celyngcoding.jpa.repositories.VideoRepository;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository,
			VideoRepository videoRepository
	) {
		return args -> {
			/*var author = Author.builder()
					.firstName("Manuel")
					.lastName("Cely")
					.a ge(24)
					.email("contact@manucelyng.com")
					.build();
			repository.save(author);
			 */

			var video = Video.builder()
					.name("abc")
					.length(5)
					.build();

			videoRepository.save(video);
		};
	}

}
