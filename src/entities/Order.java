package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	//Declarei uma constante por causa do formato da data
	//Assim nao preciso ficar instanciando o SimpleDateFormat
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private OrderStatus status;
	
	//associacao
	private Client client;
	private List<OrderItem> orderItens = new ArrayList<>();
	
	//construtores
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItem() {
		return orderItens;
	}
	
	//metodos
	public void addItem(OrderItem orderItem) {
		orderItens.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		orderItens.remove(orderItem);
	}
	
	public Double total() {
		double total = 0.0;
		for (OrderItem oI : orderItens) {
			total += oI.subTotal();
		}
		return total;
	}

	/*Usuando StringBuilder, nesse caso pode haver muitos comentarios e se utilizar apenas o
	toString vai ficar muito pesado na memória (String muito grande composto por outros String pequenos)
	*/
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n" );
		sb.append("Client: " + client + "\n");
		sb.append("Ordem itens: \n");
		//Precisa criar um ForEach para percorrer arrayList dos itens em lista
		for (OrderItem oI : orderItens) {
			sb.append(oI + "\n ");
		}
		sb.append("Total price: $");
		sb.append(String.format("%2.f", total()));
		return sb.toString();
	}
}