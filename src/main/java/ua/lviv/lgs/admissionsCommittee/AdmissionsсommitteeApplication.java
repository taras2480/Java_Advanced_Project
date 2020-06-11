package ua.lviv.lgs.admissionsCommittee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"ua.lviv.lgs.admissionsCommittee"})
public class AdmissionsсommitteeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmissionsсommitteeApplication.class, args);
	}

}
