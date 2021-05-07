class Prefix {
	String[] t;

	final static String start = "<START>", end = "<END>", par = "<PAR>";

	Prefix(int n) {
		t = new String[n];
		for (int i = 0; i < n; i++) {
			t[i] = start;
		}
	}

	static boolean eq(Prefix p1, Prefix p2) {
		int n = p1.t.length;
		boolean equality = true;
		if (p2.t.length != n) {
			return false;
		}
		for (int i = 0; i < n; i++) {
			equality = equality && (p1.t[i].equals((p2.t[i])));
		}
		return equality;
	}

	Prefix addShift(String w) {
		int n = this.t.length;
		Prefix shifted = new Prefix(n);
		for (int i = 0; i < n - 1; i++) {
			shifted.t[i] = this.t[i + 1];
		}
		shifted.t[n - 1] = w;
		return shifted;
	}

	public int hashCode() {
		int h = 0;
		int n = this.t.length;
		for (int i = 0; i < n; i++) {
			h = 37 * h + t[i].hashCode();
		}
		return h;
	}

	int hashCode(int n) {
		int h = this.hashCode();
		h=h%n;
		if (h < 0) {
			h += n;
		}
		return h;
	}

}