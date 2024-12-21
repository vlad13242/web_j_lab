package com.cats.cosmo_cats;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FeatureToggleService {

    @Value("${feature.cosmoCats.enabled}")
    private boolean isCosmoCatsEnabled;

    @Value("${feature.kittyProducts.enabled}")
    private boolean isKittyProductsEnabled;

    public boolean isCosmoCatsEnabled() {
        return isCosmoCatsEnabled;
    }

    public boolean isKittyProductsEnabled() {
        return isKittyProductsEnabled;
    }

    // Додаємо загальний метод для перевірки фіч
    public boolean isFeatureEnabled(String featureName) {
        if ("cosmoCats".equals(featureName)) {
            return isCosmoCatsEnabled;
        } else if ("kittyProducts".equals(featureName)) {
            return isKittyProductsEnabled;
        }
        return false;  // Якщо фіча не знайдена, повертаємо false
    }
}
