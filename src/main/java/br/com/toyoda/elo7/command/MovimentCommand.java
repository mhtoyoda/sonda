package br.com.toyoda.elo7.command;

import org.springframework.stereotype.Component;

import br.com.toyoda.elo7.model.Sonda;

@Component("movimentCommand")
public class MovimentCommand implements Command {

	@Override
	public Sonda executeCommand(Sonda sonda) {
		return sonda.getDirection().moviment(sonda);
	}
}
