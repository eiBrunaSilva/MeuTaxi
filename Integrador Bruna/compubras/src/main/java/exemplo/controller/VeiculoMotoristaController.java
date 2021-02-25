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
@RequestMapping("/veiculoMotorista")
public class VeiculoMotoristaController {
	private VeiculoMotoristaDAO veiculoMotoristaDAO = new VeiculoMotoristaDAO();

	@PostMapping("/salvar")
	public ResponseEntity<VeiculoMotorista> adicionar(@RequestBody VeiculoMotorista veiculoMotorista) {
		return ResponseEntity.ok(veiculoMotoristaDAO.salvar(veiculoMotorista));
	}

	@DeleteMapping("/excluir/{idVeiculoMotorista}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idVeiculoMotorista) {
		veiculoMotoristaDAO.excluir(idVeiculoMotorista);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/editar")
	public ResponseEntity<VeiculoMotorista> atualizar(@RequestBody VeiculoMotorista veiculoMotorista) {
		return ResponseEntity.ok(veiculoMotoristaDAO.editar(veiculoMotorista));
	}

	@GetMapping("/listar")
	public ResponseEntity<List<VeiculoMotorista>> buscarTodosVeiculosMotorista() {
		return ResponseEntity.ok(veiculoMotoristaDAO.listar());
	}

	@GetMapping("/buscar/{idVeiculoMotorista}")
	public VeiculoMotorista getVeiculoMotorista(@PathVariable(name = "idVeiculoMotorista") long idVeiculoMotorista) {
		return veiculoMotoristaDAO.buscar(idVeiculoMotorista);
	}

}
