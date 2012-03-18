package points.domain
package fixtures

import java.awt.Color
import services.impl._

/**
 * Simple main object for verifying the basic functioning of this code.
 * In following the Cake idiom, this object instantiates the service
 * with its required dependencies, then uses the functionality of the
 * service.
 */
object Main {

  def main(args: Array[String]) {

    // assemble top-level component
    object assembly
      extends DefaultLineFactoryComponent
      with DefaultPointFactoryComponent
      with InMemoryPointRepositoryComponent
      with DefaultRegressionFactoryComponent
      with DefaultRegressionServiceComponent

    // bring repository and service into scope
    import assembly._

    // bring implicit factory method into scope
    // for operations on Point that require it
    implicit val createPoint = pointFactory.create _

    val p1 = createPoint(3, 4, Color.ORANGE) * 7
    val p2 = p1 + p1
    val i1 = pointRepository.add(p1)
    val i2 = pointRepository.add(p2)
    val r = regressionService.perform()
    println(r)
  }
}
