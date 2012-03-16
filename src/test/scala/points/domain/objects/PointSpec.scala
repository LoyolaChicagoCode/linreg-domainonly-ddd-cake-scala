package points.domain
package objects

import java.awt.Color
import org.specs2.mutable._
import services.PointFactoryComponent

/**
 * Testcase superclass xUnit pattern.
 * This trait can be mixed in with a concrete dependency
 * to build a concrete spec.
 */
trait PointSpec extends Specification {

  /**
   * Cake idiom: dependency declaration for later injection by mixin.
   */
  _: PointFactoryComponent =>

  "A color point" should {
    "have the expected x value" in { p1.x must beEqualTo(x) }
    "have the expected y value" in { p1.y must beEqualTo(y) }
    "have the expected color value" in { p1.color must beEqualTo(c) }
    "scale up correctly along the x dimension" in { p3.x must beEqualTo(x * f1) }
    "scale up correctly along the y dimension" in { p3.y must beEqualTo(y * f1) }
    "scale up without change to its color" in { p3.color must beEqualTo(c) }
    "scale down correctly along the x dimension" in { p5.x must beEqualTo(x * f2) }
    "scale down correctly along the y dimension" in { p5.y must beEqualTo(y * f2) }
    "scale down without change to its color" in { p5.color must beEqualTo(c) }
    "transpose correctly along the x dimension" in { p7.x must beEqualTo(p1.x + p3.x) }
    "transpose correctly along the y dimension" in { p7.y must beEqualTo(p1.y + p3.y) }
    "transpose without change to its color" in { p7.color must beEqualTo(p1.color) }
    "be equal to itself" in { p1 must beEqualTo(p1) }
    "not be equal to other points" in {
      forall(Iterable(p3, p5, p7)) { p: Point => p must not be equalTo(p1) }
    }
  }

  implicit val create = pointFactory.create _

  val x = 1
  val y = 2
  val c = Color.GREEN
  val f1 = 3
  val f2 = 0.5

  lazy val p1 = create(x, y, c)
  lazy val p3 = p1 * f1
  lazy val p5 = p1 * f2
  lazy val p7 = p1 + p3
}

//	public void testConstructor() {
//		Point p = new DefaultPoint(1, 2, Color.GREEN);
//		assertEquals(1.0, p.getX(), Double.MIN_NORMAL);
//		assertEquals(2.0, p.getY(), Double.MIN_NORMAL);
//		assertEquals(Color.GREEN, p.getColor());
//	}
//
//	@Test
//	public void testClone() {
//		DefaultPoint q = new DefaultPoint(1, 2, Color.GREEN);
//		Point p = q.clone();
//		assertFalse(p == q);
//		assertEquals(q, p);
//		assertEquals(1.0, p.getX(), Double.MIN_NORMAL);
//		assertEquals(2.0, p.getY(), Double.MIN_NORMAL);
//		assertEquals(Color.GREEN, p.getColor());
//	}
//
//	@Test
//	public void testSetId() {
//		DefaultPoint p = new DefaultPoint(0, 0, Color.BLUE);
//		p.setId(77);
//		assertEquals(77, p.getId());
//	}
//
//	@Test
//	public void testSetX() {
//		DefaultPoint p = new DefaultPoint(0, 0, Color.BLUE);
//		p.setX(7);
//		assertEquals(7, p.getX(), 0);
//	}
//
//	@Test
//	public void testSetY() {
//		DefaultPoint p = new DefaultPoint(0, 0, Color.BLUE);
//		p.setY(7);
//		assertEquals(7, p.getY(), 0);
//	}
//
//	@Test
//	public void testSetColor() {
//		DefaultPoint p = new DefaultPoint(0, 0, Color.BLUE);
//		p.setColor(Color.RED);
//		assertEquals(Color.RED, p.getColor());
//		assertEquals(Color.RED, p.getColor());
//	}
//
//	@Test
//	public void testEquals() {
//		DefaultPoint p1 = new DefaultPoint(1, 2, Color.BLUE);
//		DefaultPoint p2 = new DefaultPoint(1, 2, Color.RED);
//		DefaultPoint p3 = new DefaultPoint(0, 1, Color.BLUE);
//		p1.setId(77);
//		p2.setId(77);
//		p3.setId(88);
//		assertTrue(p1.equals(p1));
//		assertTrue(p1.equals(p2));
//		assertFalse(p1.equals(p3));
//		assertFalse(p1.equals(null));
//	}
//
//	@Test
//	public void testHashCode() {
//		DefaultPoint p1 = new DefaultPoint(0, 0, Color.BLUE);
//		DefaultPoint p2 = new DefaultPoint(0, 0, Color.BLUE);
//		DefaultPoint p3 = new DefaultPoint(0, 0, Color.BLUE);
//		p1.setId(77);
//		p2.setId(77);
//		p3.setId(88);
//		assertTrue(p1.hashCode() == p2.hashCode());
//		assertTrue(p1.hashCode() != p3.hashCode());
//	}
//
//	@Test
//	public void testCompareTo() {
//		DefaultPoint p1 = new DefaultPoint(1, 2, Color.BLUE);
//		DefaultPoint p2 = new DefaultPoint(1, 2, Color.BLUE);
//		DefaultPoint p3 = new DefaultPoint(1, 2, Color.BLUE);
//		DefaultPoint p4 = new DefaultPoint(1, 2, Color.RED);
//		DefaultPoint p5 = new DefaultPoint(1, 3, Color.RED);
//		DefaultPoint p6 = new DefaultPoint(3, 4, Color.BLUE);
//		p3.setId(77);
//		assertTrue(p1.compareTo(p1) == 0);
//		assertTrue(p1.compareTo(p2) == 0);
//		assertTrue(p1.compareTo(p3) < 0);
//		assertTrue(p3.compareTo(p1) > 0);
//		assertTrue(p1.compareTo(p4) < 0);
//		assertTrue(p4.compareTo(p1) > 0);
//		assertTrue(p4.compareTo(p5) < 0);
//		assertTrue(p5.compareTo(p4) > 0);
//		assertTrue(p4.compareTo(p6) < 0);
//		assertTrue(p6.compareTo(p4) > 0);
//	}
//}
