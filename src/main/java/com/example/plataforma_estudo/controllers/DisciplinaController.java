package com.example.plataforma_estudo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.plataforma_estudo.dao.DisciplinaDao;
import com.example.plataforma_estudo.models.Disciplina;
import com.example.plataforma_estudo.service.DisciplinaService;



@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disService;

    @Autowired
    private DisciplinaDao dis;

    @GetMapping("/add")
    public String cadDisciplinas(Model model){
        model.addAttribute("disciplina", new Disciplina());
        return "professor/cadDisciplina";
    }

    @PostMapping("/createDisciplina")
    public String addDisciplina(@Valid @ModelAttribute Disciplina disciplina, Model model){
        model.addAttribute("disciplina", disciplina);
        disService.save(disciplina);
        System.out.println(disciplina);
        return "redirect:/disciplina/list";
    }

    @GetMapping("/list")
    public ModelAndView listDisciplina() {
        ModelAndView mv = new ModelAndView("professor/disciplina");
        Iterable<Disciplina> disciplina = disService.list();
        mv.addObject("disciplina", disciplina);
        return mv;
    }
    
    @GetMapping("/delete/{id}")
    public String deleteDisciplina(@PathVariable Integer id) {
        disService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/update/{id}")
    public String updateDisciplina(Model model, @PathVariable Integer id) {
        Disciplina disciplina = disService.search(id);
        System.out.println(disciplina);
        model.addAttribute("disciplina", disciplina);
        return "professor/editDisciplina";
    }

    @PostMapping("/updateDisciplina")
    public String updateDisciplina(@Valid @ModelAttribute Disciplina disciplina, Model model){
        model.addAttribute("disciplina", disciplina);
        disService.update(disciplina);
        return "redirect:/disciplina/update";
    }
    
   

}
