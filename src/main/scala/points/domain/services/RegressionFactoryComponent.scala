package points.domain
package services

import java.awt.Color
import objects._

/**
 * Abstract component with dependencies.
 */
trait RegressionFactoryComponent {

  _: LineFactoryComponent =>

  val regressionFactory: RegressionFactory

  trait RegressionFactory {

    def create(slope: Double, yIntercept: Double, points: Iterable[Point]): Regression
  }
}