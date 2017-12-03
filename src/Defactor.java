
public class Defactor extends Organism{

    public Defactor() {    }
    
    String getType() {
        return "Defactor";
    }

    Organism reproduce() {
        return new Defactor();
    }

    double getCooperationProbability() {
        return 0.0;
    }

    boolean cooperates() {
        return false;
    }
}
