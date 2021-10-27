package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Direccion;
import pe.edu.upc.spring.model.TipoVia;
import pe.edu.upc.spring.model.Distrito;

import pe.edu.upc.spring.service.IDireccionService;
import pe.edu.upc.spring.service.ITipoViaService;
import pe.edu.upc.spring.service.IDistritoService;

@Controller 	
@RequestMapping("/direccion") //que atienda el controlador /race  (cuando hay muchos controladores), pero este no muestra nada, tiene q ir a bienvenido
public class DireccionController {
	@Autowired
	private IDireccionService dService;
	
	@Autowired
	private IDistritoService diService;
	
	@Autowired
	private ITipoViaService tService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; // "bienvenido" es una pagina del frontEnd, pagina de Inicio
	}
	
	@RequestMapping("/")
	public String irPaginaListadoPremios(Map<String, Object> model) {
		model.put("listaDirecciones", dService.listar());
		return "listDireccion"; // "listRace" es una pagina del frontEnd para listar
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("listaDistritos", diService.listar());
		model.addAttribute("listaTiposVias", tService.listar());
		model.addAttribute("direccion", new Direccion());
		model.addAttribute("tipovia", new TipoVia());
		model.addAttribute("distrito", new Distrito());
		return "direccion"; // "premio" es una pagina del frontEnd para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Direccion objDireccion, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			return "direccion";
		else {
			boolean flag = dService.grabar(objDireccion);
			if (flag)
				return "redirect:/direccion/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/direccion/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Direccion> objDireccion = dService.listarId(id);
		if (objDireccion == null) 
		{
			objRedir.addFlashAttribute("mensaje", "ocurrio un error");
			return "redirect:/direccion/listar";
		}
		else {
			model.addAttribute("listaTiposVias", tService.listar());
			model.addAttribute("listaDistritos", diService.listar());
			if(objDireccion.isPresent())
				objDireccion.ifPresent(o -> model.addAttribute("direccion", o));
			return "direccion";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				dService.eliminar(id);
				model.put("listaDirecciones", dService.listar());
			}
		}
		
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaDirecciones", dService.listar());
		}
		return "listDireccion";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaDirecciones", dService.listar());
		return "listDireccion";
	}
	
}
