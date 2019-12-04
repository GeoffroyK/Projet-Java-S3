package project;

public class Compare {
	private String mimedata;
	private String mimeinput;
	private String signdata;
	private String signinput;
	
	
	public Compare(String mimedata, String mimeinput, String signdata, String signinput) {
		this.mimedata = mimedata;
		this.mimeinput = mimeinput;
		this.signdata = signdata;
		this.signinput = signinput;
	}
	
	
	public String getMimedata() {
		return mimedata;
	}
	
	public String getMimeinput() {
		return mimeinput;
	}
	
	public String getSigndata() {
		return signdata;
	}
	
	public String getSigninput() {
		return signinput;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	public boolean isEqualMime() {
		String m1 = getMimedata();
		String m2 = getMimeinput();
		return(m1.contentEquals(m2));
	}
	
	public boolean isEqualSign() {
		String s1 = getSigndata();
		String s2 = getSigninput();
		int pos = s1.indexOf(s2);
		if(pos >= 0) {
			return true;
		} 	
		return false;
	}
	
	public String toString() {
		if((isEqualMime() && (isEqualSign()))) {
			return "True";
		}
			return "False";
	}
}
