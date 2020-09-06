package modelo;

import java.util.ArrayList;

public class Source {
	private String source;
	private ArrayList<Target> targets;
	public Source(String source, ArrayList<Target> targets) {
		super();
		this.source = source;
		this.targets = targets;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public ArrayList<Target> getTargets() {
		return targets;
	}
	public void setTargets(ArrayList<Target> targets) {
		this.targets = targets;
	}
	
	@Override
	public String toString() {
		return "Source [source=" + source + "\n targets=" + targets + "]";
	}
	
	
	
}
