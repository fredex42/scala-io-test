/**
  * Created by andy on 06/11/16.
  */
import org.apache.logging.log4j.LogManager
import scala.io.Source

object mainclass extends ExternalCommand {
  val l4j = LogManager.getLogger("mainclass")

  def main(args: Array[String]):Unit = {
    type OptionMap = Map[Symbol, String]
    l4j.info("Starting up")
    this.runCommand("/bin/ls",Seq("ls","-lh"))
    l4j.info("main finished")
  }

  override def outputHandler(input:java.io.InputStream) = {

    for(line <- Source.fromInputStream(input).getLines()){
      l4j.debug("output: " + line)
    }
  }

  override def errHandler(input:java.io.InputStream) = {
    for(line <- Source.fromInputStream(input).getLines()){
      l4j.debug("error: " + line)
    }
  }
}
