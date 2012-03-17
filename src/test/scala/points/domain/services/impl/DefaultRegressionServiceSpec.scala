package points.domain
package services.impl

import java.awt.Color
import org.junit.runner.RunWith
import org.specs2.mutable._
import org.specs2.runner.JUnitRunner
import services.{ RegressionServiceSpec, RegressionServiceComponent }

@RunWith(classOf[JUnitRunner])
class DefaultRegressionServiceSpec extends RegressionServiceSpec
  with DefaultPointFactoryComponent
  with DefaultLineFactoryComponent
  with DefaultRegressionFactoryComponent
  with InMemoryPointRepositoryComponent
  with RegressionServiceComponent {

  val pointRepository = new InMemoryPointRepository
}