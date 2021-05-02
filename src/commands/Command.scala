package commands

import filessystem.State

trait Command extends (State => State){
}

object Command{
  val MKDIR ="mkdir"
  val LS = "ls"
  val PWD = "pwd"
  val TOUCH = "touch"
  val CD = "cd"
  val RM = "rm"
  val ECHO ="echo"

  def emptyCommand:Command = new Command {
    override def apply(state: State): State = state
  }
  def incompleteCommand(name:String) = new Command {
    override def apply(state: State): State = state.setMessage(name +" :incomplete command!")
  }
  def from(input:String) : Command ={
    val tokens : Array[String] = input.split(" ")
    if (input.isEmpty || tokens.isEmpty) emptyCommand
    else tokens(0) match {
      case MKDIR =>
        if (tokens.length < 2) incompleteCommand(MKDIR)
        else new Mkdir(tokens(1))
      case LS =>
        new Ls
      case PWD =>
        new Pwd
      case TOUCH =>
        new Touch(tokens(1))
      case CD =>
        new Cd(tokens(1))
      case RM =>
        if (tokens.length < 2) incompleteCommand(RM)
        else new Rm(tokens(1))
      case ECHO =>
        if (tokens.length < 2) incompleteCommand(ECHO)
        else new Echo(tokens.tail)
      case _ =>
        new UnknownCommand

    }
  }
}
