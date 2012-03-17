package points.domain
package services

import java.awt.Color
import org.specs2.mutable._

/**
 * Testcase superclass xUnit pattern.
 * This trait can be mixed in with a concrete dependency
 * to build a concrete spec.
 */
trait RegressionServiceSpec extends Specification {

  /**
   * Cake idiom: dependency declaration for later injection by mixin.
   */
  _: PointFactoryComponent
  with PointRepositoryComponent
  with RegressionServiceComponent =>

  "A regression service" should {
    "compute a simple regression line" in {
      val i1 = pointRepository.add(p1)
      val i2 = pointRepository.add(p2)
      val r = regressionService.perform()
      (r.line.slope, r.line.yIntercept) should be equalTo (1, 1)
    }
  }

  val regressionService = new RegressionService

  val p1 = pointFactory.create(1, 2, Color.GREEN)
  val p2 = pointFactory.create(2, 3, Color.RED)
}
