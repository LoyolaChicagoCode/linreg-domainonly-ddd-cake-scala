package points.domain
package services.impl

import org.junit.runner.RunWith
import org.specs2.mutable._
import org.specs2.mock._
import org.specs2.runner.JUnitRunner
import services._

// TODO expand the use of Mockito in this spec

@RunWith(classOf[JUnitRunner])
class MockitoRegressionServiceSpec extends RegressionServiceSpec
  with DefaultPointFactoryComponent {

  override def setupSubjectInstance = new DefaultLineFactoryComponent
    with DefaultPointFactoryComponent
    with PointRepositoryComponent
    with DefaultRegressionFactoryComponent
    with DefaultRegressionServiceComponent
    with Mockito {
    // implement factory method with mock repository
    override val pointRepository = mock[PointRepository]
    pointRepository.findAll() returns Iterable(p1, p2)
  }
}
