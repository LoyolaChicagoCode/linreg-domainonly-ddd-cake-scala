package points.domain
package services.impl

import java.awt.Color
import objects._
import services.{ LineFactoryComponent, RegressionFactoryComponent }

/**
 * Concrete component without dependencies.
 * In following the Cake idiom, clients use this concrete trait to satisfy
 * a dependency on an abstraction of this trait.
 * Stateless, non-configurable singleton provided as object.
 */
trait DefaultRegressionFactoryComponent extends RegressionFactoryComponent {

  _: LineFactoryComponent =>

  object regressionFactory extends RegressionFactory {

    sealed case class DefaultRegression(line: Line, points: Iterable[Point]) extends Regression

    def create(slope: Double, yIntercept: Double, points: Iterable[Point]) =
      DefaultRegression(lineFactory.create(slope, yIntercept), points)
  }
}