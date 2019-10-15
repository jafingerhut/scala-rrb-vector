#! /bin/bash

# Author: Andy Fingerhut
# andy_fingerhut@alum.wustl.edu

# See script install-scala.sh for one-time setup steps to install
# Scala dev environment.  This script is meant to be run repeatedly,
# e.g. whenever you change the scala-rrb-vector Scala code and want to
# recompile.


# Note: sbt seems, at least in some cases, to write to a file named:
# project/build.properties

# It contains an sbt version number.

# If the version number is different than the version of sbt you try
# to run from the command line, it seems that in some cases it can use
# the version of sbt in the file, not the one in your path?  Removing
# the file seems to help in that case.

\rm project/build.properties
sbt clean
sbt compile
sbt publishM2

######################################################################

# Error message I see when trying to use sbt 1.3.2

# $ \rm project/build.properties
# $ sbt clean
# [info] Updated file /home/andy/rrb-trees/scala-rrb-vector/project/build.properties: set sbt.version to 1.3.2
# [info] Loading settings for project scala-rrb-vector-build from plugins.sbt ...
# [info] Loading project definition from /home/andy/rrb-trees/scala-rrb-vector/project
# [error] /home/andy/rrb-trees/scala-rrb-vector/project/Build.scala:4:31: not found: type Build
# [error] object RRBVectorBuild extends Build {
# [error]                               ^
# [error] one error found
# [error] (Compile / compileIncremental) Compilation failed
# Project loading failed: (r)etry, (q)uit, (l)ast, or (i)gnore? q

# Also very similar error message with these versions of sbt:

# 1.2.0
# 1.1.0
# 1.0.0

# Sample sdk commands to install and switch to using a different sbt
# version:

# sdk install sbt 1.2.0
# sdk use sbt 1.2.0

# I got an error when I tried to do 'sbt publishM2' command again,
# after doing it successfully once.  The first successful time wrote a
# JAR file into my $HOME/.m2 directory.

# The second attempt failed with this error message:

######################################################################
# java.io.IOException: destination file exists and overwrite == false
# 
# [ ... many stack trace lines omitted ... ]
# 
# [error] (scala-rrb-vector/*:publishM2) java.io.IOException: destination file exists and overwrite == false
# [error] Total time: 136 s, completed Oct 11, 2019 3:15:43 PM
######################################################################

# Doing a Google search on some key words in the error message, I
# found this page:

# https://stackoverflow.com/questions/26077419/how-to-overwrite-local-stable-version-artifacts-using-publishlocal

# The basic suggestion there appears to be a resonable one: use a
# version number ending in "-SNAPSHOT", and you should be able to
# overwrite existing JAR files in $HOME/.m2 without errors.

# Changing this line in file scala-rrb-vector/build.sbt:

#version := "0.1"

# to this:

#version := "0.1.2-SNAPSHOT"

# (Given that version 0.1.1 is the latest version released on Maven
# Central, it seems best to bump up to a higher version, then append
# the "-SNAPSHOT")

# enabled me to successfully repeat this sequence of commands, with no
# errors, and I verified from the last modified times on the files in
# my $HOME/.m2 directory that they were written by the second 'sbt
# publishM2' command.  I also verified by copying the directory after
# the first write, before the second, that several of the files had
# different contents, e.g. different MD5 hashes, between the first and
# second 'sbt publishM2' commands, which seems expected.

# sbt clean
# sbt compile
# sbt publishM2
