package exemplo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import exemplo.model.*;
import exemplo.persistencia.*;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController {

	private ProprietarioDAO proprietarioDAO = new ProprietarioDAO();

	@PostMapping("/salvar")
	public ResponseEntity<Proprietario> salvar(@RequestBody Proprietario proprietario) {
		return ResponseEntity.ok(proprietarioDAO.salvar(proprietario));
	}

	@DeleteMapping("/excluir/{idProprietario}")
	public ResponseEntity<Void> excluir(@PathVariable Integer idProprietario) {
		proprietarioDAO.excluir(idProprietario);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/editar")
	public ResponseEntity<Proprietario> editar(@RequestBody Proprietario proprietario) {
		return ResponseEntity.ok(proprietarioDAO.editar(proprietario));
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Proprietario>> listarProprietario() {
		return ResponseEntity.ok(proprietarioDAO.listar());
	}
	
	@GetMapping("/buscar/{idProprietario}")
	public Proprietario getProprietario(@PathVariable(name = "idProprietario") long idProprietario) {
		return proprietarioDAO.buscar(idProprietario);
	}	

}
