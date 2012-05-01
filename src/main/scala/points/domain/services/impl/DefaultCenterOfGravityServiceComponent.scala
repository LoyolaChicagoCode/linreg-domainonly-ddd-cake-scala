package points.domain
package services.impl

import java.awt.Color
import objects._
import services._

/**
 * Concrete, stateless component with several dependencies.
 * For convenience, an instance is provided lazily and extensibly.
 * This component may have stateful concrete dependencies.
 * In following the Cake idiom, clients intending to use this component
 * must mix in concrete implementations of this component's dependencies.
 * See [[fixtures.Main]] for such a client.
 */
trait DefaultCenterOfGravityServiceComponent extends CenterOfGravityServiceComponent {

  /**
   * Cake idiom: dependency declaration for later injection by mixin.
   */
  _: PointRepositoryComponent with PointFactoryComponent =>

  override object centerOfGravityService extends CenterOfGravityService {

    def perform(): Point = {
      val points = pointRepository findAll
      val (sumx, sumy) = (points map { _ x } sum, points map { _ y } sum)
      val n = points size

      pointFactory.create(sumx / n, sumy / n, Color.black)
    }
  }
}