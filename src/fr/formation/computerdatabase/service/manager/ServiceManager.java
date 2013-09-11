package fr.formation.computerdatabase.service.manager;

import fr.formation.computerdatabase.service.GeneralService;
import fr.formation.computerdatabase.service.impl.GeneralServiceImpl;


public enum ServiceManager {
	
	INSTANCE;
	
private GeneralService generalService;
	
	private ServiceManager(){
		generalService = new GeneralServiceImpl();
	}
	
	public GeneralService getGeneralService(){
		return generalService;
	}

}
