import java.util.Random;

public class PartialCooperator extends Organism{

    public PartialCooperator() {    }
    
    String getType() {
        return "PartialCooperator";
    }

    Organism reproduce() {
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
