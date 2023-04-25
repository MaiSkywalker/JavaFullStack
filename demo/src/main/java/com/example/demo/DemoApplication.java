package com.example.demo;
import com.example.demo.Dto.People;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Repository.IPeopleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private IPeopleRepository peopleRepository;

	@Override
	public void run(String...args) throws Exception {
		this.peopleRepository.save(new People("anakin", "skywalker",26, "nabo"));
		this.peopleRepository.save(new People("padmee", "skywalker",56, "12-45-8416"));
		this.peopleRepository.save(new People("obi wan", "kenobi",86, " abidik gubidik"));
	}

}
