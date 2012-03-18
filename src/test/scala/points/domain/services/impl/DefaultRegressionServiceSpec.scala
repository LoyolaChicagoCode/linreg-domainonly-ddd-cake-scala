package points.domain
package services.impl

import org.junit.runner.RunWith
import org.specs2.mutable._
import org.specs2.runner.JUnitRunner
import services.{ RegressionServiceSpec, RegressionServiceComponent }

@RunWith(classOf[JUnitRunner])
class DefaultRegressionServiceSpec extends RegressionServiceSpec
  with DefaultPointFactoryComponent {

  "A regression service" should {
    "not have any points initially" in {
      val subject = setupSubjectInstance
      subject.pointRepository.findAll() should be empty
    }
    "not have any points later" in {
      val subject = setupSubjectInstance
      subject.pointRepository.findAll() should be empty
    }
  }

  def setupSubjectInstance = new DefaultLineFactoryComponent
    with DefaultPointFactoryComponent
    with InMemoryPointRepositoryComponent
    with DefaultRegressionFactoryComponent
    with DefaultRegressionServiceComponent
}