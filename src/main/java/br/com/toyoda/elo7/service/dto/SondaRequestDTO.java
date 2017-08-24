package br.com.toyoda.elo7.service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.toyoda.elo7.model.Planalto;

public class SondaRequestDTO {

	private Planalto planalto;

	private List<SondaInstructionDTO> sondas;
	
	@JsonCreator
	public SondaRequestDTO(@JsonProperty("planalto") Planalto planalto, @JsonProperty("sondas") List<SondaInstructionDTO> sondas) {
		super();
		this.planalto = planalto;
		this.sondas = sondas;
	}

	public Planalto getPlanalto() {
		return planalto;
	}

	public List<SondaInstructionDTO> getSondas() {
		return sondas;
	}
}
