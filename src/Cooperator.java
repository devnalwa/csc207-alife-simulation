import java.util.Random;

public class Cooperator extends Organism{
    
    public Cooperator() {    }
    
    String getType() {
        return "Cooperator";
    }

    Organism reproduce() {
    	//mutation
//    	Random rnd = new Random();
//    	if(rnd.nextInt(100) < 5) {
//    		if(rnd.nextBoolean() == true) {
//    			return new Defector();
//    		} else {
//    			return new PartialCooperator();
//    		}
//    	}
    	//end of mutation
        return new Cooperator();
    }

    double getCooperationProbability() {
        return 1.0;
    }

    boolean cooperates() {
        if(this.energy == 0) {
            return false;
        } else {
            return true;
        }
    }
}
