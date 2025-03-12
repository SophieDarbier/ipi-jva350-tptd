package com.ipi.jva350.service;

import com.ipi.jva350.model.SalarieAideADomicile;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SalarieAideADomicileServiceTestIT {

    @Autowired
    private SalarieAideADomicileService service;

    @Autowired
    private SalarieAideADomicileRepository repository;

    @Test
    void testCalculeLimiteEntrepriseCongesPermis_Integration() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setNom("Alice");
        salarie.setCongesPayesPrisAnneeNMoins1(10);
        salarie.setCongesPayesAcquisAnneeNMoins1(20);
        repository.save(salarie);

        LocalDate moisEnCours = LocalDate.of(2024, 6, 1);
        double congesPayesAcquisAnneeNMoins1 = 20;
        LocalDate moisDebutContrat = LocalDate.of(2019, 1, 1);
        LocalDate premierJourDeConge = LocalDate.of(2024, 7, 1);
        LocalDate dernierJourDeConge = LocalDate.of(2024, 7, 15);

        // When
        long limiteConges = service.calculeLimiteEntrepriseCongesPermis(
                moisEnCours, congesPayesAcquisAnneeNMoins1, moisDebutContrat, premierJourDeConge, dernierJourDeConge
        );

        // Then
        assertTrue(limiteConges > 0);
    }
}
