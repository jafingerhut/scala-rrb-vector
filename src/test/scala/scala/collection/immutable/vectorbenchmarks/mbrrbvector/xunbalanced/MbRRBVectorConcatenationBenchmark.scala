package scala.collection.immutable.vectorbenchmarks.mbrrbvector.xunbalanced

import scala.collection.immutable.vectorbenchmarks.genericbenchmarks.ConcatenationBenchmarks
import scala.collection.immutable.vectorutils.VectorGeneratorType

abstract class MbRRBVectorAbstractConcatenationBenchmark[@miniboxed A] extends ConcatenationBenchmarks[A] with MbRRBVectorAbstractBenchmark[A]

class MbRRBVectorConcatenationIntBenchmark extends MbRRBVectorAbstractConcatenationBenchmark[Int] with VectorGeneratorType.IntGenerator

class MbRRBVectorConcatenationStringBenchmark extends MbRRBVectorAbstractConcatenationBenchmark[String] with VectorGeneratorType.StringGenerator