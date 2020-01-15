package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

//import Model.ConnectionManager;


public class Add extends ConnectionManager implements Login{
	
	public boolean save(AdminLogin ad)
	{
		ConnectionManager.getConnection();
		String sql="insert into admin(productId,productName,minSellQuantity,price,total_cost)values(?,?,?,?,?)";
		
		PreparedStatement ps = null;
		try {
			ps = ConnectionManager.getConnection().prepareStatement(sql);
			ps.setString(1,ad.getProductId());
			ps.setString(2,ad.getProductName());
			ps.setInt(3,ad.getMinSellQuantity());
			ps.setInt(4,ad.getPrice());
			ps.setInt(5,ad.getTotal_cost());
			

			boolean resultset=ps.execute();
			
			if(resultset)
				return true;
			else
				return false;



		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<AdminLogin> displayAllProductsAddedByAdmin() {
			String sql="Select * from admin";
			List<AdminLogin> list=new LinkedList<AdminLogin>();
			PreparedStatement ps;
			try {
				ps = ConnectionManager.getConnection().prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
					
				{
					AdminLogin ad=new AdminLogin();
					ad.setProductId(rs.getString("productId"));
					ad.setProductName(rs.getString("productName"));
					ad.setMinSellQuantity(rs.getInt("minSellQuantity"));
					ad.setPrice(rs.getInt("price"));
					ad.setTotal_cost(rs.getInt("total_cost"));
					list.add(ad);
					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		return list;
		
	}

	@Override
	public boolean save(AgentLogin agent) {
		ConnectionManager.getConnection();
		String sql1="insert into agent(buy/sell,productId,productName,quantity,price,total_cost)values(?,?,?,?,?,?)";
		PreparedStatement ps1 = null;
		
		try {
			ps1 = ConnectionManager.getConnection().prepareStatement(sql1);
			ps1.setString(1,agent.getStr());
			ps1.setString(2,agent.getProductId());
			ps1.setString(3,agent.getProductName());
			ps1.setInt(4,agent.getQuantity_available());
			ps1.setInt(5,agent.getPrice());
			ps1.setInt(6,agent.getTotal());

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<AgentLogin> displayAllProductsAddedByAgent() {
		
		String sql1="Select * from agent";
		List<AgentLogin> list=new LinkedList<AgentLogin>();
		PreparedStatement ps1;
		
		try {
			ps1 = ConnectionManager.getConnection().prepareStatement(sql1);
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
				
			{
				AgentLogin agent=new AgentLogin();
				agent.setStr(rs.getString("Buy/Sell"));
				agent.setProductId(rs.getString("productId"));
				agent.setProductName(rs.getString("productName"));
				agent.setMinSellQuantity(rs.getInt("Quantity"));
				agent.setPrice(rs.getInt("price"));
				agent.setTotal_cost(rs.getInt("total"));
				//list.add(ad);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	
}
