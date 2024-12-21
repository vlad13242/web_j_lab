package com.cats.cosmo_cats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CosmoCatController {

    @Autowired
    private CosmoCatService cosmoCatService;

    @GetMapping("/api/cosmo-cats")
    public String getCosmoCats() {
        try {
            return cosmoCatService.getCosmoCats();
        } catch (FeatureNotAvailableException e) {
            throw e; // Перекидаємо виключення далі для глобального обробника
        }
    }
}
