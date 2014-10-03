package scala.collection.immutable
package vectorbenchmarks

import org.scalameter.{Gen, Key, PerformanceTest}

import scala.collection.immutable.rbvector._
import scala.collection.immutable.rrbvector._
import scala.collection.immutable.vectorutils.RRBVectorGenerator

trait BaseVectorBenchmark extends PerformanceTest {


    /* config */

    val minHeight = 1
    val maxHeight = 4
    val points = 32
    val benchRuns = 64
    val independentSamples = 2

    /* data */

    def sizes(from: Int, to: Int, by: Int) = Gen.range("size")(from, to, by)

    def sized[T, Repr](g: Gen[Repr])(implicit ev: Repr <:< Traversable[T]): Gen[(Int, Repr)] = for (xs <- g) yield (xs.size, xs)

    /* sequences */


    def vectors(from: Int, to: Int, by: Int) = for {
        size <- sizes(from, to, by)
    } yield Vector.range(0, size)

    def rbVectors(from: Int, to: Int, by: Int) = for {
        size <- sizes(from, to, by)
    } yield RBVector.range(0, size)

    def rrbVectors(from: Int, to: Int, by: Int) = for {
        size <- sizes(from, to, by)
    } yield RRBVector.range(0, size)

    def extremelyUnbalancedRrbVectors(from: Int, to: Int, by: Int)(implicit config: RRBVectorGenerator.Config[Int]) = for {
        size <- sizes(from, to, by)
    } yield RRBVectorGenerator.vectorOfSize(size)

    def fromToBy(height: Int) = (
      math.pow(32, height - 1).toInt + 1,
      math.pow(32, height).toInt,
      math.max(math.pow(32, height).toInt / points, 1)
      )

    def performanceOfVectors(benchmarks: Int => Unit): Unit = {
        performance of "vector benchmarks" config(
          Key.exec.benchRuns -> benchRuns,
          Key.exec.independentSamples -> independentSamples,
          Key.exec.jvmflags -> "-XX:+PrintCompilation"
          ) in {
            for (height <- minHeight to maxHeight) {
                benchmarks(height)
            }
        }
    }
}
