#include "colors.inc"
#include "librerias2.inc"

camera{
  location  <2,1,-2> 
  look_at  <0,0,0>
}

light_source { <4,4,-4> color White }
ejes3D
plano (-1.4,1.4,-1.4,1.4,0.2,White,0.005)

object {
  teteraConOjos(Blue)     
  
  rotate 360*clock*y
}


     