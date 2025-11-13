//Ejemplo de prueba para una escena vista 3D
//Por: Mario H Tiburcio Z

#include "colors.inc"


camera {
  location <1.5,1.5,-1.5>
  look_at <0,0,0>
}

background {color rgb<0.8,0.8,1>}

light_source {<4,0,-4> color White}
light_source {<-4,0,-4> color White}

box{
   <0,0,0>,<1,1,0.2>
   pigment{ 
     image_map {
       png "bobesponja.png"
       map_type 0
     }
   }
}


