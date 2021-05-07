
public class WordList {
	Node content;
	static WordList foobar = new WordList(new String[] { "foo", "bar", "baz" });

	WordList() {
		content = null;
	}

	WordList(String[] words) {
		int n = words.length;
		if (n >= 1) {
			content = new Node(words[0], null);
		}
		for (int i = 1; i < n; i++) {
			Node.addLast(words[i], content);
		}
	}

	int length() {
		return Node.length(content);
	}

	String print() {
		return Node.printNodes(content);
	}

	void addFirst(String w) {
		content = new Node(w, content);
	}

	void addLast(String w) {
		if (content == null) {
			content = new Node(w, null);
		} else {
			Node.addLast(w, this.content);
		}
	}

	String removeFirst() {
		String first;
		if (content == null) {
			return null;
		}
		first = content.head;
		content = content.next;
		return first;
	}

	String removeLast() {
		String last;
		Node curs = content;
		if (content == null) {
			return null;
		}
		if (content.next == null) {
			last = curs.head;
			content = null;
			return last;
		}
		while (curs.next.next != null) {
			curs = curs.next;
		}
		last = curs.next.head;
		curs.next = null;
		return last;

	}

	void insert(String s) {
		content = Node.insert(s, content);
	}

	void insertionSort() {
		content = Node.insertionSort(content);
	}

	void mergeSort() {
		content = Node.mergeSort(content);
	}

	String[] toArray() {
		int n = this.length();
		Node cur = content;
		String[] mots = new String[n];
		for (int i = 0; i < n; i++) {
			mots[i] = cur.head;
			cur = cur.next;
		}
		return mots;
	}

	public static void main(String[] args) {
		WordList goo = new WordList();
		goo.removeLast();
		System.out.println(goo.print());
	}
}
