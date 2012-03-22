package points.domain
package services.impl

import java.awt.Color
import objects._
import services.{ LineFactoryComponent, RegressionFactoryComponent }

/**
 * Concrete, sealed, stateless, non-configurable component with dependencies.
 * Implemented as a singleton object.
 * In following the Cake idiom, clients use this concrete trait to satisfy
 * a dependency on an abstraction of this trait.
 */
trait DefaultRegressionFactoryComponent extends RegressionFactoryComponent {

  _: LineFactoryComponent =>

  override object regressionFactory extends RegressionFactory {

    sealed case class DefaultRegression(line: Line, points: Iterable[Point]) extends Regression

    def create(slope: Double, yIntercept: Double, points: Iterable[Point]) =
      DefaultRegression(lineFactory.create(slope, yIntercept), points)
  }
}