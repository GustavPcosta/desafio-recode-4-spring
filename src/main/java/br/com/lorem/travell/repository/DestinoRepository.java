package br.com.lorem.travell.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




public class DestinoRepository {
	@Repository
	public interface Destino extends JpaRepository<Destino, Long>{

	}

	public List<br.com.travell.controller.Destino.Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public br.com.travell.controller.Destino getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void save(br.com.travell.controller.Destino.Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
}
