package br.com.travell.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import br.com.travell.entidades.Usuario;
import br.com.travell.repositorio.UsuarioRepositorio;
import br.com.travell.entidades.Usuario;
import br.com.travell.entidades.Detalhes;
import br.com.travell.entidades.CadastroDestino;


public class Servicos implements  UserDetailsService{
	@Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return new Detalhes(usuario);
    }    
}
