package home;

import domain.Materia;
import domain.Nota;
import java.util.ArrayList;

@SuppressWarnings("all")
public class HomeMaterias {
  private ArrayList<Materia> materias;
  
  public ArrayList<Materia> getMaterias() {
    return this.materias;
  }
  
  public void addMateria(final String nombre, final int anio_cursada, final String profesor, final boolean final_aprobado, final String ubicacion) {
    Materia materia = new Materia();
    materia.setNombre(nombre);
    materia.setAnio_cursada(anio_cursada);
    materia.setProfesor(profesor);
    materia.setFinal_aprobado(final_aprobado);
    materia.setUbicacion(ubicacion);
    ArrayList<Nota> _arrayList = new ArrayList<Nota>();
    materia.setNotas(_arrayList);
    this.materias.add(materia);
  }
}