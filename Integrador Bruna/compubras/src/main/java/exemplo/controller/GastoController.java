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
@RequestMapping("/gasto")
public class GastoController {
	private GastoDAO gastoDAO = new GastoDAO();

	@PostMapping("/salvar")
	public ResponseEntity<Gasto> salvar(@RequestBody Gasto gasto) {
		return ResponseEntity.ok(gastoDAO.salvar(gasto));
	}

	@DeleteMapping("/excluir/{idGasto}")
	public ResponseEntity<Void> excluir(@PathVariable Integer idGasto) {
		gastoDAO.excluir(idGasto);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/editar")
	public ResponseEntity<Gasto> editar(@RequestBody Gasto gasto) {
		return ResponseEntity.ok(gastoDAO.editar(gasto));
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Gasto>> listarGasto() {
		return ResponseEntity.ok(gastoDAO.listar());
	}

	@GetMapping("/buscar/{idGasto}")
	public Gasto getGasto(@PathVariable(name = "idGasto") long idGasto) {
		return gastoDAO.buscar(idGasto);
	}

}
