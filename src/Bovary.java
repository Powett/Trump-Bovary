
public class Bovary {
	public static void main(String[] args) {
		String[] chapitres=new String[35];
		int n=(args.length==0)? 3 : Integer.parseInt(args[0]);
		for (int i=1;i<10;i++) {
			chapitres[i-1]="../data/bovary/"+"0"+Integer.toString(i)+".txt";
		}
		
		for (int i=10;i<36;i++) {
			chapitres[i-1]="../data/bovary/"+Integer.toString(i)+".txt";
		}
		HMap chap=buildTable(chapitres, n);
		generate(chap,n);
	}
	
static HMap buildTable(String[] files, int n) {
	HMap assoTab=new HMap();
	Prefix pf=new Prefix(n);
	for (int i=0;i<files.length;i++) {
		WordReader wr=new WordReader(files[i]);
		pf=new Prefix(n);
		for (String w = wr.read(); w != null; w = wr.read()) {
			assoTab.add(pf, w);
			pf=pf.addShift(w);
		    }
		assoTab.add(pf,Prefix.end);
	}
	return assoTab;
}
static void generate(HMap t, int n) {
	Prefix pf=new Prefix(n);
	new java.util.Random();
	String w="";
	WordList words=null;
	while (w!=Prefix.end) {
		words=t.find(pf);
		w=words.toArray()[(int) (Math.random()*words.length())];
		System.out.print( (w.equals(Prefix.end)) ? "\n":((w.equals(Prefix.par)) ? "\n": w+" "));
		pf=pf.addShift(w);
	}
}
}
