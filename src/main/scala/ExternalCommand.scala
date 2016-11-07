import java.lang.reflect.Field

import org.apache.logging.log4j.LogManager

import scala.sys.process._

/**
  * Created by localhome on 26/10/2016.
  */
trait ExternalCommand {
  private val localLogger = LogManager.getLogger("externalcommand")
  def outputHandler(input: java.io.InputStream) = {}
  def errHandler(input: java.io.InputStream) = {}

  def runCommand(scriptpath:String,args:Seq[String]):Boolean = {
    val cmd:Seq[String]= scriptpath +: args

    localLogger.debug(s"Running $cmd")
    val process = Process(cmd)
    val pd = process run new ProcessIO(_.close(),outputHandler,errHandler)
    getPID(pd) match {
      case Some(pid)=>localLogger.debug(s"Process ID is $pid")
      case None=>localLogger.error("Unable to determine PID")
    }

    true
  }

  def getPID(process:Process):Option[Int] = {
    try {
      localLogger.debug("process type is " + process.getClass.getName)

      val f:Field = process.getClass.getDeclaredField("pid")
      f.setAccessible(true)
      Some(f.getInt())
    } catch {
      case e:Throwable=>
        localLogger.error(e.getClass.getName + ": " + e.getMessage)
        None
    }
  }
}