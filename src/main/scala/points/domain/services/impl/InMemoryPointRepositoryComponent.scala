package points.domain
package services.impl

import scala.collection.mutable.HashMap
import services.{ PointFactoryComponent, PointRepositoryComponent }
import objects.Point

/**
 * Concrete component with dependencies.
 * In following the Cake idiom, clients use this concrete trait to satisfy
 * a dependency on an abstraction of this trait.
 * Simple in-memory implementation.
 * Not thread-safe! Should wrap within TypedActor to use in Play.
 */
trait InMemoryPointRepositoryComponent extends PointRepositoryComponent {

  _: PointFactoryComponent =>

  val pointRepository = newPointRepository

  def newPointRepository = new InMemoryPointRepository

  class InMemoryPointRepository extends PointRepository {

    private val map = new HashMap[Long, Point]

    private var id = 0L

    private def nextId(): Long = { id += 1 ; id }

    def add(p: Point): Long = { val id = nextId() ; map(id) = p ; id }

    def findById(id: Long): Option[Point] = map.get(id)

    def findAll(): Iterable[Point] = map.values

    def remove(id: Long): Boolean =
      map.isDefinedAt(id) && { map -= id ; true }

    def update(id: Long, p: Point): Boolean =
      map.isDefinedAt(id) && { map(id) = p ; true }
  }
}