package com.example.webapp.controllers;

import com.example.webapp.domain.Tags;
import com.example.webapp.services.TagService;
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
public class TagsController {

    @Autowired
    TagService tagService;

    @Autowired
    public TagsController(TagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping("/tags")
    public ModelAndView productsList(){
        ModelAndView modelAndView = new ModelAndView("tags/tag-list");
        List<Tags> tags = tagService.findAll();
        modelAndView.addObject("tags",tags);
        return modelAndView;
    }

    @RequestMapping("/tag/add")
    public String newTag(Model model) {
        model.addAttribute("tags", new Tags());
        return "tags/add-tag";
    }

    @PostMapping("/tagsave")
    public String saveOrUpdate(@Valid @ModelAttribute Tags tag,
                               BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            return "tags/add-tag";
        }

        Tags savedTag = tagService.save(tag);
        return "redirect:/tags" ;
    }

    @RequestMapping("/tag/edit/{id}")
    public ModelAndView editById(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("tags/edit-tag");
        Tags tag = tagService.findById(Long.valueOf(id));
        modelAndView.addObject("tag",tag);
        return modelAndView;
    }

    @RequestMapping("/tag/delete/{id}")
    public String deleteById(@PathVariable String id){
        tagService.deleteById(Long.valueOf(id));
        return "redirect:/tags";
    }


}
