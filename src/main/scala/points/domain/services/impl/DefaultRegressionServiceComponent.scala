package points.domain
package services.impl

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
trait DefaultRegressionServiceComponent extends RegressionServiceComponent {

  /**
   * Cake idiom: dependency declaration for later injection by mixin.
   */
  _: PointRepositoryComponent with RegressionFactoryComponent =>

  override object regressionService extends RegressionService {

    private def forPoint(acc: (Double, Double, Double, Double, Double), p: Point) =
      (acc._1 + p.x, acc._2 + p.y, acc._3 + p.x * p.x, acc._4 + p.x * p.y, acc._5 + p.y * p.y)

    def perform(): Regression = {
      val points = pointRepository.findAll()
      val (sumx, sumy, sumxx, sumxy, sumyy) = points.foldLeft((0.0, 0.0, 0.0, 0.0, 0.0))(forPoint _)
      val n = points.size
      val sxx = sumxx - sumx * sumx / n
      val sxy = sumxy - sumx * sumy / n
      val slope = sxy / sxx
      val yIntercept = (sumy - slope * sumx) / n
      regressionFactory.create(slope, yIntercept, points)
    }
  }
}