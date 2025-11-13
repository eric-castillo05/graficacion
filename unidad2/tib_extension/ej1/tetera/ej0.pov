#include "colors.inc"
#include "librerias2.inc"
camera {
  location <3,1,-3>
  look_at <0,0,0>
}
light_source {<4,5,-6> color White}
//plane  { y,-1 pigment {checker Black White }}
plano(-2,2,-2,2,0.25,Cyan,0.004)
background {color rgb <0,0,0.2>}


teteraConOjos(Red)
object{
  teteraConOjos(Blue)
  scale y*2
  translate <0,0,-1.4>
}
object{
  teteraConOjos(Green)
  scale y*1.5
  translate <0,0,1.4>
}

