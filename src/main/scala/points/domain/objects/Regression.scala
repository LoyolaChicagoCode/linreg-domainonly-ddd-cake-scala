package points.domain
package objects

trait Regression {

  def line: Line

  def points: Iterable[Point]
}