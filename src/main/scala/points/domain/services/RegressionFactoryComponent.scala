package points.domain
package services

import java.awt.Color
import objects._

/**
 * Abstract component with dependencies.
 * In following the Cake idiom, clients use this trait to express their
 * dependency, which can later be provided by a concrete implementation
 * of this trait along with concrete implementations of the dependencies
 * of this trait.
 */
trait RegressionFactoryComponent {

  /**
   * Cake idiom: dependency declaration for later injection by mixin.
   */
  _: LineFactoryComponent =>

  /**
   * Cake idiom: abstract value to be provided by a
   * concrete implementation of this trait.
   */
  val regressionFactory: RegressionFactory

  trait RegressionFactory {

    def create(slope: Double, yIntercept: Double, points: Iterable[Point]): Regression
  }
}