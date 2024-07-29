package dev.me.vaultdemo.customer.test;

import dev.me.vaultdemo.customer.Customer;
import dev.me.vaultdemo.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("staging")
public class DataTestStaging {

    @Bean
    CommandLineRunner dataTest(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(new Customer("John", "Doe", "staging"));
            customerRepository.save(new Customer("Jane", "Doe", "staging"));
            customerRepository.save(new Customer("Jack", "Doe", "staging"));
        };
    }

}
