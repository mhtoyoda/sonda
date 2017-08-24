package br.com.toyoda.elo7.command;

import org.springframework.stereotype.Component;

import br.com.toyoda.elo7.model.Sonda;

@Component("leftCommand")
public class LeftCommand implements Command {

	@Override
	public Sonda executeCommand(Sonda sonda) {		
		sonda.updateDirection(sonda.getDirection().left());
		return sonda;
	}

}
