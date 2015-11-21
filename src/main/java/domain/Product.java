package domain;

// Generated 9 nov. 2015 19:47:09 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", schema = "public")
@XmlRootElement	(name ="product")
public class Product implements java.io.Serializable {

	private short productId;
	private ProductCategory productCategory;
	private double productPrice;
	private String productName;
	private int stockQuantity;
	private Set<Orderline> orderlines = new HashSet<Orderline>(0);

	public Product() {
	}

	public Product(short productId, ProductCategory productCategory,
			double productPrice, int stockQuantity, String productName) {
		this.productId = productId;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productName = productName;
		this.stockQuantity = stockQuantity;
	}

	public Product(short productId, ProductCategory productCategory,
			double productPrice, int stockQuantity, Set<Orderline> orderlines) {
		this.productId = productId;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.stockQuantity = stockQuantity;
		this.orderlines = orderlines;
	}

	@Id
	@Column(name = "product_id", unique = true, nullable = false)
	@SequenceGenerator(name="productIdSeq", sequenceName="public.product_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="productIdSeq")
	public short getProductId() {
		return this.productId;
	}

	public void setProductId(short productId) {
		this.productId = productId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", nullable = false)
	@XmlTransient
	public ProductCategory getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	@Column(name = "product_price", nullable = false, precision = 17, scale = 17)
	public double getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Column(name = "product_name", nullable = false, length = 50)
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "stock_quantity", nullable = false)
	public int getStockQuantity() {
		return this.stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
	public Set<Orderline> getOrderlines() {
		return this.orderlines;
	}

	public void setOrderlines(Set<Orderline> orderlines) {
		this.orderlines = orderlines;
	}

}
