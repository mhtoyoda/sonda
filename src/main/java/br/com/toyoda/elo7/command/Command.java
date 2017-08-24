package br.com.toyoda.elo7.command;

import br.com.toyoda.elo7.model.Sonda;

public interface Command {

	public Sonda executeCommand(Sonda sonda);
}
