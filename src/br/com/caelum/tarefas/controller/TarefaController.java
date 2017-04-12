package br.com.caelum.tarefas.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;


@Controller
public class TarefaController {
	
	private final JdbcTarefaDao dao;
	
	@Autowired
	public TarefaController(JdbcTarefaDao dao) {
		this.dao = dao;
	}

	@RequestMapping("novaTarefa")
	public String form(){
		return "tarefa/formulario";
	}
	
	@RequestMapping("adicionarTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result){
		// Verificaçao com IF se há erro no campo descricao que é atributo de tarefa, caso haja o usuario retorna-ra a tela de cadastro de tarefa
		if(result.hasFieldErrors("descricao")){
			return "tarefa/formulario";
		}
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model){

		model.addAttribute("tarefas", dao.lista());
		return "tarefa/lista";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa){
		dao.remove(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model){
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String mostra(Tarefa tarefa){
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}
	
	// Aqui não podemos retornar uma string, pois se retornar uma string a função de call back irá ter o valor da string e não da página que redenriza a data
	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public ModelAndView finaliza(Long id){
		dao.finaliza(id);		
		ModelAndView mv = new ModelAndView("tarefa/dataFinalizada");
		mv.addObject("tarefa", dao.buscaPorId(id));
		return mv;
	}
}
