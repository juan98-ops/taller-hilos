package run;

import java.io.FileNotFoundException;

import logic.*;
public class Runner {
	
	public static void main(String[] args) throws FileNotFoundException {
		CreateGraph gr = new CreateGraph();
		gr.createGraph("Rutas_aereas\\rutas.json");
	}
}
