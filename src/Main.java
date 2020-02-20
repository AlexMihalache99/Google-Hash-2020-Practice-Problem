
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] inputs = { "a_example", "b_small", "c_medium", "d_quite_big", "e_also_big" };

		for (String in : inputs) {
			World world = new World();
			world.parse(in + ".in");
			world.simulate();
			world.print(in + ".out");
		}

	}
}
