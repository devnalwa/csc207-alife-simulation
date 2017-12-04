import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class Population {
	ArrayList<ArrayList<Organism>> lst = new ArrayList<>();

	public Population(Map<String, Integer> counts) {
		ArrayList<Organism> organisms = new ArrayList<>();
		
		for (Entry<String, Integer> entry : counts.entrySet()) {
			
			if(!entry.getKey().equals("Cooperator") || !entry.getKey().equals("Defector") || !entry.getKey().equals("PartialCooperator")) {
				throw new IllegalArgumentException();
			}
			for(int i = 0; i < entry.getValue(); i++) {
				if(entry.getKey().equals("Cooperator")) {
					organisms.add(new Cooperator());
				} else if(entry.getKey().equals("Defector")) {
					organisms.add(new Defector());
				} else if(entry.getKey().equals("PartialCooperator")) {
					organisms.add(new PartialCooperator());
				}
			}
			
		}
		lst.add(organisms);

	}

	void update() {
		//ArrayList<Organism> newOrganisms = new ArrayList<>();
		ArrayList<Organism> lastOrganisms = (ArrayList<Organism>) lst.get(lst.size() - 1).clone();
		Random rnd = new Random();
		
		Iterator<Organism> itr1 = lastOrganisms.iterator();
		Iterator<Organism> itr2 = lastOrganisms.iterator();
		//ListIterator<Organism> itr3 = lastOrganisms.listIterator();
		
		//Update every Organism
		while(itr1.hasNext()) {
			itr1.next().update();
		}
		
		//Check if each Organism cooperates, and if so, the Organism loses one unit energy and eight random Organisms get one unit energy
		while(itr2.hasNext()) {
			Organism org = itr2.next();
			if(org.cooperates()) {
				org.decrementEnergy();
				for(int i = 0; i < 8; i++) {
					lastOrganisms.get(rnd.nextInt(lastOrganisms.size())).incrementEnergy();
				}
			}
		}
		
		//Check if each Organism reproduces, and if so, the reproduced Organism replaces random Organism
		for (int i = 0; i < lastOrganisms.size(); i++) {
			Organism org = lastOrganisms.get(i);
			if(org.getEnergy() >= 10) {
				Organism newOrg = org.reproduce();
				lastOrganisms.set(rnd.nextInt(lastOrganisms.size()), newOrg);
			}
		}
		
		lst.add(lastOrganisms);

	}

	double calculateCooperationMean() {
		double sum = 0;
		int size = 0;
		Iterator<ArrayList<Organism>> itr1 = lst.iterator();
		while(itr1.hasNext()) {
			ArrayList<Organism> lstOrganisms = itr1.next();
			Iterator<Organism> itr2 = lstOrganisms.iterator();
			while(itr2.hasNext()) {
				sum += itr2.next().getCooperationProbability();
			}
			size += lstOrganisms.size();
		}
		
		return sum / size;
	}

	Map<Organism, Integer> getPopulationCounts() {
		int cntCooperator = 0;
		int cntDefector = 0;
		int cntPartialCooperator = 0;
		
		Iterator<ArrayList<Organism>> itr1 = lst.iterator();
		
		while(itr1.hasNext()) {
			ArrayList<Organism> lstOrganisms = itr1.next();
			Iterator<Organism> itr2 = lstOrganisms.iterator();
			while(itr2.hasNext()) {
				Organism org = itr2.next();
				if(org.getType().equals("Cooperator")) {
					cntCooperator++;
				} else if(org.getType().equals("Defector")) {
					cntDefector++;
				} else if(org.getType().equals("PartialCooperator")) {
					cntPartialCooperator++;
				}
			}
		}
		
		Map<Organism, Integer> ret= new HashMap<>();
		ret.put(new Cooperator(), cntCooperator);
		ret.put(new Defector(), cntDefector);
		ret.put(new PartialCooperator(), cntPartialCooperator);
		return ret;
	}

}
