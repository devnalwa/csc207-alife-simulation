import java.util.HashMap;
import java.util.Map;

public class ALifeSim {
	
	public void main(String args[]) {
		Map<String, Integer> counts = new HashMap<>();
		
		counts.put("Cooperator", Integer.parseInt(args[1]));
		counts.put("Defector", Integer.parseInt(args[2]));
		counts.put("Cooperator", Integer.parseInt(args[3]));
	}

}
