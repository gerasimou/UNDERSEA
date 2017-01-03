#--------------------------------------------------------
# The CMakeLists.txt for:                       sSensor
# Author(s):                              Simos Gerasimou
#--------------------------------------------------------

# FILE(GLOB SRC *.cpp)

SET(SRC
  Sensor.cpp
  Sensor_Info.cpp
  main.cpp
  Degradation.cpp
)



ADD_EXECUTABLE(sSensor ${SRC})

TARGET_LINK_LIBRARIES(sSensor
   ${MOOS_LIBRARIES}
   mbutil
   m
   pthread)

