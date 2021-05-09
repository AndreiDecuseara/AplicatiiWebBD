package com.example.webapp.controllers;

import com.example.webapp.domain.Infos;
import com.example.webapp.domain.Items;
import com.example.webapp.services.InfoService;
import com.example.webapp.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class InfoController {

    @Autowired
    InfoService infoService;

    @Autowired
    ItemService itemService;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }


    @RequestMapping("/info")
    public ModelAndView infoList(){
        ModelAndView modelAndView = new ModelAndView("info/info-list");
        List<Infos> infos = infoService.findAll();
        modelAndView.addObject("infos",infos);
        return modelAndView;
    }

    @RequestMapping("/info/add")
    public String newInfo(Model model) {

        model.addAttribute("infos", new Infos());
        List<Items> itemsAll = itemService.findAll();

        model.addAttribute("itemsAll", itemsAll );

        return "info/add-info";
    }

    @PostMapping("/infosave")
    public String saveOrUpdate(@Valid @ModelAttribute Infos info,
                               BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            return "info/add-info";
        }

        Infos savedinfo = infoService.save(info);
        return "redirect:/info" ;
    }

    @RequestMapping("/info/edit/{id}")
    public ModelAndView editById(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("info/edit-info");
        Infos info = infoService.findById(Long.valueOf(id));
        List<Items> itemsAll = itemService.findAll();
        modelAndView.addObject("itemsAll",itemsAll);
        modelAndView.addObject("info",info);
        return modelAndView;
    }

    @RequestMapping("/info/delete/{id}")
    public String deleteById(@PathVariable String id){
        infoService.deleteById(Long.valueOf(id));
        return "redirect:/info";
    }



}
