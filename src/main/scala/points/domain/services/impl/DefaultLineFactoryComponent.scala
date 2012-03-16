package points.domain
package services.impl

import java.awt.Color
import objects.Line
import services.LineFactoryComponent

/**
 * Concrete component without dependencies.
 * In following the Cake idiom, clients use this concrete trait to satisfy
 * a dependency on an abstraction of this trait.
 * Stateless, non-configurable singleton provided as object.
 */
trait DefaultLineFactoryComponent extends LineFactoryComponent {

  object lineFactory extends LineFactory {

    sealed case class DefaultLine(slope: Double, yIntercept: Double) extends Line

    def create(slope: Double, yIntercept: Double) = DefaultLine(slope, yIntercept)
  }
}