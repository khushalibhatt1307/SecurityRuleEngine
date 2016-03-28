package SecurityRuleEngine;

public class RuleEngine {
	private Rule rule;

	public RuleEngine(Rule rule) {
		this.rule = rule;
	}

	public boolean processSecurity() {
		return rule.execute();
	}
}
