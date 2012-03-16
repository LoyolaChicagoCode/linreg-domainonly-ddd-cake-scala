package points.domain
package services

import java.awt.Color
import objects.Line

/**
 * Abstract component without dependencies.
 * In following the Cake idiom, clients use this trait to express their
 * dependency, which can later be provided by a concrete implementation
 * of this trait.
 */
trait LineFactoryComponent {

  /**
   * Cake idiom: abstract value to be provided by a
   * concrete implementation of this trait.
   */
  val lineFactory: LineFactory

  trait LineFactory {

    def create(slope: Double, yIntercept: Double): Line
  }
}