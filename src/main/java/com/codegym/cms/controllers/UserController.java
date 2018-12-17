package com.codegym.cms.controllers;

import com.codegym.cms.model.User;
import com.codegym.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/blog")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "list")
    public ModelAndView showList(){
        List<User> list = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("/user/list");
        modelAndView.addObject("list", list);
        return modelAndView;
    }
    @GetMapping(value = "create")
    public ModelAndView showCreate(){
        return new ModelAndView("/user/create", "user", new User());
    }
    @PostMapping(value = "create")
    public ModelAndView createUser(@ModelAttribute("user") User user){
        userService.save(user);
        return new ModelAndView("/user/create", "message", "Created user success!");
    }
    @GetMapping(value = "edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id){
        User user = userService.findById(id);
        if(user != null) {
            ModelAndView modelAndView = new ModelAndView("/user/edit");
            modelAndView.addObject("user", user);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping(value = "edit")
    public ModelAndView editUser(@ModelAttribute("user") User user){
        userService.save(user);
        return new ModelAndView("/user/edit", "message", "Edited blog success!");
    }
    @GetMapping(value = "view/{id}")
    public ModelAndView showView(@PathVariable long id){
        User user = userService.findById(id);
        ModelAndView model = new ModelAndView("/user/view", "user", user);
        return model;
    }
    @GetMapping(value = "delete/{id}")
    public ModelAndView showDelete(@PathVariable long id){
        User user = userService.findById(id);
        ModelAndView model = new ModelAndView("/user/delete", "user", user);
        return model;
    }
    @PostMapping(value = "delete")
    public String deleteUser(@ModelAttribute("user") User user){
        userService.remove(user.getId());
        return "redirect:/blog/list";
    }
}
