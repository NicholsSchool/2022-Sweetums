
import time 
import Rpi.GPIO as GPIO
from networktables import NetworkTables

import logging 
logging.basicConfig( level=logging.DEBUG)

NetworkTables.initialize( server = '10.49.30.2' )

sd = NetworkTables.getTables("RaspberryPI")



Light = TCS34725(0X29, debug=False)
if(Light.TCS34725_init() == 1):
    print("TCS34725 initialization error!!")
else:
    print("TCS34725 initialization success!!")
time.sleep(2)

Light.Get_RGBData()
Light.GetRGB888()
Light.GetRGB565()
sd.putNumber( 'Red', Light.RGB888_R )
sd.putNumber( 'Green', Light.RGB888_G)
sd.putNumber( 'Blue', Light.RGB888_B)

while True:
    print("R: %d "%Light.RGB888_R ),
    print("G: %d "%Light.RGB888_G ), 
    print("B: %d "%Light.RGB888_B ), 
    sd.putNumber( 'Red', Light.RGB888_R )
    sd.putNumber( 'Green', Light.RGB888_G )
    sd.putNumber( 'Blue ', Light.RGB888_B )
