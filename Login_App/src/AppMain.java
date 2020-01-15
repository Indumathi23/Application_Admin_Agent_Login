import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import Model.Add;
import Model.AdminLogin;
import Model.AgentLogin;
//import Model.ConnectionManager;
import Model.ConnectionManager;


public class AppMain extends ConnectionManager{

	public static void main(String[] args) throws SQLException{
		String productId;
		String productName;
		int minSellQuantity;
		int price;
		int  Quantity_available;
		//int price;
		int total_cost;
		String userId;
		String password;
		String confirmPassword="****";
		String str;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Admin Login\n2. Agent Login\n3. Exit");
		int n=sc.nextInt();
		switch(n)
		{
		case 1:
			
			productId=sc.next();
			productName=sc.next();
			minSellQuantity=sc.nextInt();
			price=sc.nextInt();
			AdminLogin ad=new AdminLogin();
			ad.setProductId(productId);
			ad.setProductName(productName);
			ad.setMinSellQuantity(minSellQuantity);
			ad.setPrice(price);
			total_cost=minSellQuantity*price;
			ad.setTotal_cost(total_cost);
			ad.display();
			Add add=new Add();
			ConnectionManager.getConnection();
			
			Add register=new Add();
			if(register.save(ad))
				System.out.println("Data inserted successfully");
			else
				System.out.println("Check your query");
			
			List<AdminLogin> list=register.displayAllProductsAddedByAdmin();
			for(AdminLogin ad1:list)
			{
				System.out.println("Product Id :"+ad1.getProductId());
				System.out.println("Product name :"+ad1.getProductName());
				System.out.println("Min selling quantity :"+ad1.getMinSellQuantity());
				System.out.println("Price :"+ad1.getPrice());
				System.out.println("Total cost :"+ad1.getTotal_cost());
			}
			break;
		case 2:
			userId=sc.next();
			password=sc.next();
			if(password.equals(confirmPassword))
			{
				AgentLogin agent=new AgentLogin();
				System.out.println("Enter the product id :");
				productId=sc.next();
				System.out.println("1.Buy\n2.Sell");
				int n1=sc.nextInt();
				if(n1==1)
				{
					str="Buy";
				}
				else if(n1==2)
				{
					str="Sell";
				}
				System.out.println("Enter the quntity needed");
				int quantity_available=sc.nextInt();
				Connection connection;
				connection= ConnectionManager.getConnection();
				Statement st =connection.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM admin WHERE productId =" + productId);
				int total = 0;
				int f=0;
				
				String name="";
				int qty=0;
				int p=0;
				Add register1=new Add();
				while(rs.next())
				{
					name = rs.getString("productName");
					qty = rs.getInt("minSellQuantity");
					p = rs.getInt("price");
					if(quantity_available<qty)
					{
						f=1;
						total=quantity_available*p;
					}
					else {
						f=0;
					}
				}
				if(f==1)
				{
				System.out.println("productId:" + productId +  "\nproductName: " + name + "\nminSellQuantity: " + qty + "\nprice: " + p);
				System.out.println("Total_cost: "+total);
				}
				else
					System.out.println("Product not available");
				

				List<AgentLogin> list1=register1.displayAllProductsAddedByAgent();
				for(AdminLogin ad1:list1)
				{
					System.out.println("Product Id :"+ad1.getProductId());
					System.out.println("Product name :"+ad1.getProductName());
					System.out.println("Min selling quantity :"+ad1.getMinSellQuantity());
					System.out.println("Price :"+ad1.getPrice());
					System.out.println("Total cost :"+ad1.getTotal_cost());
				}
			}
			break;
		case 3:
			System.exit(0);
		}
		
		
	}

}
