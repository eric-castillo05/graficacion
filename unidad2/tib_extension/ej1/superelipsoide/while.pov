    #include "colors.inc"
  camera {
    location <20, 20, -20>
    look_at 0
    angle 15
  }
  background { color rgb <.5, .5, .5> }
  light_source { <10, 50, -100> White }

  #declare algo=object{
  superellipsoid { <0.25, 0.25>
    pigment { Magenta }
  }}

  #declare px=-4.5;
  #while (px<=4.5)
    #declare py=-4.5;
    #while (py<=4.5)
       object{
         algo
         scale <0.5,0.5,0.3>
         translate<px,py,0>
       }
       #declare py=py+1.5;
    #end
    #declare px=px+1.5;
  #end
