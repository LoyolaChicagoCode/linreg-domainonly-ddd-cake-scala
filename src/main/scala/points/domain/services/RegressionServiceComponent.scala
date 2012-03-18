package points.domain
package services

import objects._

/**
 * Abstract component without dependencies.
 * Concrete implementations might have dependencies on, say,
 * PointRepositoryComponent, which they can express using the Cake idiom.
 */
trait RegressionServiceComponent {

  def regressionService: RegressionService

  trait RegressionService {

    def perform(): Regression
  }
}