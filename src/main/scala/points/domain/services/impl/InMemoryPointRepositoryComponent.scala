package points.domain
package services.impl

import scala.collection.mutable.HashMap
import services.{ PointFactoryComponent, PointRepositoryComponent, PointRepository }
import objects.Point

/**
 * Concrete, stateful component without dependencies.
 * For convenience, a default shared instance is provided lazily and extensibly.
 * In following the Cake idiom, clients use this concrete trait to satisfy
 * a dependency on an abstraction of this trait.
 * Simple in-memory implementation that does not require a PointFactory.
 * Not thread-safe! Should wrap within TypedActor to use in Play.
 */
trait InMemoryPointRepositoryComponent extends PointRepositoryComponent {

  override def pointRepository = defaultInstanceContainer.instance
}

private object defaultInstanceContainer {
  /**
   * An instance that gets initialized only if used.
   */
  lazy val instance = new InMemoryPointRepository
}

/**
 * Point repository implementation class.
 * To enable sharing of instances across clients,
 * this class is defined at the top-level.
 * Such sharing is equivalent to singleton scope.
 */
class InMemoryPointRepository extends PointRepository {

  private val map = new HashMap[Long, Point]

  private var id = 0L

  private def nextId(): Long = { id += 1 ; id }

  override def add(p: Point): Long = { val id = nextId() ; map(id) = p ; id }

  override def findById(id: Long): Option[Point] = map.get(id)

  override def findAll(): Iterable[Point] = map.values

  override def remove(id: Long): Boolean =
    map.isDefinedAt(id) && { map -= id ; true }

  override def update(id: Long, p: Point): Boolean =
    map.isDefinedAt(id) && { map(id) = p ; true }
}
