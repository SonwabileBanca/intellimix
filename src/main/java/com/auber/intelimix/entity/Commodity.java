package com.auber.intelimix.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "commodities")
public class Commodity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String symbol;
	
	
	private String name;
	
	
	private String category;
	
	
	private String unitOfMeasure;
	
	@OneToMany(mappedBy = "commodity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PriceRecord> priceHistory;
	
	public Commodity() {
		
	}

	public Commodity(Long id, String symbol, String name, String category, String unitOfMeasure,
			List<PriceRecord> priceHistory) {
		super();
		this.id = id;
		this.symbol = symbol;
		this.name = name;
		this.category = category;
		this.unitOfMeasure = unitOfMeasure;
		this.priceHistory = priceHistory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public List<PriceRecord> getPriceHistory() {
		return priceHistory;
	}

	public void setPriceHistory(List<PriceRecord> priceHistory) {
		this.priceHistory = priceHistory;
	}

	@Override
	public String toString() {
		return "Commodity [id=" + id + ", symbol=" + symbol + ", name=" + name + ", category=" + category
				+ ", unitOfMeasure=" + unitOfMeasure + ", priceHistory=" + priceHistory + "]";
	}
	

}
