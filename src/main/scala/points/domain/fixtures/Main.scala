package points.domain
package fixtures

import java.awt.Color
import services.RegressionServiceComponent
import services.impl._

/**
 * Simple main object for verifying the basic functioning of this code.
 * In following the Cake idiom, this object instantiates the service
 * with its required dependencies, then uses the functionality of the
 * service.
 */
object Main extends RegressionServiceComponent
  with DefaultPointFactoryComponent
  with DefaultLineFactoryComponent
  with InMemoryPointRepositoryComponent
  with DefaultRegressionFactoryComponent {

  // bring implicit factory method into scope
  // for operations on Point that require it
  import pointFactory.createPoint

  def main(args: Array[String]) {
    val p1 = createPoint(3, 4, Color.ORANGE) * 7
    val p2 = p1 + p1
    val i1 = pointRepository.add(p1)
    val i2 = pointRepository.add(p2)
    val r = regressionService.perform()
    println(r)
  }
}
