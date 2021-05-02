package files

class File(override val parentPath : String , override val name: String, contents: String)
  extends DirEntry (parentPath,name){

  override def asDirectory: Directory = throw new FileSystemException("A file canot converted to a directory!")

  override def asFile: File = this
  override def isDirectory: Boolean = false
  override def isFile: Boolean = true

  def getType: String = "File"


}
object File{
  def empty(parentPath: String, name:String) : File =
    new File(parentPath,name,"")
}
