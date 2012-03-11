package points.domain
package services.impl

import java.awt.Color
import objects._
import services.{ LineFactoryComponent, RegressionFactoryComponent }

/**
 * Concrete component without dependencies.
 * Non-configurable singleton.
 */
trait DefaultRegressionFactoryComponent extends RegressionFactoryComponent {

  _: LineFactoryComponent =>

  object regressionFactory extends RegressionFactory {

    sealed case class DefaultRegression(line: Line, points: Iterable[Point]) extends Regression

    def create(slope: Double, yIntercept: Double, points: Iterable[Point]) =
      DefaultRegression(lineFactory.create(slope, yIntercept), points)
  }
}