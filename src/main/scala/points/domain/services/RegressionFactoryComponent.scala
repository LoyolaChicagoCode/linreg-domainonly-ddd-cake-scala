package points.domain
package services

import java.awt.Color
import objects._

/**
 * Abstract component without dependencies.
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