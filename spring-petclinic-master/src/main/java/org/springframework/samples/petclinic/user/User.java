/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public boolean isNew() {
        return this.id == null;
    }
    
    @Column(name = "nombre")
    @NotEmpty
    private String nombre;
    
    @Column(name = "apellido")
    @NotEmpty
    private String apellido;
    
    @Column(name = "correo")
    @NotEmpty
    private String correo;
    
    @Column(name = "password")
    @NotEmpty
    private String password;
    
    @Column(name = "imagen")
    @NotEmpty
    private String imagen ;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String lastName) {
        this.apellido = lastName;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String avatar) {
        this.imagen = avatar;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId()).append("new", this.isNew())
                .append("nombre", this.getNombre())
                .append("correo", this.getCorreo()).append("imagen", this.getImagen())
                .toString();
    }
    
    
}
