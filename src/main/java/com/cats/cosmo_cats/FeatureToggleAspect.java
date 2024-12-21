package com.cats.cosmo_cats;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FeatureToggleAspect {

    @Autowired
    private FeatureToggleService featureToggleService;

    @Before("@annotation(enableFeatureToggle)")  // Обробляємо методи з анотацією EnableFeatureToggle
    public void checkFeature(EnableFeatureToggle enableFeatureToggle) {
        String featureName = enableFeatureToggle.featureName();
        // Перевірка, чи активована відповідна фіча
        if (!featureToggleService.isFeatureEnabled(featureName)) {
            throw new FeatureNotAvailableException("Feature " + featureName + " is not available");
        }
    }
}
