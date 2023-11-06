package br.com.lorem.travell.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public class UsuarioRepository {
	@Repository
	public interface Usuario extends JpaRepository<Usuario, Long>{

	}

	public List<br.com.travell.controller.Usuario> findAll() {
		
		return null;
	}

	public void save(br.com.travell.controller.Usuario usuario) {
	
		
	}

	public br.com.travell.controller.Usuario getOne(Long id) {
		
		return null;
	}

	public void deleteById(Long id) {
		
		
	}

	public Object findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}





