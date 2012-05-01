package points.domain
package services

import objects._

/**
 * Abstract component without dependencies.
 * Concrete implementations might have dependencies on, say,
 * PointRepositoryComponent, which they can express using the Cake idiom.
 */
trait CenterOfGravityServiceComponent {

  def centerOfGravityService: CenterOfGravityService

  trait CenterOfGravityService {

    def perform(): Point
  }
}