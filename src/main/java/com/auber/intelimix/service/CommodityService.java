package com.auber.intelimix.service;





import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.auber.intelimix.entity.Commodity;
import com.auber.intelimix.entity.PriceRecord;
import com.auber.intelimix.repository.CommodityRepository;

import jakarta.transaction.Transactional;

@Service
public class CommodityService {

    private final CommodityRepository commodityRepository;

    public CommodityService(CommodityRepository commodityRepository) {
        this.commodityRepository = commodityRepository;
    }

    public List<Commodity> getAllCommodities() {
        return commodityRepository.findAll();
    }

    @Transactional
    public void updatePrice(String symbol, BigDecimal price) {
        Commodity commodity = commodityRepository.findBySymbol(symbol)
                .orElseThrow(() -> new IllegalArgumentException("Commodity not found: " + symbol));

        PriceRecord record = new PriceRecord();
        record.setCommodity(commodity);
        record.setPrice(price);
        record.setTime(LocalDateTime.now());

        commodity.getPriceHistory().add(record);
        commodityRepository.save(commodity);
    }
}

