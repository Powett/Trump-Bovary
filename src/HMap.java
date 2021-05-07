
public class HMap {
	EntryList[] t;
	int size;

	public HMap(int n) {
		size = 0;
		t = new EntryList[n];
	}

	public HMap() {
		size = 0;
		t = new EntryList[20];
	}

	WordList find(Prefix key) {
		EntryList entList = t[key.hashCode(t.length)];
		if (entList==null) {
			return null;
		}
		while (entList.next != null && !Prefix.eq(entList.head.key, key)) {
			entList = entList.next;
		}
		if (Prefix.eq(entList.head.key, key)) {
			return entList.head.value;
		}
		return null;
	}

	void addSimple(Prefix key, String[] w) {
		EntryList entList = t[key.hashCode(t.length)];
		if (entList == null) {
			size += 1;
			t[key.hashCode(t.length)] = new EntryList(new Entry(key, new WordList(w)), null);
		} else {
			while (entList.next != null && !Prefix.eq(entList.head.key, key)) {
				entList = entList.next;
			}
			if (Prefix.eq(entList.head.key, key)) {
				for (int i = 0; i < w.length; i++) {
					entList.head.value.addLast(w[i]);
				}
			} else {
				size += 1;
				entList.next = new EntryList(new Entry(key, new WordList(w)), null);
			}
		}
	}

	void add(Prefix key, String w) {
		addSimple(key, w);
		while (4 * this.size >= 3 * this.t.length) {
			rehash(2 * t.length);
		}
	}

	void addSimple(Prefix key, String w) {
		addSimple(key, new String[] { w });
	}

	void addSimple(Prefix key, WordList w) {
		addSimple(key, w.toArray());
	}

	void rehash(int n) {
		HMap h2 = new HMap(n);
		for (int i = 0; i < t.length; i++) {
			for (EntryList ent = t[i]; ent != null; ent = ent.next) {
				h2.addSimple(ent.head.key, ent.head.value);
			}
		}
		this.t = h2.t;
		this.size = h2.size;
	}
}
