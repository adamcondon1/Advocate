package com.x18392911.final.recommendations.tests;

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    DirectorsFragmentTest::class,
    StarActorsFragmentTest::class,
    MovieDetailFragmentTest::class,
    MovieListFragmentTest::class
)
class MovieFragmentTestSuite