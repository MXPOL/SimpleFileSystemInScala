package filessystem

import commands.Command
import files.Directory


object Filesystem  extends App {
  val root = Directory.ROOT
  print(State.SHELL_TOKEN)
  io.Source.stdin.getLines().foldLeft(State(root,root)) ((currentState,newLine) => {
    currentState.show
    Command.from(newLine).apply(currentState)
  })

}
