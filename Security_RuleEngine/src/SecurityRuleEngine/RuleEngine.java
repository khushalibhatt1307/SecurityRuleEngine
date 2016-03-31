package SecurityRuleEngine;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {

	private List<Rule> rules;

	public RuleEngine() {
		rules = new ArrayList<Rule>();
	}
	
	public void addRule(Rule rule) {
		rules.add(rule);
	}
	
	public boolean processAllRules() {
		boolean result = false;
		for(Rule rule : this.rules) {
			result = rule.execute();
			if(!result) { //if any rule fails, reject security
				return false;
			}
		}
		return result;
	}
}
