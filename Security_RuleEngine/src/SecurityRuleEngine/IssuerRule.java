package SecurityRuleEngine;

import FinanceSystem.Issuer;
import FinanceSystem.Security;

public class IssuerRule extends Rule {

	private Issuer issuer;
	
	public IssuerRule(Security security, Issuer issuer) {
		super(security);
		this.issuer = issuer;
	}

	public boolean execute() {
		// rule which only accepts security that is issued by given issuer
		if (security.getIssuer().getClass().equals(this.issuer.getClass()) &&
			security.getIssuer().getName().equals(this.issuer.getName())) {
			return true;
		}
		return false;
	}

}
