package scala.collection.immutable.vectorbenchmarks.mbrrbvector.unbalanced1

import scala.collection.immutable.vectorbenchmarks._
import scala.collection.immutable.vectorbenchmarks.genericbenchmarks.IterationBenchmarks
import scala.collection.immutable.vectorutils.VectorGeneratorType

abstract class MbRRBVectorAbstractIterationBenchmark[A] extends IterationBenchmarks[A] with MbRRBVectorAbstractBenchmark[A]

class MbRRBVectorIterationIntBenchmark extends MbRRBVectorAbstractIterationBenchmark[Int] with VectorGeneratorType.IntGenerator

class MbRRBVectorIterationStringBenchmark extends MbRRBVectorAbstractIterationBenchmark[String] with VectorGeneratorType.StringGenerator