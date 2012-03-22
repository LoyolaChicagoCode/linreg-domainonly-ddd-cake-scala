package points.domain
package services

import java.awt.Color
import objects._

/**
 * Abstract component without dependencies.
 * Concrete implementations might have dependencies on, say,
 * LineFactoryComponent, which they can express using the Cake idiom.
 * In following the Cake idiom, clients use this trait to express their
 * dependency, which can later be provided by a concrete implementation
 * of this trait.
 */
trait RegressionFactoryComponent {

  /**
   * Cake idiom: factory method to be provided by a
   * concrete implementation of this trait.
   */
  def regressionFactory: RegressionFactory

  trait RegressionFactory {

    def create(slope: Double, yIntercept: Double, points: Iterable[Point]): Regression
  }
}