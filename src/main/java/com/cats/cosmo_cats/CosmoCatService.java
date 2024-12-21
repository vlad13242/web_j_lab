package com.cats.cosmo_cats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CosmoCatService {

    // Ін'єкція сервісу для перевірки флагів
    @Autowired
    private FeatureToggleService featureToggleService;

    // Метод для отримання космо-котиків, залежить від флага
    public String getCosmoCats() {
        // Перевірка через FeatureToggleService, чи увімкнено функціонал для космо-котиків
        if (featureToggleService.isCosmoCatsEnabled()) {
            // Якщо флаг активний, виконуємо логіку
            return "Cosmo Cats are here!";
        } else {
            // Якщо флаг вимкнений, кидаємо виключення
            throw new FeatureNotAvailableException("Feature cosmoCats is not available");
        }
    }
}
