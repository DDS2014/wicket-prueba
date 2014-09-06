package main;

import domain.Materia;
import home.HomeMaterias;
import main.HomePage;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.uqbar.commons.utils.ApplicationContext;

@SuppressWarnings("all")
public class WicketApplication extends WebApplication {
  public Class<? extends Page> getHomePage() {
    return HomePage.class;
  }
  
  public void init() {
    super.init();
    ApplicationContext _instance = ApplicationContext.getInstance();
    HomeMaterias _homeMaterias = new HomeMaterias();
    _instance.<HomeMaterias>configureSingleton(Materia.class, _homeMaterias);
  }
}
