//Ejemplo de prueba para una escena vista 3D
//Por: Mario H Tiburcio Z

#include "colors.inc"
#include "librerias.inc"

camera {
  location <6,6,-6>
  look_at <0,0,0>
}

light_source {<4,5,-6> color White}

torus {
2,0.6
pigment{
     image_map {
       png "jirafa2.png"
       map_type 5
       interpolate 2
       //once
     }
}
}

plane  { y,0 pigment {checker Black White }}
ejes3D
