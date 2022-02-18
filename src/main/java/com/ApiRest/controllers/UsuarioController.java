package com.ApiRest.controllers;

import com.ApiRest.models.UsuarioModel;
import com.ApiRest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }

    /**
     * Este metodo lee un Long id del path y si existe un usuario con esa id lo retorna
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    /**
     * Este metodo lee una prioridad ddel path y retorna una lista de usuarios que tengan
     * dicha prioridad
     * @param prioridad
     * @return
     */
    @GetMapping(path = "/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    /**
     * Este metodo lee una id de la ruta y elimina al usuario con la id correspondiente
     * @param id
     * @return
     */
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se elimino el usuario con id "+id;
        }else{
            return "No se puedo eliminar el usuario con id "+id;
        }
    }

    /**
     * Este metodo elimina a todos los usuarios al recibir la instrucción "eliminarUsuarios" en el path
     * @return
     */
    @DeleteMapping("/eliminarUsuarios")
    public String eliminarUsuarios(){
        boolean ok = this.usuarioService.eliminarUsuarios();
        if(ok){
            return "Se eliminaron todos los usuarios";
        }else{
            return "No se puedo eliminar a todos los usuarios";
        }
        }
    }


