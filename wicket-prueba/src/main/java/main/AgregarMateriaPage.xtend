package main


import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import applicationModel.NuevaMateria
import org.apache.wicket.markup.html.form.TextField

class AgregarMateriaPage extends WebPage 

{
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	private final HomePage mainPage
	NuevaMateria nuevaMateria


	new(HomePage mainPage, NuevaMateria nuevaMateria) {
		this.mainPage = mainPage
		this.nuevaMateria = nuevaMateria
		
		var botonVolver = new XButton("botonVolver")
		botonVolver.onClick = [|volver]
		var botonAceptar = new XButton("botonAceptar")
		botonAceptar.onClick = [|aceptar]
		
		var materiaForm = new Form<NuevaMateria> ("materiaForm", new CompoundPropertyModel<NuevaMateria>(nuevaMateria))		
		
	
		materiaForm.addChild(new TextField<String>("nombre"))
		materiaForm.addChild(botonVolver)
		materiaForm.addChild(botonAceptar)

		this.addChild(materiaForm)

    }
	
	def aceptar() 
	{
		nuevaMateria.agregarse()
		volver
	}
	
	def volver()
	{
		responsePage = mainPage
	}
	
}