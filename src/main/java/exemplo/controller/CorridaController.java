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
@RequestMapping("/corrida")
public class CorridaController {

	private CorridaDAO corridaDAO = new CorridaDAO();

	@PostMapping("/salvar")
	public ResponseEntity<Corrida> salvar(@RequestBody Corrida corrida) {
		return ResponseEntity.ok(corridaDAO.salvar(corrida));
	}

	@DeleteMapping("/excluir/{idCorrida}")
	public ResponseEntity<Void> excluir(@PathVariable Integer idCorrida) {
		corridaDAO.excluir(idCorrida);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/editar")
	public ResponseEntity<Corrida> editar(@RequestBody Corrida corrida) {
		return ResponseEntity.ok(corridaDAO.editar(corrida));
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Corrida>> listarCorrida() {
		return ResponseEntity.ok(corridaDAO.listar());
	}

	@GetMapping("/buscar/{idCorrida}")
	public Corrida getCorrida(@PathVariable(name = "idCorrida") long idCorrida) {
		return corridaDAO.buscar(idCorrida);
	}
}
