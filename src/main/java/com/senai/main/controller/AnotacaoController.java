package com.senai.main.controller;

import com.senai.main.domain.Anotacao;
import com.senai.main.service.AnotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AnotacaoController {

    @Autowired
    private AnotacaoService service;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/anotacoes")
    public String anotacoes(Model model){
        List<Anotacao> listaAnotacoes = service.listAll();
        model.addAttribute("listaAnotacoes",listaAnotacoes);
        return "list";
    }

    @GetMapping("/adicionar")
    public String add(Model model){
        model.addAttribute("anotacao",new Anotacao());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAnotacao(@ModelAttribute("anotacao") Anotacao a){
        service.save(a);
        return "redirect:/anotacoes";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView editAnotacao(@PathVariable(name="id") int id){
        ModelAndView mav = new ModelAndView("new");
        Anotacao a = service.get(id);
        mav.addObject("anotacao",a);
        return mav;
    }

    @RequestMapping("/anotacao/{id}")
    public String viewAnotacao(Model model, @PathVariable(name="id") int id){
        Anotacao a = service.get(id);
        model.addAttribute("singleAnotacao",a);
        return "single";
    }

    @RequestMapping("/delete/{id}")
    public String deleteAnotacao(@PathVariable(name = "id") int id){
        service.delete(id);
        return "redirect:/anotacoes";
    }
}
