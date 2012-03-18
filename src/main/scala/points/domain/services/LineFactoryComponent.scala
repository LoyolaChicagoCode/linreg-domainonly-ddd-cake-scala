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
   * Cake idiom: factory method to be provided by a
   * concrete implementation of this trait.
   */
  def lineFactory: LineFactory

  trait LineFactory {

    def create(slope: Double, yIntercept: Double): Line
  }
}