cmake_minimum_required(VERSION 3.10)
project(test-example)

set(GTEST_ROOT "C:/trpo/lecture-testing-task/01_tests/googletest")  
set(GTEST_INCLUDE_DIR "${GTEST_ROOT}/googletest/include")
set(GTEST_LIBRARY "${GTEST_ROOT}/build/lib/libgtest.a")
set(GTEST_MAIN_LIBRARY "${GTEST_ROOT}/build/lib/libgtest_main.a")
set(GMOCK_LIBRARY "${GTEST_ROOT}/build/lib/libgmock.a")
set(GMOCK_MAIN_LIBRARY "${GTEST_ROOT}/build/lib/libgmock_main.a")

find_package(GTest REQUIRED)

include_directories(${GTEST_INCLUDE_DIRS})
include_directories(${GTEST_INCLUDE_DIRS}/gmock)
include_directories("../05_hw")

add_executable(08_stack_tests 08_stack_tests.cpp ../05_hw/stack.c)
target_link_libraries(08_stack_tests ${GTEST_LIBRARY} ${GTEST_MAIN_LIBRARY} ${GMOCK_LIBRARY} ${GMOCK_MAIN_LIBRARY})

if(ENABLE_GCOV)
    target_compile_options(08_stack_tests PRIVATE "--coverage")
    target_link_options(08_stack_tests PRIVATE "--coverage")
endif()

# add_executable(00_add 00_add.c)

# add_executable(01_simple_print 01_simple_print.c)

# add_executable(02_simple_marco 02_simple_marco.c)
# if(ENABLE_GCOV)
#     target_compile_options(02_simple_marco PRIVATE "--coverage")
#     target_link_options(02_simple_marco PRIVATE "--coverage")
# endif()

# add_executable(03_gtest_simple 03_gtest_simple.cpp)
# target_link_libraries(03_gtest_simple GTest::GTest)

# add_executable(04_gtest_fixtures 04_gtest_fixtures.cpp)
# target_link_libraries(04_gtest_fixtures GTest::GTest)

# add_executable(05_gmock 05_gmock.cpp)
# target_include_directories(05_gmock PRIVATE C:/trpo/lecture-testing-task/01_tests/googletest/googlemock/include)
# target_link_libraries(05_gmock ${GTEST_LIBRARY} ${GTEST_MAIN_LIBRARY} ${GMOCK_LIBRARY} ${GMOCK_MAIN_LIBRARY})