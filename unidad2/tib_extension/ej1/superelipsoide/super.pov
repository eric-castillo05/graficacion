#include "colors.inc"
  camera {
    location <10, 5, -20>
    look_at 0
    angle 15
  }
  background { color rgb <.5, .5, .5> }
  light_source { <10, 50, -100> White }
  superellipsoid { <.9, .1>
    pigment { Red }
  }
