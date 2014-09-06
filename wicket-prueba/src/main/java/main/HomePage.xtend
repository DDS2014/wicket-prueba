package main

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import applicationModel.SeguidorDeCarrera
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.XListView
import org.apache.wicket.markup.html.basic.Label
import org.uqbar.wicket.xtend.XButton
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.form.CheckBox


/**
 * 
 * @author ?
 */
class HomePage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	var SeguidorDeCarrera seguidor;
	
	new() {
		this.seguidor = new SeguidorDeCarrera()
		this.seguidor.refresh()
		
		val Form<SeguidorDeCarrera> materiasForm = new Form<SeguidorDeCarrera>("materiasForm", new CompoundPropertyModel<SeguidorDeCarrera>(this.seguidor))
		
		this.agregarGrillaMaterias(materiasForm)
		this.agregarEditarMateria(materiasForm)
		this.agregarFormNotas(materiasForm)
		
		this.addChild(materiasForm)
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
	
	def agregarEditarMateria(Form<SeguidorDeCarrera> parent){
		parent.addChild(new TextField<String>("materiaSeleccionada.anioCursada"))
		parent.addChild(new TextField<String>("materiaSeleccionada.profesor"))
		parent.addChild(new CheckBox("materiaSeleccionada.finalAprobado"))
	}
}

