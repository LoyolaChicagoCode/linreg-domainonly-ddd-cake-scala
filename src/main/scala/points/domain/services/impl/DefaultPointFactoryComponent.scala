package points.domain
package services.impl

import java.awt.Color
import objects.Point
import services.PointFactoryComponent

/**
 * Concrete, sealed, stateless, non-configurable component without dependencies.
 * Implemented as a singleton object.
 * In following the Cake idiom, clients use this concrete trait to satisfy
 * a dependency on an abstraction of this trait.
 */
trait DefaultPointFactoryComponent extends PointFactoryComponent {

  override object pointFactory extends PointFactory {

    sealed case class DefaultPoint(x: Double, y: Double, color: Color) extends Point

    def create(x: Double, y: Double, color: Color) = DefaultPoint(x, y, color)
  }
}