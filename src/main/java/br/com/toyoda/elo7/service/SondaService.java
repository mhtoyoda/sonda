package br.com.toyoda.elo7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.toyoda.elo7.instruction.Instructions;
import br.com.toyoda.elo7.model.Sonda;
import br.com.toyoda.elo7.service.dto.SondaRequestDTO;

@RestController
@RequestMapping("api")
public class SondaService {

	@Autowired
	private Instructions instruction;
	
	@PostMapping(value = "/sonda")
	public ResponseEntity<List<Sonda>> execute(@RequestBody SondaRequestDTO request) {
		try{
			List<Sonda> sondas = instruction.executeInstructions(request.getPlanalto(), request.getSondas());
			return new ResponseEntity<List<Sonda>>(sondas, HttpStatus.OK);					
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
