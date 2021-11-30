package com.trummy.userservice.sampledata;

import com.github.javafaker.Faker;
import com.trummy.userservice.dao.User;
import com.trummy.userservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private UserRepository userRepository;
    private Faker faker;

    public SampleDataLoader(UserRepository userRepository, Faker faker) {
        this.userRepository = userRepository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {

        List<User> userList = IntStream.rangeClosed(1, 20)
                .mapToObj(i -> new User(
                        faker.name().username(),
                        faker.beer().name()
                )).collect(Collectors.toList());

        userRepository.saveAll(userList);
    }
}
