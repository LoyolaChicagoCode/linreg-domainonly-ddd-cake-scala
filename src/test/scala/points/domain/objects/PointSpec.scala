package points.domain
package objects

import java.awt.Color
import org.specs2.mutable._
import services.PointFactoryComponent

/**
 * Testcase superclass xUnit pattern.
 * This trait can be mixed in with a concrete dependency
 * to build a concrete spec.
 */
trait PointSpec extends Specification {

  /**
   * Cake idiom: dependency declaration for later injection by mixin.
   */
  _: PointFactoryComponent =>

  "A color point" should {
    "have the expected x value" in { p1.x must beEqualTo(x) }
    "have the expected y value" in { p1.y must beEqualTo(y) }
    "have the expected color value" in { p1.color must beEqualTo(c) }
    "scale up correctly along the x dimension" in { p3.x must beEqualTo(x * f1) }
    "scale up correctly along the y dimension" in { p3.y must beEqualTo(y * f1) }
    "scale up without change to its color" in { p3.color must beEqualTo(c) }
    "scale down correctly along the x dimension" in { p5.x must beEqualTo(x * f2) }
    "scale down correctly along the y dimension" in { p5.y must beEqualTo(y * f2) }
    "scale down without change to its color" in { p5.color must beEqualTo(c) }
    "transpose correctly along the x dimension" in { p7.x must beEqualTo(p1.x + p3.x) }
    "transpose correctly along the y dimension" in { p7.y must beEqualTo(p1.y + p3.y) }
    "transpose without change to its color" in { p7.color must beEqualTo(p1.color) }
    "be equal to itself" in { p1 must beEqualTo(p1) }
    "not be equal to other points" in {
      forall(Iterable(p3, p5, p7)) { p: Point => p must not be equalTo(p1) }
    }
  }

  implicit val create = pointFactory.create _

  val x = 1
  val y = 2
  val c = Color.GREEN
  val f1 = 3
  val f2 = 0.5

  lazy val p1 = create(x, y, c)
  lazy val p3 = p1 * f1
  lazy val p5 = p1 * f2
  lazy val p7 = p1 + p3
}
