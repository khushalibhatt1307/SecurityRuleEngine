package SecurityRuleEngine;

import FinanceSystem.Equity;
import FinanceSystem.Security;

public class DividendRule extends Rule {
	
	public DividendRule(Security security) {
		super(security);
	}

	public boolean execute() {
		// rule that will accept security only when dividend is less than $100
		if (((Equity)this.security).getDividend() < 100) {
			return false;
		}
		
		return true;
	}
}
