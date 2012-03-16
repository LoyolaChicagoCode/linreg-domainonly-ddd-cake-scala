package points.domain
package services.impl

import java.awt.Color
import objects.Point
import services.PointFactoryComponent

/**
 * Concrete component without dependencies.
 * In following the Cake idiom, clients use this concrete trait to satisfy
 * a dependency on an abstraction of this trait.
 * Stateless, non-configurable singleton provided as object.
 */
trait DefaultPointFactoryComponent extends PointFactoryComponent {

  object pointFactory extends PointFactory {

    sealed case class DefaultPoint(x: Double, y: Double, color: Color) extends Point

    def create(x: Double, y: Double, color: Color) = DefaultPoint(x, y, color)
  }
}