package modelo;

public class Edge {
	private double distance;
	private double value;
	private String idName;
	public Edge(double distance, double value, String idName) {
		super();
		this.distance = distance;
		this.value = value;
		this.idName = idName;
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
	public String getIdName() {
		return idName;
	}
	public void setIdName(String idName) {
		this.idName = idName;
	}
	@Override
	public String toString() {
		return idName;
	}
	
}
