package com.diegodeliasPortfolio.Argentinaprogramaportfolio.service;

import java.util.List;
import java.util.Objects;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Usuario;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        
        return usuarioRepository.save(usuario);
        
    }

    @Override
    public List<Usuario> fetchUsuarioList() {
        
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario fetchUsuarioById(Long usuarioId) {
        
        return usuarioRepository.findById(usuarioId).get();
    }

    @Override
    public void deleteUsuarioByid(Long usuarioId) {
        
        usuarioRepository.deleteById(usuarioId);
        
    }

    @Override
    public Usuario updateUsuario(Long usuarioId, Usuario usuario) {
        Usuario usuDb = usuarioRepository.findById(usuarioId).get();

        if(Objects.nonNull(usuario.getNombre())&& !"".equalsIgnoreCase(usuario.getNombre())) {

            usuDb.setNombre(usuario.getNombre());
        }

        if(Objects.nonNull(usuario.getHeadertitulo())&& !"".equalsIgnoreCase(usuario.getHeadertitulo())) {

            usuDb.setHeadertitulo(usuario.getHeadertitulo());
        }

        
        if(Objects.nonNull(usuario.getHeadersubtitulo())&& !"".equalsIgnoreCase(usuario.getHeadersubtitulo())) {

            usuDb.setHeadersubtitulo(usuario.getHeadersubtitulo());
        }


     
        
        if(Objects.nonNull(usuario.getApellido())&& !"".equalsIgnoreCase(usuario.getApellido())) {

            usuDb.setApellido(usuario.getApellido());
        }


        if(Objects.nonNull(usuario.getUsuario())&& !"".equalsIgnoreCase(usuario.getUsuario())) {

            usuDb.setUsuario(usuario.getUsuario());
        }


        if(Objects.nonNull(usuario.getEmail())&& !"".equalsIgnoreCase(usuario.getEmail())) {

            usuDb.setEmail(usuario.getEmail());
        }

        if(Objects.nonNull(usuario.getPassword())&& !"".equalsIgnoreCase(usuario.getPassword())) {

            usuDb.setPassword(usuario.getPassword());
        }




        if(Objects.nonNull(usuario.getSobremi())&& !"".equalsIgnoreCase(usuario.getSobremi())) {

            usuDb.setSobremi(usuario.getSobremi());
        }



        if(Objects.nonNull(usuario.getTitulo())&& !"".equalsIgnoreCase(usuario.getTitulo())) {

            usuDb.setTitulo(usuario.getTitulo());
        }

        if(Objects.nonNull(usuario.getSubtitulo())&& !"".equalsIgnoreCase(usuario.getSubtitulo())) {

            usuDb.setSubtitulo(usuario.getSubtitulo());
        }








        return usuarioRepository.save(usuDb);
    }
    
}
