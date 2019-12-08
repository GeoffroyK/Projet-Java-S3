package test2projet;

public class Saving {
	private Informations i;
	private Compare c;
	private boolean equalSign;
	private boolean equalMime;
	public Saving(Informations i, Compare c) {
		this.i = i;
		this.c = c;
		this.equalSign = c.isEqualSign();
		this.equalMime = c.isEqualMime();
	}
	public Informations getI() {
		return i;
	}
	public Compare getC() {
		return c;
	}
	public boolean isEqualSign() {
		return equalSign;
	}
	public boolean isEqualMime() {
		return equalMime;
	}
	
}