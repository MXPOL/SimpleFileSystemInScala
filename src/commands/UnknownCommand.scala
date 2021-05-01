package commands

import filessystem.State

class UnknownCommand extends Command {
  val COMMAND_NOT_FOUND = "Command not found!"
  override def apply(state: State): State = state.setMessage(COMMAND_NOT_FOUND)
}
