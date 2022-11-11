import java.io.File;
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors

public class Trump {
	public static void main(String[] args) {
		int n = 3;
		String[] speeches = new String[74];
		for (int i = 0; i < 10; i++) {
			speeches[i] = "../data/trump/data/speech_" + "0" + Integer.toString(i) + ".txt";
		}

		for (int i = 10; i < 74; i++) {
			speeches[i] = "../data/trump/data/speech_" + Integer.toString(i) + ".txt";
		}
		HMap chap = Bovary.buildTable(speeches, n);
		Bovary.generate(chap, n);
	}

	public static void main2(String[] args) {
		try {
			FileWriter fw = new FileWriter("src/aa.txt",true);
			fw.close();
			for (int i = 1; i < 10; i++) {
				fw = new FileWriter("../data/trump/data/speech_" + "0" + Integer.toString(i) + ".txt",true);
				fw.write(Prefix.end);
				fw.close();
			}

			for (int i = 10; i < 74; i++) {
				fw = new FileWriter("../data/trump/data/speech_" + Integer.toString(i) + ".txt",true);
				fw.write(" "+Prefix.end);
				fw.close();
			}
			System.out.println("end");
		} catch (IOException e) {
			System.out.println("fail");
		}
	}

	public static void create(String fichier) {
		try {
			File myObj = new File(fichier);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
