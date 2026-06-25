package com.auber.intelimix.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="price_records")
public class PriceRecord {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="commodity_id", nullable=false)
	private Commodity commodity;
	
	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal price;
	
	private LocalDateTime time;
	
	public PriceRecord() {
		
	}

	public PriceRecord(Long id, Commodity commodity, BigDecimal price, LocalDateTime time) {
		super();
		this.id = id;
		this.commodity = commodity;
		this.price = price;
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "PriceRecord [id=" + id + ", commodity=" + commodity + ", price=" + price + ", time=" + time + "]";
	}
	

}
