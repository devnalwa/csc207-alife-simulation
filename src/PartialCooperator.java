import java.util.Random;

public class PartialCooperator extends Organism{

    public PartialCooperator() {    }
    
    String getType() {
        return "PartialCooperator";
    }

    Organism reproduce() {
    	//mutation
    	Random rnd = new Random();
    	if(rnd.nextInt(100) < 5) {
    		if(rnd.nextBoolean() == true) {
    			return new Cooperator();
    		} else {
    			return new Defector();
    		}
    	}
    	//end of mutation
        return new PartialCooperator();
    }

    double getCooperationProbability() {
        return 0.5;
    }

    boolean cooperates() {
        Random rnd = new Random();
        return rnd.nextBoolean();
    }
}
