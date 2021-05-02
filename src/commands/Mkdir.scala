package commands

import files.{DirEntry, Directory}
import filessystem.State

class Mkdir(name: String) extends CreateEntry(name) {

  override def createSpecificEntry(state: State): DirEntry =
    Directory.empty(state.wd.path, name)

}


