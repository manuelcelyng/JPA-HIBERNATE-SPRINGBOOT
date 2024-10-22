package com.celyngcoding.jpa;

import com.celyngcoding.jpa.models.Author;
import com.celyngcoding.jpa.models.Video;
import com.celyngcoding.jpa.repositories.AuthorRepository;
import com.celyngcoding.jpa.repositories.VideoRepository;
import com.github.javafaker.Faker;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.annotation.RetentionPolicy;

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

			for(int i = 0 ; i < 50; i++){
				Faker faker =  new Faker();
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(20, 80))
						.email(faker.name().username() + "@celycoding.com")
						.build();
				repository.save(author);
			}



			var author = Author.builder()
					.id(1)
					.firstName("Manuel")
					.lastName("Cely")
					.age(24)
					.email("manuel@celycoding.com")
					.build();

			//repository.save(author);

			// Update Author a set a.age = 22 where a.id =  1
			//repository.updateAuthor(22, 1);
			repository.updateByNamedQuery(100,1);
		};
	}

}
