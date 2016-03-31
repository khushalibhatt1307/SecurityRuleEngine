package SecurityRuleEngine;

import FinanceSystem.Security;

public abstract class Rule {
	
	protected Security security;

	public Rule(Security security) {
		this.security = security;
	}
	
	public abstract boolean execute();
}
