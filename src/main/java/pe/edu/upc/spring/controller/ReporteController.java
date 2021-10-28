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

import pe.edu.upc.spring.model.Reporte;
import pe.edu.upc.spring.service.IReporteService;

@Controller 	
@RequestMapping("/report") //que atienda el controlador /race  (cuando hay muchos controladores), pero este no muestra nada, tiene q ir a bienvenido
public class ReporteController {
	@Autowired
	private IReporteService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; // "bienvenido" es una pagina del frontEnd, pagina de Inicio
	}
	
	@RequestMapping("/")
	public String irPaginaListadoUsuarios(Map<String, Object> model) {
		model.put("listaUsuarios", rService.listar());
		return "listUsuario"; // "listRace" es una pagina del frontEnd para listar
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("report", new Reporte());
		return "report"; // "race" es una pagina del frontEnd para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Reporte objReporte, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			return "report";
		else {
			boolean flag = rService.grabar(objReporte);
			if (flag)
				return "redirect:/report/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un problema");
				return "redirect:/report/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Reporte> objReporte = rService.listarId(id);
		if (objReporte == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un problema");
			return "redirect:/report/listar";
		}
		else {
			model.addAttribute("report",objReporte);
			return "report";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaUsuarios", rService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un problema");
			model.put("listaUsuarios", rService.listar());
		}
		return "listUsuario";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaUsuarios", rService.listar());
		return "listUsuario";
	}
	
}
