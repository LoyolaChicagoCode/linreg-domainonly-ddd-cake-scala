package points.domain
package services

import java.awt.Color
import org.specs2.mutable._

/**
 * Testcase superclass xUnit pattern.
 * This trait can be mixed in with a concrete dependency
 * to build a concrete spec.
 */
trait PointRepositorySpec extends Specification {

  /**
   * Cake idiom: dependency declaration for later injection by mixin.
   */
  _: PointFactoryComponent with PointRepositoryComponent =>

  "A point repository" should {
    "be initially empty" in {
      val r = pointRepository
      r.findAll must be empty
    }
    "find a newly added point by ID" in {
      val r = pointRepository
      val s = r.findAll size
      val id = r.add(p1)
      (r.findById(id), r.findAll size) should be equalTo (Some(p1), s + 1)
    }
    "not find a newly added point by ID after it is removed" in {
      val r = pointRepository
      val s = r.findAll size
      val id = r.add(p1)
      r.remove(id)
      (r.findById(id), r.findAll size) should be equalTo (None, s)
    }
    "handle the addition of multiple points" in {
      val r = pointRepository
      r.add(p1)
      r.add(p2)
      r.findAll must contain(p1, p2)
    }
    "handle the removal of multiple points" in {
      val r = pointRepository
      val i1 = r.add(p1)
      val i2 = r.add(p2)
      r.remove(i1)
      r.remove(i2)
      r.findAll must not contain(p1, p2)
    }
  }

  val p1 = pointFactory.create(1, 2, Color.GREEN)
  val p2 = pointFactory.create(3, 4, Color.RED)
}
