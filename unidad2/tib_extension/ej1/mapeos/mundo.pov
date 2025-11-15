//Ejemplo de prueba para una escena vista 3D
//Por: Mario H Tiburcio Z

#include "colors.inc"


camera {
  location <0,0,-1.5>
  look_at <0,0,0>
}

background {color rgb<0.8,0.8,1>}

light_source {<4,0,-4> color White}
light_source {<-4,0,-4> color White}

sphere{
  <0,0,0>,0.5
   pigment{ 
     image_map {
       png "mapamundi3.png"
       map_type 1
       interpolate 2
     }
   }
   rotate y*180
}


