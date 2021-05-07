
public class Node {
	String head;
	Node next;

	Node(String head, Node next) {
		this.head = head;
		this.next = next;
	}

	static int lengthRec(Node l) {
		if (l == null)
			return 0;
		return 1 + Node.lengthRec(l.next);
	}

	static int length(Node l) {
		int nextle = 0;
		for (Node cur = l; cur != null; cur = cur.next) {
			nextle += 1;
		}
		return nextle;
	}

	static String printNodes(Node l) {
		String chaine = "[";
		Node cur = l;
		if (l == null)
			return "[]";
		while (cur.next != null) {
			chaine += cur.head + ", ";
			cur = cur.next;
		}
		chaine += cur.head + "]";
		return chaine;
	}

	static void addLast(String s, Node l) {
		if (l == null) {
			l = new Node(s, null);
		} else {
			while (l.next != null)
				l = l.next;
			l.next = new Node(s, null);
		}
	}

	static Node copy(Node the) {
		if (the == null)
			return null;
		Node curs_copy = new Node(the.head, null);
		Node copied = curs_copy;
		for (Node curs = the.next; curs != null; curs = curs.next) {
			curs_copy.next = new Node(curs.head, null);
			curs_copy = curs_copy.next;
		}
		return copied;
	}

	static Node insert(String s, Node l) {
		if (l == null || l.head.compareTo(s) >= 0)
			return new Node(s, l);
		Node initialNode = l;
		Node toInsert = new Node(s, null);
		while (l.next != null && l.next.head.compareTo(s) < 0) {
			l = l.next;
		}
		toInsert.next = l.next;
		l.next = toInsert;
		return initialNode;
	}

	static Node insertionSort(Node l) {
		Node lSorted = null;
		for (Node curs = l; curs != null; curs = curs.next) {
			lSorted = Node.insert(curs.head, lSorted);
		}
		return lSorted;
	}

	static Node mergeSort(Node l1, Node l2) {
		Node lSorted = new Node("0", null);
		while (l1 != null || l2 != null) {
			if (l2 == null || (l1 != null && l1.head.compareTo(l2.head) <= 0)) {
				Node.addLast(l1.head, lSorted);
				l1 = l1.next;
			} else if (l1 == null || (l2 != null && l1.head.compareTo(l2.head) > 0)) {
				Node.addLast(l2.head, lSorted);
				l2 = l2.next;
			}
		}
		return lSorted.next;
	}

	static Node mergeSort(Node l) {
		Node copy = Node.copy(l);
		Node l2 = copy;
		Node l1 = copy;
		int n = Node.length(l);
		if (n == 0) {
			return null;
		}
		if (n == 1) {
			return l;
		}
		for (int i = 0; i < (int) n / 2 -1 ; i++) {
			copy = copy.next;
		}
		l2 = copy.next;
		copy.next = null;
		l1=Node.mergeSort(l1);
		l2=Node.mergeSort(l2);
		return Node.mergeSort(l1,l2);
	}

	public static void main(String[] args) {
		Node foobar = new Node("foo", new Node("bar", new Node("baz", null)));
		foobar=Node.mergeSort(foobar);
		System.out.println(Node.printNodes(foobar));
	}
}
