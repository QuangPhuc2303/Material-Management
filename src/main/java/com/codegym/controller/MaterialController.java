package com.codegym.controller;

import com.codegym.model.Material;
import com.codegym.model.Supplier;
import com.codegym.service.MaterialService;
import com.codegym.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @Autowired
    private SupplierService supplierService;

    @ModelAttribute("suppliers")
    public Iterable<Supplier> suppliers() {
        return supplierService.findAll();
    }

    @GetMapping("/materials")
    public ModelAndView lsitMaterial() {
        Iterable<Material> materials = materialService.findAll();
        ModelAndView modelAndView = new ModelAndView("/material/list");
        modelAndView.addObject("materials", materials);
        return modelAndView;
    }

    @GetMapping("/create-material")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/material/create");
        modelAndView.addObject("material", new Material());
        return modelAndView;
    }

    @PostMapping("/create-material")
    public ModelAndView createMaterial(@ModelAttribute("material") Material material) {
        materialService.save(material);
        ModelAndView modelAndView = new ModelAndView("/material/create");
        modelAndView.addObject("material", new Material());
        modelAndView.addObject("message", "new material created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-material/{id}")
    public ModelAndView showEdit(@PathVariable Long id){
        Material material = materialService.findById(id);
        if(material != null) {
            ModelAndView modelAndView = new ModelAndView("/material/edit");
            modelAndView.addObject("material", material);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-material")
    public ModelAndView updateMaterial(@ModelAttribute("material") Material material){
        materialService.save(material);
        ModelAndView modelAndView = new ModelAndView("/material/edit");
        modelAndView.addObject("material", material);
        modelAndView.addObject("message", "material updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-material/{id}")
    public ModelAndView showDelete(@PathVariable Long id){
        Material material = materialService.findById(id);
        if(material != null) {
            ModelAndView modelAndView = new ModelAndView("/material/delete");
            modelAndView.addObject("material", material);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-material")
    public String deleteCustomer(@ModelAttribute("material") Material material){
        materialService.remove(material.getId_code());
        return "redirect:materials";
    }
}
