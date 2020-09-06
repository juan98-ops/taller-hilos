package modelo;

public class Target {
	private String target;
	private double distance;
	private double value;
	
	public Target(String target, double distance, double value) {
		super();
		this.target = target;
		this.distance = distance;
		this.value = value;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Target [target=" + target + ", distance=" + distance + ", value=" + value + "]";
	}
	
	
}
