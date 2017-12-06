import java.util.Random;

public class Defector extends Organism{

    public Defector() {    }
    
    String getType() {
        return "Defector";
    }

    Organism reproduce() {
    	//mutation
//    	Random rnd = new Random();
//    	if(rnd.nextInt(100) < 5) {
//    		if(rnd.nextBoolean() == true) {
//    			return new Cooperator();
//    		} else {
//    			return new PartialCooperator();
//    		}
//    	}
    	//end of mutation
        return new Defector();
    }

    double getCooperationProbability() {
        return 0.0;
    }

    boolean cooperates() {
        return false;
    }
}
