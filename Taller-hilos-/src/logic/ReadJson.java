package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Source;
import modelo.Target;

public class ReadJson {
	
	public ArrayList<Source> read( String relativePath) {
		Gson gson = new Gson();
		String fichero = "";
		try (BufferedReader br = new BufferedReader(new FileReader(relativePath))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				fichero += linea;
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		Source [] city = gson.fromJson(fichero, Source[].class);	
		ArrayList<Source> sources = new ArrayList<Source>();
		for (int i = 0; i < city.length; i++) {
			if (city[i]!=null) {
				sources.add(city[i]);			
			}
		}
		for (int i = 0; i < sources.size(); i++) {
			for (int j = 0; j < sources.get(i).getTargets().size(); j++) {
				if (sources.get(i).getTargets().get(j) == null) {
					sources.get(i).getTargets().remove(j);
				}
			}
		}
		try {
			int conts=0;
			for (Source source : sources) {
				int contT = 0;
				for (Target target : source.getTargets()) {
					if (target == null) {
						System.out.println("Encontro un null en " +conts + " " +contT );
//						source.getTargets().remove(target);		
					}
					contT++;
				}
				conts++;
			}
		} catch (Exception e) {
			System.err.println("Nulo No eliminado ");
		}
		
		return sources;
	}
}
