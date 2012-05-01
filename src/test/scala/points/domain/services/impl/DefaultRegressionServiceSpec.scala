package points.domain
package services.impl

import java.awt.Color
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
    "compute another simple regression line" in {
      val subject = setupSubjectInstance
      val i1 = subject.pointRepository.add(pointFactory.create(1, 4, Color.GREEN))
      val i2 = subject.pointRepository.add(pointFactory.create(2, 7, Color.RED))
      val r = subject.regressionService.perform()
      (r.line.slope, r.line.yIntercept) should be equalTo (3, 1)
    }
    "not have any points later" in {
      val subject = setupSubjectInstance
      subject.pointRepository.findAll() should be empty
    }
  }

  override def setupSubjectInstance = new DefaultLineFactoryComponent
    with DefaultPointFactoryComponent
    with InMemoryPointRepositoryComponent
    with DefaultRegressionFactoryComponent
    with DefaultRegressionServiceComponent {
    // use val to ensure one repository instance per subject instance
    override val pointRepository = new InMemoryPointRepository
  }
}
