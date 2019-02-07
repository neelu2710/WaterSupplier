package com.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERDETAIL")
public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ORDER_DET_ID", length = 20)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderDetailId;
	@Column(name = "ORDER_ID", length = 20)
	private Orders orders;
	@Column(name = "PRODUCT_ID", length = 20)
	private Product product;
	@Column(name = "QUANTITY", length = 10)
	private int quantity;
	@Column(name = "PRICE_ID", length = 20)
	private Price price;
	@Column(name = "ORDER_TYPE_ID", length = 20)
	private OrderType orderType;

	public long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
