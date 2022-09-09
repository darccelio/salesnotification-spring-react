package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SaleService {

    Page<Sale> findSales(String minDate, String maxDate, Pageable pageable);

}