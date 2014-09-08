package main

import applicationModel.NuevaMateria
import applicationModel.SeguidorDeCarrera
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.CheckBox
import org.apache.wicket.markup.html.form.DropDownChoice
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton
import org.uqbar.wicket.xtend.XListView
import domain.Nota
import applicationModel.NuevaNota

/**
 * 
 * @author ?
 */
class HomePage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	@Property
	var SeguidorDeCarrera seguidor;
	
	new() {
		this.seguidor = new SeguidorDeCarrera()
		this.seguidor.refresh()
		
		val Form<SeguidorDeCarrera> materiasForm = new Form<SeguidorDeCarrera>("materiasForm", new CompoundPropertyModel<SeguidorDeCarrera>(this.seguidor))
		
		this.agregarGrillaMaterias(materiasForm)
		this.agregarGrillaNotas(materiasForm)
		this.agregarAccionesMateria(materiasForm)
		this.agregarEditarMateria(materiasForm)
		this.agregarFormNotas(materiasForm)
		
		this.addChild(materiasForm)
    }
	
	
	def agregarAccionesMateria(Form<SeguidorDeCarrera> parent) 
	{
		val botonAgregarMateria = new XButton("nuevaMateria")
		botonAgregarMateria.onClick = [|agregarMateria()]
		parent.addChild(botonAgregarMateria)
	}
	
	def agregarMateria() 
	{
		responsePage = new AgregarMateriaPage(this, new NuevaMateria(this.seguidor));
		this.seguidor.refresh()
	}
	
	def agregarFormNotas(Form<SeguidorDeCarrera> parent) {
		this.agregarAccionesNotas(parent)
	}
	
	def agregarAccionesNotas(Form<SeguidorDeCarrera> parent) {
		
	}
	
	def agregarGrillaMaterias(Form<SeguidorDeCarrera> parent) {
		val listView = new XListView("materias")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			item.addChild(new XButton("editar").onClick = [| this.seguidor.seleccionarMateria(item.modelObject)])
		]
		
		parent.addChild(listView)
	}
	
	def agregarGrillaNotas(Form<SeguidorDeCarrera> form) 
	{
		var listNotas = new XListView("materiaSeleccionada.notas")
		
		listNotas.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("fecha"))
			item.addChild(new Label("descripcion"))
			item.addChild(new Label("aprobado",convertirAprobacion(item.modelObject)))	//se lee :D
			item.addChild(new XButton("editarNota").onClick = [|this.editarNota(item.modelObject)])
			item.addChild(new XButton("borrarNota").onClick = [|this.borrarNota(item.modelObject)])
		]	
		
		form.addChild(new XButton("agregarNota").onClick = [|this.agregarNota()])
		form.addChild(listNotas)		
	}
	
	def borrarNota(Nota nota) {
		seguidor.materiaSeleccionada.notas.remove(nota)
		this.seguidor.refresh()
	}
	
	def convertirAprobacion(Nota nota){
		if(nota.aprobado)
		return "Si" else "No"
	}
	
	def agregarNota()
	{
		responsePage = new AgregarNotaPage(this, new NuevaNota(seguidor));
		this.seguidor.refresh()
	}
	
	def editarNota(Nota nota) 
	{
		responsePage = new AgregarNotaPage(this, nota);
		this.seguidor.refresh()
	}
	
	def agregarEditarMateria(Form<SeguidorDeCarrera> parent){
		parent.addChild(new Label("materiaSeleccionada.nombre"))
		parent.addChild(new TextField<String>("materiaSeleccionada.anioCursada"))
		parent.addChild(new TextField<String>("materiaSeleccionada.profesor"))
		parent.addChild(new DropDownChoice<String>("materiaSeleccionada.ubicacion") =>
			[
				//FIXME che y cómo se agregan las choices????
			]
		)
		parent.addChild(new CheckBox("materiaSeleccionada.finalAprobado"))
	}
}

