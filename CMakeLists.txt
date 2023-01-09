cmake_minimum_required(VERSION 3.0)

project (TLOP Java)

find_package(Java 16 REQUIRED)
include(UseJava)

file(GLOB_RECURSE src
	    ${CMAKE_CURRENT_SOURCE_DIR}/src/*/*.java
)

file(GLOB_RECURSE assets
	    ${CMAKE_CURRENT_SOURCE_DIR}/assets/*
)

add_jar(TLOP
	SOURCES
		${src}
	RESOURCES NAMESPACE "assets/"
		${assets}
	ENTRY_POINT
		main.Main
)
