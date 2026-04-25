package org.example.homeWorks.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NightClubTest {
    private NightClubClass nightClubClass;

    @Mock
    BouncerClass bouncer;

    @BeforeEach
    void setUp() {
        nightClubClass = new NightClubClass(bouncer, 3);
    }

    @Test
    @DisplayName("Тестирование входа по пятницам")
    void shouldIncreaseVisitorsOnFridayTest() {
        when(bouncer.canEnter(true, false, 3, 0)).thenReturn(true);

        boolean result = nightClubClass.enter(true, false);

        assertTrue(result);
        assertEquals(1, nightClubClass.getAttendersQuantity());

        verify(bouncer).canEnter(true, false, 3, 0);

    }

    @Test
    @DisplayName("Тестирование выхода у посетителя без задолженностей")
    void shouldLetVisitorsExitTest() {


        when(bouncer.canEnter(true, false, 3, 0)).thenReturn(true);
        nightClubClass.enter(true, false);


        when(bouncer.letOut(false)).thenReturn(true);

        boolean result = nightClubClass.exit(false);

        assertTrue(result);
        assertEquals(0, nightClubClass.getAttendersQuantity());

        verify(bouncer).letOut(false);
    }

    @Test
    @DisplayName("Не выпускать посетителя с долгом")
    void shouldDetainWithDebtVisitorTest() {
        when(bouncer.canEnter(true, false, 3, 0)).thenReturn(true);
        nightClubClass.enter(true, false);

        when(bouncer.letOut(true)).thenReturn(false);

        boolean result = nightClubClass.exit(true);

        assertFalse(result);
        assertEquals(1, nightClubClass.getAttendersQuantity());

        verify(bouncer).letOut(true);

    }
}
