package points.domain
package services

import java.awt.Color
import objects.Point

/**
 * Abstract component without dependencies.
 */
trait PointFactoryComponent {

  val pointFactory: PointFactory

  trait PointFactory {

    def create(x: Double, y: Double, color: Color): Point

    implicit val createPoint = pointFactory.create _
  }
}