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
@RequestMapping("/veiculo")
public class VeiculoController {
	private VeiculoDAO veiculoDAO = new VeiculoDAO();

	@PostMapping("/salvar")
	public ResponseEntity<Veiculo> adicionar(@RequestBody Veiculo veiculo) {
		return ResponseEntity.ok(veiculoDAO.salvar(veiculo));
	}

	@DeleteMapping("/excluir/{idVeiculo}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idVeiculo) {
		veiculoDAO.excluir(idVeiculo);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/editar")
	public ResponseEntity<Veiculo> atualizar(@RequestBody Veiculo veiculo) {
		return ResponseEntity.ok(veiculoDAO.editar(veiculo));
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Veiculo>> listarVeiculo() {
		return ResponseEntity.ok(veiculoDAO.listar());
	}

	@GetMapping("/buscar/{idVeiculo}")
	public Veiculo getVeiculo(@PathVariable(name = "idVeiculo") long idVeiculo) {
		return veiculoDAO.buscar(idVeiculo);
	}
}
