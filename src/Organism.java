public abstract class Organism {
    int energy;
	
	public Organism() {
	    this.energy = 0;
	}
	
	void update() {
	    this.energy++;
	}
	
	int getEnergy() {
	    return this.energy;
	}
	
	void incrementEnergy() {
	    this.energy++;
	}
	
	void decrementEnergy() {
	    if(this.energy > 0) {
	        this.energy--;
	    }
	}
	
	abstract String getType();
	
	abstract Organism reproduce();
	
	abstract double getCooperationProbability();
	
	abstract boolean cooperates();

}
