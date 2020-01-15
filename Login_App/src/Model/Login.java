package Model;

import java.util.List;

public interface Login {
	public boolean save(AdminLogin ad);
	public List<AdminLogin>displayAllProductsAddedByAdmin();
	public boolean save(AgentLogin agent);
	public List<AgentLogin>displayAllProductsAddedByAgent();
	
}
