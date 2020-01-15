package Model;

public class AgentLogin extends AdminLogin{
	private int minSellQuantity;
	private int price;
	private int  quantity_available;
	private int total;
	private String str;
	
	public String getStr() {
		
		return str;
	}
	public void setStr(String str) {
		this.str = str;
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
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
