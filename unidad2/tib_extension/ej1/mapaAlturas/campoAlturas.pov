  #include "colors.inc"

  camera{
    location <0, 2, -10>
    look_at 0
    angle 30
  }

light_source{ <1000,1000,-1000> White }

  height_field {
    png "mapa.png"
    smooth
    pigment { White }
    translate <-.5, -.5, -.5>
    scale <17, 0.75, 17>
  }
