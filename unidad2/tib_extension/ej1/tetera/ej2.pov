#include "colors.inc"
#include "librerias2.inc"

camera{
  location  <2.5,1,-2.5> 
  look_at  <0,0,0>
}

light_source { <4,4,-4> color White }
//ejes3D
plano (-1.6,1.6,-1.6,1.6,0.2,Yellow,0.0025)     



#declare ban=0;
#declare teta=0;
#while (teta<=360)
  object {
    #if (ban=0)
      teteraConOjos(Blue)
      #declare ban=1;
    #else
      #if (ban=1)
        teteraConOjos(Red)
        #declare ban=2;
      #else 
        #if (ban=2)
          teteraConOjos(Green)
          #declare ban=0;
        #end
      #end
    #end
    scale <0.4,0.4,0.4>
    rotate 45*y
    translate <1.4,0,0>
    rotate <0,teta,0>
    #declare teta=teta+20;
  }
#end    


