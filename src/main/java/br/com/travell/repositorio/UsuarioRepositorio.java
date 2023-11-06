package br.com.travell.repositorio;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.travell.entidades.Usuario;


public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	
	@EntityGraph(attributePaths = {"endereco", "cargo"})
    List<Usuario> findAll();

    @Query("select f from usuario f where f.cargo.nome = :cargoNome")
    List<Usuario> buscarPorNome(String useNome);

    @Query("select f from usuario f where f.cargo.nome <> :cargoNome")
    List<Usuario> buscarPorEmail(String useEmail);

    Optional<Usuario> findByEmail(String email);
}







