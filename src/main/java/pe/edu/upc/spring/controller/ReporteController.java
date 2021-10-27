package pe.edu.upc.spring.controller;

import java.util.List;
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
import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.model.Reporte;

import pe.edu.upc.spring.service.IDireccionService;
import pe.edu.upc.spring.service.IUsuarioService;
import pe.edu.upc.spring.service.IReporteService;

@Controller 	
@RequestMapping("/reporte") //que atienda el controlador /race  (cuando hay muchos controladores), pero este no muestra nada, tiene q ir a bienvenido
public class ReporteController {
	@Autowired
	private IDireccionService dService;
	
	@Autowired
	private IUsuarioService uService;
	
	@Autowired
	private IReporteService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; // "bienvenido" es una pagina del frontEnd, pagina de Inicio
	}
	
	@RequestMapping("/")
	public String irPaginaListadoPremios(Map<String, Object> model) {
		model.put("listaReportes", rService.listar());
		return "listReporte"; // "listRace" es una pagina del frontEnd para listar
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("listaDirecciones", dService.listar());
		model.addAttribute("listaUsuarios", uService.listar());
		model.addAttribute("direccion", new Direccion());
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("reporte", new Reporte());
		return "reporte"; // "premio" es una pagina del frontEnd para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Direccion objReporte, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			return "reporte";
		else {
			boolean flag = dService.grabar(objReporte);
			if (flag)
				return "redirect:/reporte/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/reporte/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Reporte> objReporte = rService.listarId(id);
		if (objReporte == null) 
		{
			objRedir.addFlashAttribute("mensaje", "ocurrio un error");
			return "redirect:/reporte/listar";
		}
		else {
			model.addAttribute("listaDirecciones", dService.listar());
			model.addAttribute("listaUsuarios", uService.listar());
			if(objReporte.isPresent())
				objReporte.ifPresent(o -> model.addAttribute("reporte", o));
			return "reporte";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaReportes", rService.listar());
			}
		}
		
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaReportes", rService.listar());
		}
		return "listReporte";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaReportes", rService.listar());
		return "listReporte";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("reporte", new Reporte());
		return "buscar";
	}	
	
	
	/*@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Reporte reporte ) 
	throws ParseException
	{
		List<Reporte> listaReportes;
		
		reporte.setTDescripcion(reporte.getTDescripcion()); //capturo lo que dijite en la cajita de texto
		
		listaReportes = rService.buscarDireccionReporte(reporte.getObjdireccion());
		
		if (listaMascotas.isEmpty()) {
			listaMascotas = pService.buscarPropietario(pet.getNamePet());
		}
		
		if (listaMascotas.isEmpty()) {
			listaMascotas = pService.buscarRaza(pet.getNamePet());
		}
		
		if (listaMascotas.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaMascotas", listaMascotas);
		
		return "buscar";
	}	*/
	
}
