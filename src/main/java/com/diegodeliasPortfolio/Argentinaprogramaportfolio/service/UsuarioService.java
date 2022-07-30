package com.diegodeliasPortfolio.Argentinaprogramaportfolio.service;
import java.util.List;


import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Usuario;

public interface  UsuarioService {

    public Usuario saveUsuario(Usuario usuario);

    public List <Usuario> fetchUsuarioList();

    public Usuario fetchUsuarioById(Long usuarioId);

    public void deleteUsuarioByid(Long usuarioId);

	public Usuario updateUsuario(Long usuarioId, Usuario usuario);


    
}
