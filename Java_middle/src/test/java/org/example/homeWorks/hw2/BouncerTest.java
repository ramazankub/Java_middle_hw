package org.example.homeWorks.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BouncerTest {
    @Test
    @DisplayName("Впускать в пятницу даже если одежда не подходит")
    void shouldAllowEnterOnFridayEvenIfClothesBad() {
        BouncerClass bouncer = new BouncerClass();

        boolean result = bouncer.canEnter(true, false, 3, 0);

        assertTrue(result);
    }

    @Test
    @DisplayName("Не впускать в неподходящей одежде не в пятничные дни")
    void shouldNotAllowEnterIfClothesBadAndNotFriday() {
        BouncerClass bouncer = new BouncerClass();

        boolean result = bouncer.canEnter(false, false, 3, 0);

        assertFalse(result);
    }

    @Test
    @DisplayName("Не пускать в полный клуб")
    void shouldNotAllowEnterIfClubFull() {
        BouncerClass bouncer = new BouncerClass();

        boolean result = bouncer.canEnter(true, true, 3, 3);

        assertFalse(result);
    }

    @Test
    @DisplayName("Выпустить посетителя если долга нет")
    void shouldAllowExitIfNoDebt() {
        BouncerClass bouncer = new BouncerClass();

        boolean result = bouncer.letOut(false);

        assertTrue(result);
    }
}
