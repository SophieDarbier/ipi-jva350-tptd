package com.ipi.jva350.repository;

import com.ipi.jva350.model.SalarieAideADomicile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SalarieAideADomicileRepositoryTest {

    @Autowired
    private SalarieAideADomicileRepository repository;

    @Test
    public void testPartCongesPrisTotauxAnneeNMoins1() {
        // Given
        SalarieAideADomicile s1 = new SalarieAideADomicile();
        s1.setNom("Soso");
        s1.setCongesPayesPrisAnneeNMoins1(10);
        s1.setCongesPayesAcquisAnneeNMoins1(20);
        repository.save(s1);

        SalarieAideADomicile s2 = new SalarieAideADomicile();
        s2.setNom("Soso2");
        s2.setCongesPayesPrisAnneeNMoins1(5);
        s2.setCongesPayesAcquisAnneeNMoins1(10);
        repository.save(s2);

        // When
        Double resultat = repository.partCongesPrisTotauxAnneeNMoins1();

        // Then
        assertNotNull(resultat);
        assertEquals(0.5, resultat, 0.01);
    }
}
