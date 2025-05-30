package org.isi.msformation;
import org.isi.msformation.entities.Formation;
import org.isi.msformation.entities.repositories.FormationRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsFormationApplication implements CommandLineRunner {
    @Autowired
    private FormationRep formationRep1 ;

    public static void main(String[] args) {
        SpringApplication.run(MsFormationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Formation f1;
        Formation f2;
        f1 = formationRep1.save(new Formation(null,"intergiciel",12,null));
        f2 = formationRep1.save(new Formation(null,"IoT",12,null));
    }
}