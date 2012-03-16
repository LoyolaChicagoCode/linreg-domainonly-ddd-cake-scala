package points.domain
package services

import objects.Point

/**
 * Abstract component with dependencies.
 * In following the Cake idiom, clients use this trait to express their
 * dependency, which can later be provided by a concrete implementation
 * of this trait along with concrete implementations of the dependencies
 * of this trait.
 * Stateful component requires a factory method to facilitate testing.
 */
trait PointRepositoryComponent {

  /**
   * Cake idiom: dependency declaration for later injection by mixin.
   */
  _: PointFactoryComponent =>

  /**
   * Cake idiom: abstract value to be provided by a
   * concrete implementation of this trait.
   */
  val pointRepository: PointRepository

  def newPointRepository: PointRepository

  trait PointRepository {

    def add(p: Point): Long

    def findById(id: Long): Option[Point]

    def findAll(): Iterable[Point]

    def remove(id: Long): Boolean

    def update(id: Long, p: Point): Boolean
  }
}