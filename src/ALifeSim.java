import java.util.HashMap;
import java.util.Map;

public class ALifeSim {
	
	public static void main(String args[]) {
		Map<String, Integer> counts = new HashMap<>();
		
//		String[] args = new String[4];
//		args[0] = "30";
//		args[1] = "10";
//		args[2] = "10";
//		args[3] = "0";
		
		counts.put("Cooperator", Integer.parseInt(args[1]));
		counts.put("Defector", Integer.parseInt(args[2]));
		counts.put("PartialCooperator", Integer.parseInt(args[3]));
		
		Population population = new Population(counts);
		for(int i = 0; i < Integer.parseInt(args[0]); i++) {
		    population.update();
		}
		
		Map<String, Integer> map = population.getPopulationCounts();
		
		System.out.println("After " + args[0] + " ticks:");
		System.out.println("Cooperators = " + map.get("Cooperator"));
		System.out.println("Defectors   = " + map.get("Defector"));
		System.out.println("Partial     = " + map.get("PartialCooperator"));
		System.out.println("Mean Cooperation Probability = " + population.calculateCooperationMean());
	}

}
