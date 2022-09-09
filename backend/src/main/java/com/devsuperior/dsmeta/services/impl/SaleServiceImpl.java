package com.devsuperior.dsmeta.services.impl;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.devsuperior.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository repository;

    public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min, max;

        if(minDate.isBlank())
            min = today.minusDays(365);
        else
            min = LocalDate.parse(minDate);

        if(maxDate.isBlank())
            max = today;
        else
            max = LocalDate.parse(maxDate);

        return repository.findSales(min, max, pageable);
    }
}
