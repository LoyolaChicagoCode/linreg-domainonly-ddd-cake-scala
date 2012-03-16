package points.domain
package objects

/**
 * Interface-like trait for a simple line.
 */
trait Line {

  def slope: Double

  def yIntercept: Double

  def y(x: Double): Double = yIntercept + slope * x
}