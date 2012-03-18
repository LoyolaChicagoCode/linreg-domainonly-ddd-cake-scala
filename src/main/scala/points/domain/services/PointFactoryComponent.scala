package points.domain
package services

import java.awt.Color
import objects.Point

/**
 * Abstract component without dependencies.
 * In following the Cake idiom, clients use this trait to express their
 * dependency, which can later be provided by a concrete implementation
 * of this trait.
 */
trait PointFactoryComponent {

  /**
   * Cake idiom: factory method to be provided by a
   * concrete implementation of this trait.
   */
  def pointFactory: PointFactory

  trait PointFactory {

    def create(x: Double, y: Double, color: Color): Point
  }
}