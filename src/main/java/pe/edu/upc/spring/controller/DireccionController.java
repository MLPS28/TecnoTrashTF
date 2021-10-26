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
@RequestMapping("/direccion") //que atienda el controlador /race  (cuando hay muchos controladores), pero este no muestra nada, tiene q ir a bienvenido
public class DireccionController {
	@Autowired
	private IReporteService direcService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; // "bienvenido" es una pagina del frontEnd, pagina de Inicio
	}
	
	@RequestMapping("/")
	public String irPaginaListadoUsuarios(Map<String, Object> model) {
		model.put("listaReportes", direcService.listar());
		return "listReporte"; // "listRace" es una pagina del frontEnd para listar
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("reporte", new Reporte());
		return "reporte"; // "race" es una pagina del frontEnd para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Reporte objReporte, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			return "reporte";
		else {
			boolean flag = direcService.grabar(objReporte);
			if (flag)
				return "redirect:/usuario/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un problema");
				return "redirect:/usuario/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Reporte> objReporte = direcService.listarId(id);
		if (objReporte == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un problema");
			return "redirect:/usuario/listar";
		}
		else {
			model.addAttribute("usuario",objReporte);
			return "usuario";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				direcService.eliminar(id);
				model.put("listaReportes", direcService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un problema");
			model.put("listaReportes", direcService.listar());
		}
		return "listReporte";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaReportes", direcService.listar());
		return "listReporte";
	}
	
}
