package commands
import files.DirEntry
import files.File
import filessystem.State

class Touch(name: String) extends CreateEntry(name){
  override def createSpecificEntry(state: State): DirEntry =
    File.empty(state.wd.path,name)
}
