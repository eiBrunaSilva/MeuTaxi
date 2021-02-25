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
@RequestMapping("/motorista")
public class MotoristaController {
	private MotoristaDAO motoristaDAO = new MotoristaDAO();

	@PostMapping("/salvar")
	public ResponseEntity<Motorista> salvar(@RequestBody Motorista motorista) {
		return ResponseEntity.ok(motoristaDAO.salvar(motorista));
	}

	@DeleteMapping("/excluir/{idMotorista}")
	public ResponseEntity<Void> excluir(@PathVariable Integer idMotorista) {
		motoristaDAO.excluir(idMotorista);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/editar")
	public ResponseEntity<Motorista> editar(@RequestBody Motorista motorista) {
		return ResponseEntity.ok(motoristaDAO.editar(motorista));
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Motorista>> listarMotorista() {
		return ResponseEntity.ok(motoristaDAO.listar());
	}

	@GetMapping("/buscar/{idMotorista}")
	public Motorista getMotorista(@PathVariable(name = "idMotorista") long idMotorista) {
		return motoristaDAO.buscar(idMotorista);
	}

}
