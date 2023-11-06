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

import br.com.lorem.travell.repository.DestinoRepository;
//import br.com.lorem.travell.repository.UsuarioRepository;

public class Destino {
	@Controller
	@RequestMapping("/destino")
	public class Usuario {

		@Autowired
		private DestinoRepository destinoRepository;
		private Object destino;

		// lista todos os dados do banco destino
		@GetMapping
		public ModelAndView listar() {
			ModelAndView modelAndView = new ModelAndView("cliente/listar.html");

			List<Usuario> destino = destinoRepository.findAll();
			Object destino1 = null;
			modelAndView.addObject("destino", destino1);

			return modelAndView;
		}

		// chama a view cadastrar e passa um objeto vazio
		@GetMapping("/cadastrar")
		public ModelAndView cadastrar() {
			ModelAndView modelAndView = new ModelAndView("destino/cadastro");

			modelAndView.addObject("destino", new Destino());

			return modelAndView;
		}

		@PostMapping("/cadastrar")
		public ModelAndView cadastrar(Usuario usuario, @RequestParam("fileDestino") MultipartFile file) throws IOException {

			try {
				usuario.setImagem(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			ModelAndView modelAndView = new ModelAndView("redirect:/usuario");

			destinoRepository.save(usuario);

			return modelAndView;
		}

		private void setImagem(byte[] bytes) {
			
			
		}

		@GetMapping("/imagem/{id}")
		@ResponseBody
		public byte[] exibirImagen(@PathVariable("id") Long id) {
			Destino destino = this.destinoRepository.getOne(id);
			return destino.getImagem();
		}	

		private byte[] getImagem() {
			
			return null;
		}

		@GetMapping("/{id}")
		public ModelAndView detalhar(@PathVariable Long id) {
			ModelAndView modelAndView = new ModelAndView("usuario/detalhar.html");

			Destino destino = destinoRepository.getOne(id);
			modelAndView.addObject("cliente",destino);

			return modelAndView;
		}

		@GetMapping("/{id}/excluir")
		public ModelAndView excluir(@PathVariable Long id) {
			ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

			destinoRepository.deleteById(id);

			return modelAndView;
		}

		@GetMapping("/{id}/editar")
		public ModelAndView editar(@PathVariable Long id) {
			ModelAndView modelAndView = new ModelAndView("destino/edicao");

			Destino destino = destinoRepository.getOne(id);
			modelAndView.addObject("destino", destino);

			return modelAndView;
		}

		@PostMapping("/{id}/editar")
		public ModelAndView editar(Usuario usuario) {
			ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

			destinoRepository.save(usuario);

			return modelAndView;
		}

	}

	public byte[] getImagem() {
		// TODO Auto-generated method stub
		return null;
	}
}
