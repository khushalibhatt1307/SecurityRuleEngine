package SecurityRuleEngine;

public class DividendRule implements Rule {
	Equity equity;

	DividendRule(Equity equity) {
		this.equity = equity;
	}

	public boolean execute() {
		// rule that will accept security only when dividend is less than $100
		if (equity.getDividend() < 100) {
			return false;
		}
		
		return true;
	}
}
