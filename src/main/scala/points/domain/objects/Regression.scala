package points.domain
package objects

/**
 * Interface-like trait for a simple regression line based on a collection of points.
 */
trait Regression {

  def line: Line

  def points: Iterable[Point]
}