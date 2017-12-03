
public class Cooperator extends Organism{
    
    public Cooperator() {    }

    @Override
    void update() {
        this.energy--;
    }
    
    String getType() {
        return "Cooperator";
    }

    Organism reproduce() {
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
