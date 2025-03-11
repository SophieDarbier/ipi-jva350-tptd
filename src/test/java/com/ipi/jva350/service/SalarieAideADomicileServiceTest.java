package com.ipi.jva350.service;

import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SalarieAideADomicileServiceTest {

    @Mock
    private SalarieAideADomicileRepository repositoryMock;

    private SalarieAideADomicileService service;

    @BeforeEach
    void setUp() {
        service = new SalarieAideADomicileService(repositoryMock);
    }

    @Test
    void testCalculeLimiteEntrepriseCongesPermis() {
        // Given
        LocalDate moisEnCours = LocalDate.of(2024, 6, 1);
        double congesPayesAcquisAnneeNMoins1 = 20;
        LocalDate moisDebutContrat = LocalDate.of(2019, 1, 1);
        LocalDate premierJourDeConge = LocalDate.of(2024, 7, 1);
        LocalDate dernierJourDeConge = LocalDate.of(2024, 7, 15);

        when(repositoryMock.partCongesPrisTotauxAnneeNMoins1()).thenReturn(0.5);

        // When
        long limiteConges = service.calculeLimiteEntrepriseCongesPermis(
                moisEnCours, congesPayesAcquisAnneeNMoins1, moisDebutContrat, premierJourDeConge, dernierJourDeConge
        );

        // Then
        assertEquals(18, limiteConges);
        verify(repositoryMock).partCongesPrisTotauxAnneeNMoins1();
    }
}

