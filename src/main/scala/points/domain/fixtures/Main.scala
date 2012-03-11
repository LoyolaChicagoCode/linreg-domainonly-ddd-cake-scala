package points.domain
package fixtures

import java.awt.Color
import services.RegressionServiceComponent
import services.impl._

// instantiate the service with its required dependencies
object Main extends RegressionServiceComponent
  with InMemoryPointRepositoryComponent
  with DefaultPointFactoryComponent
  with DefaultLineFactoryComponent
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
