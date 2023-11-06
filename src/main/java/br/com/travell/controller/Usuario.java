package br.com.travell.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//import br.com.lorem.travell.usuario.usuario.*;
import br.com.lorem.travell.repository.UsuarioRepository;
@Controller
@RequestMapping("/usuario")
public class Usuario {

	@Autowired
	private UsuarioRepository usuarioRepository;
	private Object usuario;

	// lista todos os dados do banco cliente
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("cliente/listar.html");

		List<Usuario> usuario = usuarioRepository.findAll();
		Object usuario1 = null;
		modelAndView.addObject("usuario", usuario1);

		return modelAndView;
	}

	// chama a view cadastrar e passa um objeto vazio
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro");

		modelAndView.addObject("usuario", new Usuario());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Usuario usuario, @RequestParam("fileUsuario") MultipartFile file) throws IOException {

		try {
			usuario.setImagem(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("redirect:/usuario");

		usuarioRepository.save(usuario);

		return modelAndView;
	}

	private void setImagem(byte[] bytes) {
		
		
	}

	@GetMapping("/imagem/{id}")
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("id") Long id) {
		Usuario cliente = this.usuarioRepository.getOne(id);
		return cliente.getImagem();
	}	

	private byte[] getImagem() {
		
		return null;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("usuario/detalhar.html");

		Usuario usuario = usuarioRepository.getOne(id);
		modelAndView.addObject("cliente", usuario);

		return modelAndView;
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

		usuarioRepository.deleteById(id);

		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cliente/edicao");

		Usuario cliente = usuarioRepository.getOne(id);
		modelAndView.addObject("cliente", cliente);

		return modelAndView;
	}

	@PostMapping("/{id}/editar")
	public ModelAndView editar(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

		usuarioRepository.save(usuario);

		return modelAndView;
	}

}