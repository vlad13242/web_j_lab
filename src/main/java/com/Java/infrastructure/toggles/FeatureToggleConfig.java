package com.Java.infrastructure.toggles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FeatureToggleConfig {

    @Value("${feature.crud-enabled:true}")
    private boolean crudEnabled;

    public boolean isCrudEnabled() {
        return crudEnabled;
    }
}
