package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;

class SalarieAideADomicileTest {

    @Test
    void testALegalementDroitADesCongesPayesFalse() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();

        // When & Then
        salarie.setJoursTravaillesAnneeNMoins1(9);
        assertFalse(salarie.aLegalementDroitADesCongesPayes());
        salarie.setJoursTravaillesAnneeNMoins1(10);
        assertFalse(salarie.aLegalementDroitADesCongesPayes());
    }

    @Test
    void testALegalementDroitADesCongesPayesTrue() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();

        // When & Then
        salarie.setJoursTravaillesAnneeNMoins1(11);
        assertTrue(salarie.aLegalementDroitADesCongesPayes());
    }

    @Test
    void testUnitaireCalculeJoursDeCongeDecomptesPourPlage() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        // When
        LinkedHashSet<LocalDate>  res = s.calculeJoursDeCongeDecomptesPourPlage(LocalDate.parse("2022-11-01"), LocalDate.parse("2022-11-01"));
        // Then
        Assertions.assertNotNull(res);
        //Assertions.assertTrue(res.isEmpty());
        Assertions.assertEquals(0, res.size());
    }

    @ParameterizedTest(name = "pour plage {0}-{1}, décompté : {2}")
    @CsvSource({
            "'2024-10-30', '2024-10-30', 1",
            "'2024-10-30', '2024-10-31', 2"
    })
    void testParametreCalculeJoursDeCongeDecomptesPourPlage(String dateDebutString, String dateFinString, int count) {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        // When
        LinkedHashSet<LocalDate> nbJoursDansPlage = s.calculeJoursDeCongeDecomptesPourPlage(LocalDate.parse(dateDebutString), LocalDate.parse(dateFinString));
        // Then
        Assertions.assertNotNull(nbJoursDansPlage);
        //Assertions.assertTrue(res.isEmpty());
        Assertions.assertEquals(count, nbJoursDansPlage.size());
    }
}
