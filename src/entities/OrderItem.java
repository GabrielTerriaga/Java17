package entities;

public class OrderItem {

	private Integer quantity;
	private Double price;
	
	//associacao
	private Product product;
	
	//construtores
	public OrderItem() {
	}
	
	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	//get setters
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	//metodos
	public Double subTotal() {
		return price * quantity;
	}

	@Override
	public String toString() {
		return product.getName()
				+ ", "
				+ price
				+ ", Quantity: "
				+ quantity
				+ ", Subtotal: "
				+ subTotal();
	}	
}
