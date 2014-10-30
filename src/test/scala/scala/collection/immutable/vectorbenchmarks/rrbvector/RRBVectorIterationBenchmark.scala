package scala.collection.immutable.vectorbenchmarks.rrbvector

import scala.collection.immutable.vectorbenchmarks._
import scala.collection.immutable.vectorbenchmarks.genericbenchmarks.IterationBenchmarks
import scala.collection.immutable.vectorutils.VectorGeneratorType

abstract class RRBVectorAbstractIterationBenchmark[A] extends IterationBenchmarks[A] with RRBVectorBenchmark[A]

class RRBVectorIterationIntBenchmark extends RRBVectorAbstractIterationBenchmark[Int] with VectorGeneratorType.IntGenerator

class RRBVectorIterationStringBenchmark extends RRBVectorAbstractIterationBenchmark[String] with VectorGeneratorType.StringGenerator