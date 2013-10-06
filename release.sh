#!/bin/bash

rm -rf target/release
mkdir target/release
cd target/release
git clone git@github.com:ericbuitenhuis/grails-glyph-icons
cd grails-glyph-icons
grails clean
grails compile
grails publish-plugin --stacktrace