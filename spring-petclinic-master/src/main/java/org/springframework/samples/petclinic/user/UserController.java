/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.user;

import java.util.Collection;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class UserController {
    
    private final UserRepository user;
    
    public UserController(UserRepository user){
        this.user = user;
    }
    //lista usuario
    @GetMapping("/usuarios")
    public String userList(User user, BindingResult result, Map<String, Object> model){
        Collection<User> results = this.user.findAll();
        model.put("selections",results);
        return "uses/ListaUsuarios";
    }
    @GetMapping("/usuarios/reporte")
    public String userLista(User user, BindingResult result, Map<String, Object> model){
        Collection<User> results = this.user.findAll();
        model.put("selections",results);
        return "uses/ReporteUsuario";
    }
    
    
    @GetMapping("/usuarios/create")
    public  String initCreationForm(Map<String, Object> model){
    User user = new User();
    model.put("user",user);
    return "uses/AgregarUsuario";
    }
    
    @PostMapping("/usuarios/store")
    public String ProcessCreationForm(@Valid User user,BindingResult result ){
    this.user.save(user);
    return "redirect:/usuarios";
    }
    
    
    
    
    //editar Usuarios mostrar formualario de editar
    @GetMapping("/usuarios/{userId}/edit")
    public String initUpdateUserForm(@PathVariable("userId") int userId, Model model) {
        User user = this.user.findbyId(userId);
        model.addAttribute(user);
        return "uses/EditarUsuario"; 
    }
    
    @PostMapping("/usuarios/{userId}/edit")
    public String processUpdateUserForm(@Valid User user, BindingResult result, @PathVariable("userId") int userId) {
     if (result.hasErrors()) {
           return "redirect:/usuarios";
        } else {
            user.setId(userId);
            this.user.save(user);
            return "redirect:/usuarios";
        }

    }
    
    
    @PostMapping("/usuarios/{userId}/delete")
    public String deleteUser(@Valid User user, BindingResult result, @PathVariable("userId") int userId) {
        this.user.deleteUser(userId);
        return "redirect:/usuarios";
    } 
    
    
    
    
    
    
    
    
    
    
}