package com.ipi.jva350.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
