package com.ipi.jva350.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    // TESTS UNITAIRES de la méthode Entreprise.estJourFerie() + Entreprise.proportionPondereeDuMois() + Entreprise.getPremierJourAnneeDeConges()

    @ParameterizedTest(name = "{0} est un jour férié : {1}")
    @CsvSource({
            "2024-01-01, true",
            "2024-05-01, true",
            "2024-07-14, true",
            "2024-12-25, true",
            "2024-06-15, false"
    })
    void testEstJourFerie(String dateString, boolean expected) {
        // Given
        LocalDate date = LocalDate.parse(dateString);

        // When & Then
        assertEquals(expected, Entreprise.estJourFerie(date));
    }

    @ParameterizedTest(name = "Proportion pondérée pour {0} : {1}")
    @CsvSource({
            "2024-01-01, 0.08",
            "2024-06-01, 0.64",
            "2024-12-01, 1.0"
    })
    void testProportionPondereeDuMois(String dateString, double expected) {
        // Given
        LocalDate date = LocalDate.parse(dateString);

        // When & Then
        assertEquals(expected, Entreprise.proportionPondereeDuMois(date), 0.01);
    }

    @ParameterizedTest(name = "Premier jour année congés pour {0} : {1}")
    @CsvSource({
            "2024-07-01, 2024-06-01",
            "2024-05-01, 2023-06-01"
    })
    void testGetPremierJourAnneeDeConges(String inputDate, String expectedDate) {
        // Given
        LocalDate date = LocalDate.parse(inputDate);
        LocalDate expected = LocalDate.parse(expectedDate);

        // When & Then
        assertEquals(expected, Entreprise.getPremierJourAnneeDeConges(date));
    }
}
