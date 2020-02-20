import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;

public class World {

	int nrSlices;
	int types;
	int[] pizza = new int[100001];
	ArrayList<Integer> pizzas = new ArrayList<Integer>();

	void parse(String filename) {

		int bufferSize = 8 * 1024;

		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(filename), bufferSize);
			String line = bufferedReader.readLine();
			String[] l = line.split(" ");

			nrSlices = intValue(l[0]);
			types = intValue(l[1]);

			String line1 = bufferedReader.readLine();
			String[] l1 = line1.split(" ");

			for (int i = 0; i < types; i++) {
				pizza[i] = intValue(l1[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void simulate() {
		int[] indices = new int[types];

		for (int i = 0; i < types; i++) {
			indices[i] = i;
		}

		for (int i = 0; i < types - 1; i++) {
			int k = -1;
			for (int j = i + 1; j < types; j++) {

				if (pizza[i] < pizza[j]) {
					int aux = pizza[i];
					pizza[i] = pizza[j];
					pizza[j] = aux;
					int aux1 = indices[i];
					indices[i] = indices[j];
					indices[j] = aux1;
				}
			}
		}

		int score = 0;
		for (int i = 0; i < types; i++) {

			if (score + pizza[i] <= nrSlices) {
				score += pizza[i];
				pizzas.add(indices[i]);
			}
		}

	}

	void print(String filename) {

		PrintWriter writer = null;
		try {
			writer = new PrintWriter(filename, "UTF-8");

			writer.println(pizzas.size());

			for (int i = 0; i < pizzas.size(); i++) {
				writer.print(pizzas.get(i) + " ");
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static int intValue(String s) {
		return Integer.parseInt(s);
	}
}
