package points.domain
package services.impl

import scala.collection.mutable.HashMap
import services.{ PointFactoryComponent, PointRepositoryComponent }
import objects.Point

/**
 * Concrete component with dependencies.
 * Non-configurable singleton.
 * Simple in-memory implementation.
 * Not thread-safe! Should wrap within TypedActor to use in Play.
 */
trait InMemoryPointRepositoryComponent extends PointRepositoryComponent {

  _: PointFactoryComponent =>

  object pointRepository extends PointRepository {

    private val map = new HashMap[Long, Point]

    private var id = 0L

    private def nextId(): Long = { id += 1 ; id }

    def add(p: Point): Long = { val id = nextId() ; map(id) = p ; id }

    def findById(id: Long): Point = map(id)

    def findAll(): Iterable[Point] = map.values

    def remove(id: Long): Unit = map -= id

    def update(id: Long, p: Point) = map(id) = p
  }
}