package co.ingeneo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shipments")
public class Shipment {

	@Id
	@Column(name = "guide_number", unique = true)
	private String guideNumber;

	@Column(name = "id_customer")
	private Integer idCustomer;

	@Column(name = "id_product")
	private Integer idProduct;

	@Column(name = "plate")
	private String plate;

	@Column(name = "id_fleet")
	private String idFleet;

	@Column(name = "id_seaport")
	private Integer idSeaport;

	@Column(name = "id_storage")
	private Integer idStorage;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "registration_date")
	private Date registrationDate;

	@Column(name = "delivery_date")
	private Date deliveryDate;

	@Column(name = "price")
	private Float price;

	@Column(name = "discount")
	private Float discount;

	public Shipment() {
	}

	public Shipment(String guideNumber, Integer idCustomer, Integer idProduct, String plate, String idFleet,
			Integer idSeaport, Integer idStorage, Integer quantity, Date registrationDate, Date deliveryDate,
			Float price, Float discount) {
		this.guideNumber = guideNumber;
		this.idCustomer = idCustomer;
		this.idProduct = idProduct;
		this.plate = plate;
		this.idFleet = idFleet;
		this.idSeaport = idSeaport;
		this.idStorage = idStorage;
		this.quantity = quantity;
		this.registrationDate = registrationDate;
		this.deliveryDate = deliveryDate;
		this.price = price;
		this.discount = discount;
	}

	public Shipment(Integer idCustomer, Integer idProduct, String plate, Integer idStorage, Integer quantity,
			String type) {
		if (type.equals("ground")) {
			this.idCustomer = idCustomer;
			this.idProduct = idProduct;
			this.plate = plate;
			this.idStorage = idStorage;
			this.quantity = quantity;
		} else {
			this.idCustomer = idCustomer;
			this.idProduct = idProduct;
			this.idFleet = plate;
			this.idSeaport = idStorage;
			this.quantity = quantity;
		}
	}

	public String getGuideNumber() {
		return guideNumber;
	}

	public void setGuideNumber(String guideNumber) {
		this.guideNumber = guideNumber;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getIdFleet() {
		return idFleet;
	}

	public void setIdFleet(String idFleet) {
		this.idFleet = idFleet;
	}

	public Integer getIdSeaport() {
		return idSeaport;
	}

	public void setIdSeaport(Integer idSeaport) {
		this.idSeaport = idSeaport;
	}

	public Integer getIdStorage() {
		return idStorage;
	}

	public void setIdStorage(Integer idStorage) {
		this.idStorage = idStorage;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

}
