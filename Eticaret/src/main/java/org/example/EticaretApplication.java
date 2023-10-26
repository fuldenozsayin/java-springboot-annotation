package org.example;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class EticaretApplication {
    public static void main(String[] args) {
        SpringApplication.run(EticaretApplication.class,args);
    }

    @Bean//Beani gördüğünde bu bir nesne, daha sonra constructerın da ihiyacı olacak ben onu IoC ye ekleyeyim der.
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
