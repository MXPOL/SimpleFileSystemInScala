package commands
import files.DirEntry
import filessystem.State

class Ls extends Command {

  override def apply(state: State) : State = {
    val contents = state.wd.contents
    state.setMessage(createOutput(contents))

  }

  def createOutput(contents: List[DirEntry]) : String = {
    if (contents.isEmpty) ""
    else {
      val entry = contents.head
      entry.name + " [" + entry.getType + "]" + "\n"  + createOutput(contents.tail)
    }
  }
}
