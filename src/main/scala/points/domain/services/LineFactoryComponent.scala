package points.domain
package services

import java.awt.Color
import objects.Line

/**
 * Abstract component without dependencies.
 */
trait LineFactoryComponent {

  val lineFactory: LineFactory

  trait LineFactory {

    def create(slope: Double, yIntercept: Double): Line
  }
}