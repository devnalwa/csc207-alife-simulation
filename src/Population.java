import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class Population {
	ArrayList<Organism> organisms;

	public Population(Map<String, Integer> counts) {
		organisms = new ArrayList<>();

		//Iterate through counts and construct a list of organisms
		for (Entry<String, Integer> entry : counts.entrySet()) {

			//Check counts contains only the three organisms. Otherwise, throws IllegalArgumentException.
			if(!(entry.getKey().equals("Cooperator") || entry.getKey().equals("Defector") || entry.getKey().equals("PartialCooperator"))) {
				throw new IllegalArgumentException();
			}
			//Add getValue() organisms into the list.
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
	}

	void update() {
		Random rnd = new Random();

		Iterator<Organism> itr1 = organisms.iterator();
		Iterator<Organism> itr2 = organisms.iterator();

		//Update every Organism
		while(itr1.hasNext()) {
			itr1.next().update();
		}

		//Check if each Organism cooperates, and if so, the Organism loses one unit energy, and eight random Organisms get one unit energy
		while(itr2.hasNext()) {
			Organism org = itr2.next();
			if(org.cooperates()) {
				org.decrementEnergy();
				int thisOrgNum = organisms.indexOf(org);
				//If the number of organisms is less than 10, then every organism except for cooperating organism gets one energy.
				if(organisms.size() < 10) {
					for(int i = 0; i < organisms.size(); i++) {
						if(i != thisOrgNum) {
							organisms.get(i).incrementEnergy();
						}
					}
				} else {
					for(int i = 0; i < 8; i++) {
						//The cooperating organism does not increment energy.
						int rndNum = rnd.nextInt(organisms.size());
						//To make sure random number does not corresponds to the cooperating organism.
						while(thisOrgNum == rndNum) {
							rndNum = rnd.nextInt(organisms.size());
						}
						organisms.get(rnd.nextInt(organisms.size())).incrementEnergy();
					}
				}
			}
		}

		//Check if each Organism reproduces, and if so, the reproduced Organism replaces random Organism
		for (int i = 0; i < organisms.size(); i++) {
			Organism org = organisms.get(i);
			if(org.getEnergy() >= 10) {
				Organism newOrg = org.reproduce();
				int thisOrgNum = organisms.indexOf(org);
				int rndNum = rnd.nextInt(organisms.size());
				//To make sure random number does not corresponds to the reproducing organism.
				while(thisOrgNum == rndNum) {
					rndNum = rnd.nextInt(organisms.size());
				}
				organisms.set(rndNum, newOrg);
			}
		}
	}

	double calculateCooperationMean() {
		double sum = 0;
		int size = 0;
		Iterator<Organism> itr = organisms.iterator();
		while(itr.hasNext()) {
			sum += itr.next().getCooperationProbability();
		}
		size += organisms.size();

		return sum / size;
	}

	Map<String, Integer> getPopulationCounts() {
		int cntCooperator = 0;
		int cntDefector = 0;
		int cntPartialCooperator = 0;

		Iterator<Organism> itr = organisms.iterator();

		while(itr.hasNext()) {
			while(itr.hasNext()) {
				Organism org = itr.next();
				if(org.getType().equals("Cooperator")) {
					cntCooperator++;
				} else if(org.getType().equals("Defector")) {
					cntDefector++;
				} else if(org.getType().equals("PartialCooperator")) {
					cntPartialCooperator++;
				}
			}
		}

		Map<String, Integer> ret= new HashMap<>();
		ret.put("Cooperator", cntCooperator);
		ret.put("Defector", cntDefector);
		ret.put("PartialCooperator", cntPartialCooperator);
		return ret;
	}

}
