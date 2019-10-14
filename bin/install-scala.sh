#! /bin/bash

# Author: Andy Fingerhut
# andy_fingerhut@alum.wustl.edu

# Script to install a version of Scala dev tools on a freshly Ubuntu
# 18.04 Linux system, such that one can compile the scala-rrb-vector
# code in this repository:

# https://github.com/nicolasstucki/scala-rrb-vector

# scala-rrb-vector code was actively developed around 2015 and 2016,
# and seems not to compile with the latest releases of Scala as of
# 2019.

sudo apt-get install curl

# Install SDKMAN first
curl -s "https://get.sdkman.io" | bash
source ~/.sdkman/bin/sdkman-init.sh

# This command:

#sdk install sbt

# installs the latest version of sbt, which is 1.3.2 as of
# 2019-Oct-11.  That version cannot compile the latest version of the
# scala-rrb-vector code as of that date.

# See below for other experiments I tried, with some success.

######################################################################

# After trying several 0.13.X versions of sbt, this is the latest
# version of sbt that I found that can compile the scala-rrb-vector
# code without errors:

sdk install sbt 0.13.18

git clone https://github.com/nicolasstucki/scala-rrb-vector

# See script build.sh for commands that can be run to clean, then
# recompile the scala-rrb-vector code.
