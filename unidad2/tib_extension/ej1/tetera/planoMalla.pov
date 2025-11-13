//Ejemplo de prueba para una escena vista 3D
//Por: Mario H Tiburcio Z

#include "colors.inc"
#include "librerias2.inc"


camera {
  location <6,2,-6>
  look_at <0,0,0>
}

light_source {<4,5,-6> color White}
box{
  <0,0,0>,<1,1,1>
  pigment {color Blue}
  translate -0.5
}

plano(-5,5,-5,5,0.5,Cyan,0.020)
//plane  { y,0 pigment {checker Black White }}
ejes3Dc(White,0.10)
