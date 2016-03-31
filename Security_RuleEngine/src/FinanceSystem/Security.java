package SecurityRuleEngine;

public class Security {

	private Issuer issuer;
	private String name;
	
	public Security(){
		
	}
	
	public Security(Issuer issuer){
		this.issuer = issuer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Issuer getIssuer() {
		return this.issuer;
	}
	
	public void setIssuer(Issuer issuer) {
		this.issuer = issuer;
	}
}

