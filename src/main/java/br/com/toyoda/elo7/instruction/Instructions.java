package br.com.toyoda.elo7.instruction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.toyoda.elo7.command.Command;
import br.com.toyoda.elo7.exception.MovimentSondaException;
import br.com.toyoda.elo7.model.Planalto;
import br.com.toyoda.elo7.model.Sonda;
import br.com.toyoda.elo7.service.dto.SondaInstructionDTO;

@Component
public class Instructions {

	@Autowired
	private InstructionParse instructionParse;
	
	public Sonda executeInstructions(Planalto planalto, Sonda sonda, String instructions){
		validateLimitSondaPlanalto(planalto, sonda);
		List<Command> commands = parse(instructions);
		commands.stream().forEach(command -> {
			sonda.move(command);
			if(sonda.getCoordinateX() > planalto.getCoordenadaLimitX()){
				throw new MovimentSondaException("Sonda exceed limit X de planalto: "+sonda.getCoordinateX());
			}
			if(sonda.getCoordinateY() > planalto.getCoordenadaLimitY()){
				throw new MovimentSondaException("Sonda exceed limit Y de planalto: "+sonda.getCoordinateY());
			}
		});	
		return sonda;
	}
	
	public List<Sonda> executeInstructions(Planalto planalto, List<SondaInstructionDTO> sondas){
		List<Sonda> result = new ArrayList<>();
		sondas.forEach(item ->{
			try{
				Sonda sonda = executeInstructions(planalto, item.getSonda(), item.getInstruction());
				result.add(sonda);
			}catch (Exception e) {
				Sonda sonda = new Sonda(item.getSonda().getCoordinateX(), item.getSonda().getCoordinateY(), item.getSonda().getDirection());
				sonda.setMessage(e.getMessage());
				result.add(sonda);
			}			
		});
		return result;
	}
	
	private List<Command> parse(String instructions){
		return instructionParse.parseCommands(instructions);
	}
	
	private void validateLimitSondaPlanalto(Planalto planalto, Sonda sonda){
		if(sonda.getCoordinateX() > planalto.getCoordenadaLimitX()){
			throw new MovimentSondaException("Sonda with coordinate X  greater than Planalto "+sonda.getCoordinateX());
		}
		if(sonda.getCoordinateY() > planalto.getCoordenadaLimitY()){
			throw new MovimentSondaException("Sonda with coordinate Y  greater than Planalto "+sonda.getCoordinateY());
		}
	}
}
