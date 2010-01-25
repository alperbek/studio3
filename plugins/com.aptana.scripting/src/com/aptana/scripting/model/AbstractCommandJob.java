package com.aptana.scripting.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractCommandJob extends AbstractScriptJob
{
	private CommandElement _command;
	private CommandContext _context;
	private boolean _executedSuccessfully;
	private CommandResult _result;
	private Map<String, String> _contributedEnvironment;

	/**
	 * AbstractCommandJob
	 * 
	 * @param name
	 * @param command
	 * @param context
	 * @param loadPaths
	 */
	public AbstractCommandJob(String name, CommandElement command, CommandContext context, List<String> loadPaths)
	{
		super(name, loadPaths);

		this._command = command;
		this._context = context;
		this._contributedEnvironment = new HashMap<String, String>();
		this._command.populateEnvironment(this._context.getMap(), this._contributedEnvironment);
	}

	/**
	 * getCommand
	 * 
	 * @return
	 */
	public CommandElement getCommand()
	{
		return this._command;
	}

	/**
	 * getCommandResult
	 * 
	 * @return
	 */
	public CommandResult getCommandResult()
	{
		return this._result;
	}

	/**
	 * getContext
	 * 
	 * @return
	 */
	public CommandContext getContext()
	{
		return this._context;
	}

	/**
	 * getContributedEnvironment
	 * 
	 * @return
	 */
	public Map<String, String> getContributedEnvironment()
	{
		return this._contributedEnvironment;
	}

	/**
	 * getExecutedSuccessfully
	 */
	protected boolean getExecutedSuccessfully()
	{
		return this._executedSuccessfully;
	}

	/**
	 * setCommandResult
	 * 
	 * @param result
	 */
	protected void setCommandResult(CommandResult result)
	{
		this._result = result;
	}

	/**
	 * setExecutedSuccessfully
	 * 
	 * @param value
	 */
	protected void setExecutedSuccessfully(boolean value)
	{
		this._executedSuccessfully = value;
	}
}
