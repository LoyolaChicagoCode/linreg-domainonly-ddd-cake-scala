package points.domain
package services

import objects.Point

/**
 * Abstract component with dependencies.
 */
trait PointRepositoryComponent {

  _: PointFactoryComponent =>

  val pointRepository: PointRepository

  trait PointRepository {

    def add(p: Point): Long

    def findById(id: Long): Point

    def findAll(): Iterable[Point]

    def remove(id: Long): Unit

    def update(id: Long, p: Point)
  }
}