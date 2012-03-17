package points.domain
package services

import objects.Point

/**
 * Abstract component without dependencies.
 * Concrete implementations might have dependencies on, say,
 * PointFactoryComponent, which they can express using the Cake idiom.
 */
trait PointRepositoryComponent {

  /**
   * Cake idiom: abstract value to be provided by a
   * concrete implementation of this trait.
   */
  val pointRepository: PointRepository

  trait PointRepository {

    def add(p: Point): Long

    def findById(id: Long): Option[Point]

    def findAll(): Iterable[Point]

    def remove(id: Long): Boolean

    def update(id: Long, p: Point): Boolean
  }
}