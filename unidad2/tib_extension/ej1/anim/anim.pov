//Ejemplo de prueba para una escena vista 3D
//Por: Mario H Tiburcio Z

#include "colors.inc"
#include "librerias.inc"

camera {
  location <6,6,-6>
  look_at <0,0,0>
}

light_source {<4,5,-6> color White}
box{
  <0,0,0>,<1,1,1>
  pigment {color Blue}
  #if (clock<=1)
     translate <clock*3,0,0>
  #end

  #if (clock>1 & clock<=2)
     #declare clock2=clock-1;
     translate <3,0,-clock2*3>
  #end
  
  #if (clock>2 & clock<=3)
     #declare clock3=clock-2;
     translate <3-clock3*3,0,-3>
  #end

  #if (clock>3 & clock<=4)
     #declare clock4=clock-3;
     translate <0,0,-3+clock4*3>
  #end

}

plane  { y,0 pigment {checker Black White }}
ejes3D
