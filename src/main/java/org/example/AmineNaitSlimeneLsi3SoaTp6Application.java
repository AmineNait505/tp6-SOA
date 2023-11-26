package org.example;

import entities.Compte;
import entities.EtatCompte;
import entities.TypeCompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.CompteRepository;

@EnableJpaRepositories(basePackages = "repositories")
@EntityScan(basePackages = "entities")
@SpringBootApplication
public class AmineNaitSlimeneLsi3SoaTp6Application {

	public static void main(String[] args) {
		SpringApplication.run(AmineNaitSlimeneLsi3SoaTp6Application.class, args);
	}
	@Bean
	public CommandLineRunner start(CompteRepository compterep){
		return args -> {
			Compte compte1 = new Compte(null,1000.0, TypeCompte.EPARGNE, EtatCompte.ACTIVE);
			Compte compte2 = new Compte(null,1500.0, TypeCompte.EPARGNE, EtatCompte.ACTIVE);
			Compte compte3 = new Compte(null,2000.0, TypeCompte.COURANT, EtatCompte.ACTIVE);

			compterep.save(compte1);
			compterep.save(compte2);
			compterep.save(compte3);

			System.out.println("Comptes ajoutés avec succès!");

			// Afficher les soldes des comptes
			System.out.println("Soldes des comptes :");
			compterep.findAll().forEach(compte -> {
				System.out.println(compte.getId() + " - Type: " + compte.getType() +
						", Solde: " + compte.getSolde());
			});
		};
	}


}