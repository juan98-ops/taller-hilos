package logic;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.samples.SimpleGraphDraw;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.GraphMousePlugin;
import edu.uci.ics.jung.visualization.control.PluggableGraphMouse;
import edu.uci.ics.jung.visualization.control.ScalingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.TranslatingGraphMousePlugin;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import modelo.Edge;
import modelo.Source;
import modelo.Target;

public class CreateGraph {
	ArrayList<Source> sources;;
	private Graph<String, Edge> g;



	public Graph<String, Edge> createGraph(String relativePath) {
		ReadJson read = new ReadJson();	
		sources = read.read(relativePath);
		g = new SparseMultigraph<String, Edge>();
		addVertex();
		addEdges();
//		frme();
		return g;
	}


	private void addVertex() {
		for (Source source : sources) {
			g.addVertex(source.getSource());
		}
	}

	private void addEdges() {
		try {
			for (Source source : sources) {
				int cont = 0;				
				for (Target target : source.getTargets()) {
					cont++;			
					if (g.containsEdge(g.findEdge( target.getTarget(),source.getSource()))) {
						Edge e = g.findEdge( target.getTarget(),source.getSource());
						if (e.getDistance()==target.getDistance()&&e.getValue()==target.getValue()) {
							g.removeEdge(g.findEdge( target.getTarget(),source.getSource()));
							g.addEdge(new Edge(target.getDistance(), target.getValue(), (source.getSource()+target.getTarget())), source.getSource(),target.getTarget(), EdgeType.UNDIRECTED);
						}else {
							g.addEdge(new Edge(target.getDistance(), target.getValue(), (source.getSource()+target.getTarget())), source.getSource(),target.getTarget(), EdgeType.DIRECTED);
						
						}
						
					}else {
						g.addEdge(new Edge(target.getDistance(), target.getValue(), (source.getSource()+target.getTarget())), source.getSource(),target.getTarget(), EdgeType.DIRECTED);
					}
				}
			}
		} catch (Exception e) {
			System.err.print("Recorrido De Grafo No completado");
		}
	}
	/*
	public void frme() {
		SimpleGraphDraw  sgv1 = new SimpleGraphDraw();
		Layout<String, Edge> layout1 = new CircleLayout<String, Edge>(g);

		layout1.setSize(new Dimension(300,300));
		VisualizationViewer<String, Edge> vv1 =
				new VisualizationViewer<String, Edge>(layout1);
		vv1.setPreferredSize(new Dimension(350,350));
		// Show vertex and edge labels
		vv1.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vv1.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());


		PluggableGraphMouse gm1 = new PluggableGraphMouse();
		gm1.add((GraphMousePlugin) new TranslatingGraphMousePlugin(MouseEvent.BUTTON1_MASK));
		gm1.add(new ScalingGraphMousePlugin(new CrossoverScalingControl(), 0, 1.1f, 0.9f));

		vv1.setGraphMouse(gm1);
		JFrame frame1 = new JFrame("Facebook Grafo De amigos");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().add(vv1);
		frame1.pack();
		frame1.setVisible(true); 
	}*/
	
}
