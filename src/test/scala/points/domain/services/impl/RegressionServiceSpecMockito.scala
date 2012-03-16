package points.domain
package services.impl

import java.awt.Color
import org.junit.runner.RunWith
import org.specs2.mutable._
import org.specs2.mock._
import org.specs2.runner.JUnitRunner
import services._

// TODO expand the use of Mockito in this spec

@RunWith(classOf[JUnitRunner])
class RegressionServiceSpecMockito extends RegressionServiceSpec
  with DefaultPointFactoryComponent
  with DefaultLineFactoryComponent
  with PointRepositoryComponent
  with DefaultRegressionFactoryComponent
  with RegressionServiceComponent
  with Mockito {

  val pointRepository = newPointRepository

  def newPointRepository = mock[PointRepository]

  pointRepository.findAll() returns Iterable(p1, p2)

}