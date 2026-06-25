package com.auber.intelimix.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auber.intelimix.entity.Commodity;

public interface CommodityRepository extends JpaRepository<Commodity, Long>{
	
	Optional<Commodity> findBySymbol(String symbol);
	List<Commodity> findByCategory(String category);
	

}
