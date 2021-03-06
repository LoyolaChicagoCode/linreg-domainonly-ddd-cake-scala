package points.domain
package services.impl

import java.awt.Color
import org.junit.runner.RunWith
import org.specs2.mutable._
import org.specs2.runner.JUnitRunner
import services.PointFactorySpec

@RunWith(classOf[JUnitRunner])
class DefaultPointFactorySpec extends PointFactorySpec
  with DefaultPointFactoryComponent
