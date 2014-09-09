package main

import applicationModel.NuevaNota
import domain.Nota
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.CheckBox
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.uqbar.wicket.xtend.PropertyValidator

class AgregarNotaPage extends WebPage 

{
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	private HomePage mainPage
	boolean alta;
	Nota nota;
	NuevaNota nuevaNota;

	
	def init(HomePage mainPage, Nota nota)
	{
		this.nota = nota
		this.mainPage = mainPage	
		
		this.addChild(new Label("titulo", if (this.alta) "Agregar Nota" else "Modificar Nota"))
		
		var notaForm = new Form<Nota>("notaForm", new CompoundPropertyModel<Nota>(nota))
		
		this.addChild(notaForm)
		
		var campoDescripcion = new TextField("descripcion")
		var campoFecha = new TextField("fecha")
		
		campoDescripcion.add(new PropertyValidator) //esto es para las validaciones
		campoFecha.add(new PropertyValidator)
		
		notaForm.addChild(campoDescripcion)
		notaForm.addChild(campoFecha)
		notaForm.addChild(new CheckBox("aprobado"))
	
		var botonVolver = new XButton("botonVolver")
		botonVolver.onClick = [|volver]
		var botonAceptar = new XButton("botonAceptar")
		botonAceptar.onClick = [|aceptar]
		//FIXME esto es copypaste!
		
		notaForm.addChild(botonVolver)
		notaForm.addChild(botonAceptar)
		notaForm.addChild(new FeedbackPanel("feedbackPanel"))
	}
	
	def aceptar() 
	{
		nota.validarDescripcion(nota.descripcion)
		nota.validarFecha(nota.fecha)
		
		if(this.alta)
		{
			nuevaNota.agregarse()
		}
		volver
	}
	
	def volver() 
	{
		responsePage = mainPage
	}
	
	
	new(HomePage mainPage, NuevaNota nuevaNota) 
	{
		this.alta = true;
		this.nuevaNota = nuevaNota
		this.init(mainPage, nuevaNota.nota)
		
	}
	
	new(HomePage mainPage, Nota nota) 
	{
		this.alta = false;
		this.init(mainPage, nota)		
	}
	
	
	
}