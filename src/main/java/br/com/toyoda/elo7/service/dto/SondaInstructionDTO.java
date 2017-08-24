package br.com.toyoda.elo7.service.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.toyoda.elo7.model.Sonda;

public class SondaInstructionDTO {

	private String instruction;
	
	private Sonda sonda;
	
	@JsonCreator
	public SondaInstructionDTO(@JsonProperty("instrunction") String instruction, @JsonProperty("sonda") Sonda sonda) {
		super();
		this.instruction = instruction;
		this.sonda = sonda;
	}

	public String getInstruction() {
		return instruction;
	}

	public Sonda getSonda() {
		return sonda;
	}

}
