
import java.util.List;

import gestionSalle.dao.*;
import gestionSalle.model.Salle;

public class App {

	public static void main(String[] args) {
		SalleDao salledao= new SalleDao();
		//List<Prof> profs= profdao.findcontainsById(1);
		//profs.forEach(prof-> System.out.println(prof.getCodeProf()+prof.getNomProf()));
		
		Salle salle= new Salle("Salle 001");
		salledao.saveSalle(salle);
	
		
		
		
	}

}
