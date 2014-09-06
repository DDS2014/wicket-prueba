package main

import org.apache.wicket.protocol.http.WebApplication
import domain.Materia
import home.HomeMaterias
import org.uqbar.commons.utils.ApplicationContext

class WicketApplication extends WebApplication {
	
	override getHomePage() {
		return HomePage
	}
	
	override init() {
		super.init()
		ApplicationContext.instance.configureSingleton(Materia, new HomeMaterias)
	}
	
}