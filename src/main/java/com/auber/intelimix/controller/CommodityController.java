package com.auber.intelimix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.auber.intelimix.service.CommodityService;
import com.auber.intelimix.repository.CommodityRepository;
import com.auber.intelimix.entity.Commodity;
import java.math.BigDecimal;

@Controller
public class CommodityController {
    
    private final CommodityService commodityService;
    private final CommodityRepository commodityRepository; // Added for direct CRUD
    
    public CommodityController(CommodityService commodityService, CommodityRepository commodityRepository) {
        this.commodityService = commodityService;
        this.commodityRepository = commodityRepository;
    }
    
    // READ: View Dashboard
    @GetMapping("/")
    public String viewDashboard(Model model) {
        model.addAttribute("commodities", commodityService.getAllCommodities());
        return "dashboard";
    }

    // UPDATE: Add/Append a historical price to an existing commodity
    @PostMapping("/update-price")
    public String handlePriceUpdate(@RequestParam String symbol, @RequestParam BigDecimal price) {
        commodityService.updatePrice(symbol, price);
        return "redirect:/";
    }

    // CREATE: Add a brand new commodity type to the basket
    @PostMapping("/commodity/create")
    public String createCommodity(@RequestParam String symbol, 
                                  @RequestParam String name, 
                                  @RequestParam String category, 
                                  @RequestParam String unitOfMeasure) {
        Commodity commodity = new Commodity();
        commodity.setSymbol(symbol.toUpperCase());
        commodity.setName(name);
        commodity.setCategory(category);
        commodity.setUnitOfMeasure(unitOfMeasure);
        
        commodityRepository.save(commodity); // Spring ORM executes INSERT
        return "redirect:/";
    }

    // DELETE: Remove a commodity and all its mapped prices completely
    @GetMapping("/commodity/delete/{id}")
    public String deleteCommodity(@PathVariable Long id) {
        commodityRepository.deleteById(id); // Spring ORM executes DELETE
        return "redirect:/";
    }
}

