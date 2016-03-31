package FinanceSystem;

public class Equity extends Security {

	private float dividend;

	Equity(Issuer issuer) {
		super(issuer);
	}

	public Equity() {

	}

	public float getDividend() {
		return dividend;
	}

	public void setDividend(float dividend) {
		this.dividend = dividend;
	}

}
