package ppjvm.format

import scalariform.formatter.preferences._
import scalariform.formatter.ScalaFormatter
import scalariform.parser.ScalaParserException

// TODO: rewrite this in java?
object ScalaFormat {
  val preferences = FormattingPreferences()
    .setPreference(DoubleIndentClassDeclaration, true)

  // TODO: make settings an Option[String] pass for customization
  // TODO: we don't use tipe!
  def formatScala(input: String, tipe: String): String = {
    try {
      ScalaFormatter.format(input, preferences)
    } catch {
         case e: ScalaParserException =>
           throw new Exception("Syntax error in Scala source")
    }
  }
}