package hw3;

import org.example.homeWorks.hw3.components.Desk;
import org.example.homeWorks.hw3.components.interfaces.DeskOption;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DeskMockitoTest {

    @Test
    void shouldCalculatePriceUsingMockedOption() {

        DeskOption mockOption = Mockito.mock(DeskOption.class);
        Mockito.when(mockOption.getPrice()).thenReturn(5000);

        Desk desk = Desk.builder()
                .addedPrice(1000)
                .option(mockOption)   // благодаря @Singular
                .build();

        int price = desk.calculateTotalPrice();

        assertEquals(6000, price);
        Mockito.verify(mockOption).getPrice(); // бонус
    }
}
