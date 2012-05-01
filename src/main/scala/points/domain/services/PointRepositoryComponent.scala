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
   * Cake idiom: factory method to be provided by a
   * concrete implementation of this trait.
   */
  def pointRepository: PointRepository
}

/**
 * Point repository abstraction. To enable sharing of instances
 * across clients, this trait is defined at the top level.
 * Such sharing is equivalent to singleton scope.
 */
trait PointRepository {

  def add(p: Point): Long

  def findById(id: Long): Option[Point]

  def findAll(): Iterable[Point]

  def remove(id: Long): Boolean

  def update(id: Long, p: Point): Boolean
}
