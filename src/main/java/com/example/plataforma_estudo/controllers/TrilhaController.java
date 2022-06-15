package com.example.plataforma_estudo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.plataforma_estudo.dao.TrilhaDao;
import com.example.plataforma_estudo.models.Trilha;
import com.example.plataforma_estudo.service.TrilhaService;



@Controller
@RequestMapping("/trilha")
public class TrilhaController {

    @Autowired
    private TrilhaService triService;

    @Autowired
    private TrilhaDao dis;

    @GetMapping("/add")
    public String cadTrilhas(Model model){
        model.addAttribute("trilha", new Trilha());
        return "administrador/cadTrilha";
    }

    @PostMapping("/createTrilha")
    public String addTrilha(@Valid @ModelAttribute Trilha trilha, Model model){
        model.addAttribute("trilha", trilha);
        triService.save(trilha);
        System.out.println(trilha);
        return "redirect:/trilha/list";
    }

    @GetMapping("/list")
    public ModelAndView listTrilha() {
        ModelAndView mv = new ModelAndView("administrador/trilha");
        Iterable<Trilha> trilha = triService.list();
        mv.addObject("trilha", trilha);
        return mv;
    }
    
    @GetMapping("/delete/{id}")
    public String deleteTrilha(@PathVariable Integer id) {
        triService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/update/{id}")
    public String updateTrilha(Model model, @PathVariable Integer id) {
        Trilha trilha = triService.search(id);
        System.out.println(trilha);
        model.addAttribute("trilha", trilha);
        return "administrador/editTrilha";
    }

    @PostMapping("/updateTrilha")
    public String updateTrilha(@Valid @ModelAttribute Trilha trilha, Model model){
        model.addAttribute("trilha", trilha);
        triService.update(trilha);
        return "redirect:/trilha/update";
    }
    
   

}
