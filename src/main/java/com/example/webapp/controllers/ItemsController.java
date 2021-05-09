package com.example.webapp.controllers;

import com.example.webapp.domain.Infos;
import com.example.webapp.domain.Items;
import com.example.webapp.domain.Tags;
import com.example.webapp.domain.Users;
import com.example.webapp.services.ItemService;
import com.example.webapp.services.TagService;
import com.example.webapp.services.UserService;
import org.aspectj.apache.bcel.generic.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
public class ItemsController {

    @Autowired
    ItemService itemService;

    @Autowired
    TagService tagService;

    @Autowired
    UserService userService;


    @Autowired
    public ItemsController(ItemService itemService) {
        this.itemService = itemService;
    }




    @RequestMapping("/items")
    public ModelAndView productsList(){
        ModelAndView modelAndView = new ModelAndView("items/item-list");
        List<Items> items = itemService.findAll();
        modelAndView.addObject("items",items);
        return modelAndView;
    }

    @RequestMapping("/item/add")
    public String newItem(Model model) {
        model.addAttribute("items", new Items());
        List<Tags> tagsAll = tagService.findAll();
        List<Users> usersAll = userService.findAll();
        model.addAttribute("tagsAll", tagsAll );
        model.addAttribute("usersAll", usersAll );
        return "items/add-item";
    }

    @RequestMapping("/item/edit/{id}")
    public ModelAndView editById(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("items/edit-item");
        Items item = itemService.findById(Long.valueOf(id));
        List<Tags> tagsAll = tagService.findAll();
        List<Users> usersAll = userService.findAll();
        modelAndView.addObject("item",item);
        modelAndView.addObject("tagsAll", tagsAll);
        modelAndView.addObject("usersAll", usersAll );
        return modelAndView;
    }

    @PostMapping("/itemsave")
    public String saveOrUpdate(@Valid @ModelAttribute Items item,
                                          BindingResult bindingResult
                               ){
        if (bindingResult.hasErrors()){
            return "items/add-item";
        }

        Items savedProduct = itemService.save(item);
        //return "redirect:/product/info/" + savedProduct.getId();
        return "redirect:/items" ;
    }

    @RequestMapping("/item/delete/{id}")
    public String deleteById(@PathVariable String id){
        itemService.deleteById(Long.valueOf(id));
        return "redirect:/items";
    }

}
