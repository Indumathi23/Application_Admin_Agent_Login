package Model;

public class AdminLogin {
	private String productId;
	private String productName;
	private int minSellQuantity;
	private int price;
	private int  quantity_available;
	int total_cost;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getMinSellQuantity() {
		return minSellQuantity;
	}
	public void setMinSellQuantity(int minSellQuantity) {
		this.minSellQuantity = minSellQuantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity_available() {
		return quantity_available;
	}
	public void setQuantity_available(int quantity_available) {
		this.quantity_available = quantity_available;
	}
	public int getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}
	
	public void display()
	{
		
	}

}
