package co.ingeneo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "id_product")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idProduct;

	@Column(name = "type")
	private String type;

	@Column(name = "name")
	private String name;

	@Column(name = "delivery_days")
	private Integer deliveryDays;

	@Column(name = "shipping_price")
	private Float shippingPrice;

	public Product() {
	}

	public Product(Integer idProduct, String type, String name, Integer deliveryDays, Float shippingPrice) {
		this.idProduct = idProduct;
		this.type = type;
		this.name = name;
		this.deliveryDays = deliveryDays;
		this.shippingPrice = shippingPrice;
	}
	
	public Product(String type, String name, Integer deliveryDays, Float shippingPrice) {
		this.type = type;
		this.name = name;
		this.deliveryDays = deliveryDays;
		this.shippingPrice = shippingPrice;
	}	

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDeliveryDays() {
		return deliveryDays;
	}

	public void setDeliveryDays(Integer deliveryDays) {
		this.deliveryDays = deliveryDays;
	}

	public Float getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(Float shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

}
