package home;

import domain.Materia;
import domain.Nota;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class HomeMaterias extends CollectionBasedHome<Materia> {
  public HomeMaterias() {
    this.init();
  }
  
  public void init() {
    this.create("Matemática Discreta", 2012, "Pepe", Boolean.valueOf(true));
    this.create("Análisis Matemático I", 2013, "Juan", Boolean.valueOf(false));
    this.create("Álgebra", 2014, "Jose", Boolean.valueOf(true));
  }
  
  public void create(final String nombre, final int anioCursada, final String profesor, final Boolean finalAprobado) {
    Materia materia = new Materia();
    materia.setNombre(nombre);
    materia.setAnioCursada(anioCursada);
    materia.setProfesor(profesor);
    materia.setFinalAprobado(finalAprobado);
    this.create(materia);
  }
  
  public Predicate getCriterio(final Materia example) {
    return null;
  }
  
  public Materia createExample() {
    Materia materia = new Materia();
    ArrayList<Nota> _arrayList = new ArrayList<Nota>();
    materia.setNotas(_arrayList);
    return materia;
  }
  
  public Class<Materia> getEntityType() {
    return Materia.class;
  }
  
  public List<Materia> refresh() {
    List<Materia> _allInstances = this.allInstances();
    return IterableExtensions.<Materia>toList(_allInstances);
  }
}
