
public class Defector extends Organism{

    public Defector() {    }
    
    String getType() {
        return "Defector";
    }

    Organism reproduce() {
        return new Defector();
    }

    double getCooperationProbability() {
        return 0.0;
    }

    boolean cooperates() {
        return false;
    }
}
