package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import FinanceSystem.Bond;
import FinanceSystem.Corporation;
import FinanceSystem.Equity;
import FinanceSystem.Government;
import FinanceSystem.Issuer;
import SecurityRuleEngine.DividendRule;
import SecurityRuleEngine.IssuerRule;
import SecurityRuleEngine.RuleEngine;

public class SecurityRuleEngineTest {

	@Test
	public void testDividenRulePositive() {
		Equity equity = new Equity();
		equity.setDividend(100);
		RuleEngine ruleEngine = new RuleEngine();
		ruleEngine.addRule(new DividendRule(equity));
		assertTrue(ruleEngine.processAllRules());
	}

	@Test
	public void testDividenRuleNegative() {
		Equity equity = new Equity();
		equity.setDividend(50);
		RuleEngine ruleEngine = new RuleEngine();
		ruleEngine.addRule(new DividendRule(equity));
		assertFalse(ruleEngine.processAllRules());
	}

	@Test
	public void testIssuerRulePositive() {
		Issuer issuer = new Government("US GOVERNMENT");
		Equity equity = new Equity();
		equity.setIssuer(issuer);
		RuleEngine ruleEngine = new RuleEngine();
		ruleEngine.addRule(new IssuerRule(equity, issuer));
		assertTrue(ruleEngine.processAllRules());
	}

	@Test
	public void testIssuerRuleNegative() {
		Issuer issuer = new Government("INDIAN GOVERNMENT");
		Equity equity = new Equity();
		equity.setIssuer(issuer);
		
		Issuer issuer2 = new Government("US GOVERNMENT");

		RuleEngine ruleEngine = new RuleEngine();
		ruleEngine.addRule(new IssuerRule(equity, issuer2));
		assertFalse(ruleEngine.processAllRules());
	}
	
	@Test
	public void testIssuerRuleNegative2() {
		Issuer issuer = new Corporation("Facebook Inc.");
		Equity equity = new Equity();
		equity.setIssuer(issuer);
		
		Issuer issuer2 = new Corporation("Calypso");

		RuleEngine ruleEngine = new RuleEngine();
		ruleEngine.addRule(new IssuerRule(equity, issuer2));
		assertFalse(ruleEngine.processAllRules());
	}

	@Test
	public void testMultipleRulesSuccess() {
		Issuer issuer = new Government("US GOVERNMENT");
		Bond bond = new Bond();
		bond.setIssuer(issuer);
		
		Equity equity = new Equity();
		equity.setDividend(150);
		
		RuleEngine ruleEngine = new RuleEngine();
		ruleEngine.addRule(new IssuerRule(bond, issuer));
		ruleEngine.addRule(new DividendRule(equity));
		
		assertTrue(ruleEngine.processAllRules());
	}
	
	@Test
	public void testMultipleRulesFailure() {
		Issuer issuer = new Government("US GOVERNMENT");
		Bond bond = new Bond();
		bond.setIssuer(issuer);
		
		Issuer issuer2 = new Government("INDIAN GOVERNMENT");
		
		Equity equity = new Equity();
		equity.setDividend(50);
		
		RuleEngine ruleEngine = new RuleEngine();
		ruleEngine.addRule(new IssuerRule(bond, issuer2));
		ruleEngine.addRule(new DividendRule(equity));
		
		assertFalse(ruleEngine.processAllRules());
	}
	
	
}
