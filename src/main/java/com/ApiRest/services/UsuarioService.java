package com.ApiRest.services;

import com.ApiRest.models.UsuarioModel;
import com.ApiRest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Retorna un ArrayList con todos los usuarios
     * @return
     */
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    /**
     * Guarda un usuario dado
     * @param usuarioModel
     * @return
     */
    public UsuarioModel guardarUsuario(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    /**
     * Retorna un Optional con lo usuarios que coincidan con la id indicada
     * @param id
     * @return
     */
    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    /**
     * Retorna un ArrayList con los usuario que tengan asignada la prioridad indicada
     * @param prioridad
     * @return
     */
    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    /**
     * Elimina al usuario con la id indicada. Retorna un booleano confirmando que el metodo funcionó
     * @param id
     * @return
     */
    public boolean eliminarUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * Elimina a todos los usuarios
     * @return
     */
    public boolean eliminarUsuarios(){
        try{
            usuarioRepository.deleteAll();
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
