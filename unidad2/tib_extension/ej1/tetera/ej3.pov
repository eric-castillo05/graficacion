#include "colors.inc"
#include "librerias2.inc"

camera{
  location  <2.5,1,-2.5> 
  look_at  <0,0,0>
}

light_source { <4,4,-4> color White }
//ejes3D
plano (-1.6,1.6,-1.6,1.6,0.2,Blue,0.005)
background {color rgb <0,0.1,0>}

#declare px=-1.2;
#while (px<=1.2)
  #declare pz=-1.2;
  #while (pz<=1.2)
     object{
       teteraConOjos(Cyan)
       scale 0.3
       translate <px,0,pz>
     }
     #declare pz=pz+0.6;
  #end
  #declare px=px+0.6;
#end
