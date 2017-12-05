import java.util.HashMap;
import java.util.Map;

public class ALifeSim {
	
	public static void main(String args1[]) {
		Map<String, Integer> counts = new HashMap<>();
		
		String[] args = new String[4];
		args[0] = "2";
		args[1] = "1";
		args[2] = "1";
		args[3] = "1";
		
		counts.put("Cooperator", Integer.parseInt(args[1]));
		counts.put("Defector", Integer.parseInt(args[2]));
		counts.put("PartialCooperator", Integer.parseInt(args[3]));
		
		Population population = new Population(counts);
		for(int i = 0; i < Integer.parseInt(args[0]); i++) {
		    population.update();
		}
		
		Map<String, Integer> map = population.getPopulationCounts();
		
		System.out.println("After " + args[1] + " ticks:");
		System.out.println("Cooperators = " + map.get("Cooperator"));
		System.out.println("Defectors   = " + map.get("Defector"));
		System.out.println("Partial     = " + map.get("PartialCooperator"));
		System.out.println("Mean Cooperation Probability = " + population.calculateCooperationMean());
	}

}
