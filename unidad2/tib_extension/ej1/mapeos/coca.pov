//Ejemplo de prueba para una escena vista 3D
//Por: Mario H Tiburcio Z

#include "colors.inc"


camera {
  location <1.5,1.2,-1.5>
  look_at <0,0,0>
}

background {color rgb<0.8,0.8,1>}

light_source {<4,0,-4> color White}
light_source {<-4,0,-4> color White}

cylinder{
   <0,0,0>,<0,3,0>,0.4
   pigment{ 
     image_map {
       png "cocacola.png"
       map_type 2
       interpolate 2
       once
     }
   }
   rotate y*180
}


