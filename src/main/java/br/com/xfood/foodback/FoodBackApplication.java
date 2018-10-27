package br.com.xfood.foodback;

import br.com.xfood.foodback.model.County;
import br.com.xfood.foodback.model.People;
import br.com.xfood.foodback.model.enumerator.EnumState;
import br.com.xfood.foodback.repository.CountyRepository;
import br.com.xfood.foodback.repository.PeopleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class FoodBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodBackApplication.class, args);
    }

    @Bean
    CommandLineRunner init(PeopleRepository peopleRepository, CountyRepository countyRepository) {
        return args -> {
            initUsers(peopleRepository, countyRepository);
        };

    }

    private void initUsers(PeopleRepository peopleRepository, CountyRepository countyRepository) {
        People people = new People();
        people.setCompanyName("Papa leguas PitDog");
        people.setName("Papa Leguas");
        people.setCpfCnpj("12352365236125");
        people.setEmail("papaleguas@gmail.com");
        people.setStreet("Av. New York");
        people.setNumber("12A");
        people.setWhatsappNumber("62981818582");
        people.setZipCode("74000000");
        people.setObservation("NONE");
        County county = new County();
        county.setDescription("GOIANIA");
        county.setState(EnumState.GOIAS);
        countyRepository.save(county);

        people.setCounty(county);

        peopleRepository.save(people);
    }

}
