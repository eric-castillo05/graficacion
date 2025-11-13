//Ejemplo de prueba para una escena vista 3D
//Por: Mario H Tiburcio Z

#include "colors.inc"
#include "librerias.inc"

camera {
  location <2,4,-4>
  look_at <0,0,0>
}

light_source {<4,5,-6> color White}

union{
  sphere{
    <-0.5,0,0>,1
    pigment {color Yellow}
  }

  sphere{
    <0.5,0,0>,1
    pigment {color Yellow}
  }
}

//plane  { y,0 pigment {checker Black White }}
ejes3D
