package points.domain
package services

import java.awt.Color
import org.specs2.mutable._

/**
 * Testcase superclass xUnit pattern.
 * This trait can be mixed in with a concrete dependency
 * to build a concrete spec.
 */
trait PointFactorySpec extends Specification {

  /**
   * Cake idiom: dependency declaration for later injection by mixin.
   */
  _: PointFactoryComponent =>

  "A point factory" should {
    "create a point with the desired x value" in { p1.x must beEqualTo(x) }
    "create a point with the desired y value" in { p1.y must beEqualTo(y) }
    "create a point with the desired color value" in { p1.color must beEqualTo(c) }
  }

  val x = 1
  val y = 2
  val c = Color.GREEN
  val p1 = pointFactory.create(x, y, c)
}