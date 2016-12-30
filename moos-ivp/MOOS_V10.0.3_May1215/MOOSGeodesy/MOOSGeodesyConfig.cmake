# Configuration file for MOOSGeodesy library.

# Pick up the auto-generated file which knows how to add the library targets
# This will mean that we don't have to supply full paths for the libraries
set(exports_file "/Users/sgerasimou/Documents/MOOS/Exemplar/moos-ivp/MOOS/MOOSGeodesy/UseMOOSGeodesy.cmake")
if (EXISTS ${exports_file})
  message(STATUS "CMake is running ${exports_file}")
  include(${exports_file})
endif ()

# Project specific variables are dynamically inserted here

# Export variables for MOOSGeodesy Library
set(MOOSGeodesy_LIBRARIES "MOOSGeodesy")
set(MOOSGeodesy_INCLUDE_DIRS "/Users/sgerasimou/Documents/MOOS/Exemplar/moos-ivp/MOOS/MOOSGeodesy/libMOOSGeodesy/include")
set(MOOSGeodesy_LIBRARY_PATH "/Users/sgerasimou/Documents/MOOS/Exemplar/moos-ivp/MOOS/MOOSGeodesy/libMOOSGeodesy/include/../../lib")
set(MOOSGeodesy_DEPEND_LIBRARIES "m;proj")
set(MOOSGeodesy_DEPEND_INCLUDE_DIRS "/Users/sgerasimou/Documents/MOOS/Exemplar/moos-ivp/MOOS/MOOSGeodesy/libMOOSGeodesy/include")
