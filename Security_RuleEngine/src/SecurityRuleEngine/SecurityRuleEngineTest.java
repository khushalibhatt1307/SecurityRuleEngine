package SecurityRuleEngine;

import static org.junit.Assert.*;
import org.junit.Test;

public class SecurityRuleEngineTest {

	@Test
	public void testDividenRulePositive() {
		Equity equity = new Equity();
		equity.setDividend(100);
		RuleEngine ruleEngine = new RuleEngine(new DividendRule(equity));
		assertTrue(ruleEngine.processSecurity());
	}

	@Test
	public void testDividenRuleNegative() {
		Equity equity = new Equity();
		equity.setDividend(50);
		RuleEngine ruleEngine = new RuleEngine(new DividendRule(equity));
		assertFalse(ruleEngine.processSecurity());
	}

	@Test
	public void testIssuerRulePositive() {
		Issuer issuer = new Government("US GOVERNMENT");
		Equity equity = new Equity();
		equity.setIssuer(issuer);
		RuleEngine ruleEngine = new RuleEngine(new IssuerRule(equity));
		assertTrue(ruleEngine.processSecurity());
	}

	@Test
	public void testIssuerRuleNegative() {
		Issuer issuer = new Government("INDIAN GOVERNMENT");
		Equity equity = new Equity();
		equity.setIssuer(issuer);
		RuleEngine ruleEngine = new RuleEngine(new IssuerRule(equity));
		assertFalse(ruleEngine.processSecurity());
	}
	
	@Test
	public void testIssuerRuleNegative2() {
		Issuer issuer = new Corporation("Facebook Inc.");
		Equity equity = new Equity();
		equity.setIssuer(issuer);
		RuleEngine ruleEngine = new RuleEngine(new IssuerRule(equity));
		assertFalse(ruleEngine.processSecurity());
	}

}
