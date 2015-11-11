package domain;

// Generated 9 nov. 2015 19:47:09 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Orderline generated by hbm2java
 */
@Entity
@Table(name = "orderline", schema = "public")
@XmlRootElement	(name ="orderline")
public class Orderline implements java.io.Serializable {

	private OrderlineId id;
	private Product product;
	private Userorder userorder;
	private short quantity;

	public Orderline() {
	}

	public Orderline(OrderlineId id, Product product, Userorder userorder,
			short quantity) {
		this.id = id;
		this.product = product;
		this.userorder = userorder;
		this.quantity = quantity;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)),
			@AttributeOverride(name = "orderId", column = @Column(name = "order_id", nullable = false)) })
	public OrderlineId getId() {
		return this.id;
	}

	public void setId(OrderlineId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", nullable = false, insertable = false, updatable = false)
	public Userorder getUserorder() {
		return this.userorder;
	}

	public void setUserorder(Userorder userorder) {
		this.userorder = userorder;
	}

	@Column(name = "quantity", nullable = false)
	public short getQuantity() {
		return this.quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

}
