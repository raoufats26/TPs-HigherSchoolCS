package org.isi.tpspring;

import org.isi.tpspring.entities.Etudiant;
import org.isi.tpspring.entities.Formation;
import org.isi.tpspring.entities.repositories.EtudiantRep;
import org.isi.tpspring.entities.repositories.FormationRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class TpspringApplication implements CommandLineRunner {
	@Autowired
	private EtudiantRep etudiantRep;
	@Autowired
	private FormationRep formationRep1 ;

	public static void main(String[] args) {
		SpringApplication.run(TpspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Formation f1;
		Formation f2;
		f1 = formationRep1.save(new Formation(null,"intergiciel",null,null));
		f1 = formationRep1.save(new Formation(null,"IoT",null,null));

		etudiantRep.save(new Etudiant(null,"Ahmed", Date.valueOf("2003-01-03"),null,null,f1,null));
		etudiantRep.save(new Etudiant(null,"Ali", Date.valueOf("2004-06-07"),null,null,f1,null));
		etudiantRep.save(new Etudiant(null,"Abderraouf", Date.valueOf("2003-09-04"),null,null,f1,null));
	}
}
