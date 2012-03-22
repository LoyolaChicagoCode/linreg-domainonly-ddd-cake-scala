package points.domain
package services.impl

import scala.collection.mutable.HashMap
import services.{ PointFactoryComponent, PointRepositoryComponent }
import objects.Point

/**
 * Concrete, stateful component without dependencies.
 * For convenience, an instance is provided lazily and extensibly.
 * In following the Cake idiom, clients use this concrete trait to satisfy
 * a dependency on an abstraction of this trait.
 * Simple in-memory implementation that does not require a PointFactory.
 * Not thread-safe! Should wrap within TypedActor to use in Play.
 */
trait InMemoryPointRepositoryComponent extends PointRepositoryComponent {

  /**
   * An instance that gets initialized only if used.
   */
  private lazy val instance = new InMemoryPointRepository

  override def pointRepository = instance

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