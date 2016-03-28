package SecurityRuleEngine;

public class IssuerRule implements Rule {
	Security security;

	IssuerRule(Security security) {
		this.security = security;
	}

	public boolean execute() {
		// rule which only accepts security that is issued by US government
		if ((security.getIssuer() instanceof Government) && (security.getIssuer().getName() == "US GOVERNMENT")) {
			return true;
		}
		return false;
	}

}