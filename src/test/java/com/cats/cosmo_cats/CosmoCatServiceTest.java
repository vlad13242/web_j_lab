package com.cats.cosmo_cats;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)  // Використовуємо Mockito для ініціалізації моків
class CosmoCatServiceTest {

    @Mock
    private FeatureToggleService featureToggleService; // Мок для FeatureToggleService

    @InjectMocks
    private CosmoCatService cosmoCatService; // Ін'єкція моків у CosmoCatService

    @BeforeEach
    public void setUp() {
        // Ініціалізація моків перед кожним тестом
        // Всі моки будуть ініціалізовані через @Mock і @InjectMocks
    }

    @Test
    public void testGetCosmoCats_WhenFeatureEnabled() {
        // Імітуємо, що флаг для космо-котиків увімкнений
        when(featureToggleService.isCosmoCatsEnabled()).thenReturn(true);

        // Викликаємо метод CosmoCatService
        String result = cosmoCatService.getCosmoCats();

        // Перевірка результату
        assertEquals("Cosmo Cats are here!", result);
    }

    @Test
    public void testGetCosmoCats_WhenFeatureDisabled() {
        // Імітуємо, що флаг для космо-котиків вимкнений
        when(featureToggleService.isCosmoCatsEnabled()).thenReturn(false);

        // Перевірка, що викликається виключення, коли флаг вимкнений
        Exception exception = assertThrows(FeatureNotAvailableException.class, () -> {
            cosmoCatService.getCosmoCats();
        });

        // Перевірка повідомлення виключення
        assertEquals("Feature cosmoCats is not available", exception.getMessage());
    }
}
