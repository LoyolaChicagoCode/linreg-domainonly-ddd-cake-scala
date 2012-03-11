package points.domain
package services.impl

import java.awt.Color
import objects.Line
import services.LineFactoryComponent

/**
 * Concrete component without dependencies.
 * Non-configurable singleton.
 */
trait DefaultLineFactoryComponent extends LineFactoryComponent {

  object lineFactory extends LineFactory {

    sealed case class DefaultLine(slope: Double, yIntercept: Double) extends Line

    def create(slope: Double, yIntercept: Double) = DefaultLine(slope, yIntercept)
  }
}