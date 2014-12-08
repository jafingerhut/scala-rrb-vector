package scala.collection.immutable.vectorbenchmarks.mbrrbvector.xunbalanced

import scala.collection.immutable.vectorbenchmarks.genericbenchmarks.ApplyBenchmarks
import scala.collection.immutable.vectorutils.VectorGeneratorType


abstract class MbRRBVectorAbstractApplyBenchmark[@miniboxed A] extends ApplyBenchmarks[A] with MbRRBVectorAbstractBenchmark[A]

class MbRRBVectorApplyIntBenchmark extends MbRRBVectorAbstractApplyBenchmark[Int] with VectorGeneratorType.IntGenerator

class MbRRBVectorApplyStringBenchmark extends MbRRBVectorAbstractApplyBenchmark[String] with VectorGeneratorType.StringGenerator