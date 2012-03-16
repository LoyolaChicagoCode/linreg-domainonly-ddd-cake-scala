package points.domain
package objects

import java.awt.Color

/**
 * Interface-like trait for a simple color point.
 */
trait Point {

  def x: Double

  def y: Double

  def color: Color

  def +(that: Point)(implicit createPoint: (Double, Double, Color) => Point) =
    createPoint(x + that.x, y + that.y, color)

  def *(scale: Double)(implicit createPoint: (Double, Double, Color) => Point) =
    createPoint(x * scale, y * scale, color)
}