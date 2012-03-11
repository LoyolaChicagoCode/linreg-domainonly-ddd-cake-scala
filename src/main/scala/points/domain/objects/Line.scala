package points.domain
package objects

trait Line {

  def slope: Double

  def yIntercept: Double

  def y(x: Double): Double = yIntercept + slope * x
}