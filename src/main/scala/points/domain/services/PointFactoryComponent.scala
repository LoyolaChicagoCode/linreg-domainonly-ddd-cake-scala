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
   * Cake idiom: abstract value to be provided by a
   * concrete implementation of this trait.
   */
  val pointFactory: PointFactory

  trait PointFactory {

    def create(x: Double, y: Double, color: Color): Point

    implicit val createPoint = pointFactory.create _
  }
}