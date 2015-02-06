package scala.collection.immutable.vectorbenchmarks.redblack

import scala.collection.immutable.vectorbenchmarks.genericbenchmarks.ConcatenationBenchmarks
import scala.collection.immutable.vectorutils.VectorGeneratorType

abstract class RedBlackSeqAbstractConcatenationBenchmark[A] extends ConcatenationBenchmarks[A] with RedBlackSeqBenchmark[A] {
    override def points = super.points / 2
}

class RedBlackSeqConcatenationIntBenchmark extends RedBlackSeqAbstractConcatenationBenchmark[Int] with VectorGeneratorType.IntGenerator

class RedBlackSeqConcatenationStringBenchmark extends RedBlackSeqAbstractConcatenationBenchmark[String] with VectorGeneratorType.StringGenerator