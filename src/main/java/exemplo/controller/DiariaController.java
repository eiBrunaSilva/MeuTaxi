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
@RequestMapping("/diaria")
public class DiariaController {

	private DiariaDAO diariaDAO = new DiariaDAO();

	@PostMapping("/salvar")
	public ResponseEntity<Diaria> salvar(@RequestBody Diaria diaria) {
		return ResponseEntity.ok(diariaDAO.salvar(diaria));
	}

	@DeleteMapping("/excluir/{idDiaria}")
	public ResponseEntity<Void> excluir(@PathVariable Integer idDiaria) {
		diariaDAO.excluir(idDiaria);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/editar")
	public ResponseEntity<Diaria> editar(@RequestBody Diaria diaria) {
		return ResponseEntity.ok(diariaDAO.editar(diaria));
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Diaria>> listarDiaria() {
		return ResponseEntity.ok(diariaDAO.listar());
	}

	@GetMapping("/buscar/{idDiaria}")
	public Diaria getDiaria(@PathVariable(name = "idDiaria") long idDiaria) {
		return diariaDAO.buscar(idDiaria);
	}

}
