package com.ipi.jva350.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class EntrepriseTest {

    @Test
    void testDateDansPlage() {
        // Given
        LocalDate date = LocalDate.of(2024, 6, 15);
        LocalDate debut = LocalDate.of(2024, 6, 10);
        LocalDate fin = LocalDate.of(2024, 6, 20);

        // When & Then
        assertTrue(Entreprise.estDansPlage(date, debut, fin));
    }

    @Test
    void testDateAvantPlage() {
        // Given
        LocalDate date = LocalDate.of(2024, 6, 5);
        LocalDate debut = LocalDate.of(2024, 6, 10);
        LocalDate fin = LocalDate.of(2024, 6, 20);

        // When & Then
        assertFalse(Entreprise.estDansPlage(date, debut, fin));
    }

    @Test
    void testDateApresPlage() {
        // Given
        LocalDate date = LocalDate.of(2024, 6, 25);
        LocalDate debut = LocalDate.of(2024, 6, 10);
        LocalDate fin = LocalDate.of(2024, 6, 20);

        // When & Then
        assertFalse(Entreprise.estDansPlage(date, debut, fin));
    }

    @Test
    void testDateEgaleDebut() {
        // Given
        LocalDate date = LocalDate.of(2024, 6, 10);
        LocalDate debut = LocalDate.of(2024, 6, 10);
        LocalDate fin = LocalDate.of(2024, 6, 20);

        // When & Then
        assertTrue(Entreprise.estDansPlage(date, debut, fin));
    }

    @Test
    void testDateEgaleFin() {
        // Given
        LocalDate date = LocalDate.of(2024, 6, 20);
        LocalDate debut = LocalDate.of(2024, 6, 10);
        LocalDate fin = LocalDate.of(2024, 6, 20);

        // When & Then
        assertTrue(Entreprise.estDansPlage(date, debut, fin));
    }

    @Test
    void testPlageInverse() {
        // Given
        LocalDate date = LocalDate.of(2024, 6, 15);
        LocalDate debut = LocalDate.of(2024, 6, 20);
        LocalDate fin = LocalDate.of(2024, 6, 10);

        // When & Then
        assertFalse(Entreprise.estDansPlage(date, debut, fin));
    }

    @Test
    void testNullValues() {
        // Given
        LocalDate date = LocalDate.of(2024, 6, 15);
        LocalDate debut = null;
        LocalDate fin = LocalDate.of(2024, 6, 20);

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> Entreprise.estDansPlage(date, debut, fin));
    }
}
