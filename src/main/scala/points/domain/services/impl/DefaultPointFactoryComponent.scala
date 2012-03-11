package points.domain
package services.impl

import java.awt.Color
import objects.Point
import services.PointFactoryComponent

/**
 * Concrete component without dependencies.
 * Non-configurable singleton.
 */
trait DefaultPointFactoryComponent extends PointFactoryComponent {

  object pointFactory extends PointFactory {

    sealed case class DefaultPoint(x: Double, y: Double, color: Color) extends Point

    def create(x: Double, y: Double, color: Color) = DefaultPoint(x, y, color)
  }
}