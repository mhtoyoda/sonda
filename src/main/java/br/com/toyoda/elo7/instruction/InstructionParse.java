package br.com.toyoda.elo7.instruction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.toyoda.elo7.command.Command;
import br.com.toyoda.elo7.exception.InstructionsException;

@Component
public class InstructionParse {

	@Autowired
	@Qualifier("movimentCommand")
	private Command movimentCommand;
	
	@Autowired
	@Qualifier("leftCommand")
	private Command leftCommand;
		
	@Autowired
	@Qualifier("rightCommand")
	private Command rightCommand;
	
	public List<Command> parseCommands(String instructions){
		List<Command> commands = new ArrayList<>();
		for(int i = 0; i < instructions.length(); i++){
			char instruction = instructions.charAt(i);
			if(instruction == 'L'){
				commands.add(leftCommand);
			}else if(instruction == 'R'){
				commands.add(rightCommand);
			}else if(instruction == 'M'){
				commands.add(movimentCommand);
			}else{
				throw new InstructionsException("Invalid Instruction "+instruction);
			}
		}
		return commands;
	}
}