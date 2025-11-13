// This work is licensed under the Creative Commons Attribution-ShareAlike 3.0 Unported License.
// To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send a
// letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.

// woodbox.pov
// POV-Ray scene file by Dan Farmer
// Copyright POV-Team, 1995
// Demonstrates some of the woods.inc textures.
// Several wooden spheres (and one glass one), in and around
// a wooden box.
//
// -w320 -h240
// -w800 -h600 +a0.3       

#version 3.7;
global_settings { assumed_gamma 1.2 } 

#include "colors.inc"
#include "textures.inc"
#include "shapes.inc"
#include "metals.inc"
#include "glass.inc"
#include "woods.inc"       
#include "librerias2.inc"  

camera {
   location <-7, 5, -15>
   angle 45 // direction <0, 0,  1.7>
   right x*image_width/image_height
   look_at <0,0,0>    
   rotate y*360*clock
}   

//ejes3Dc(Red,0.1)

// Uncomment the area lights only if you've got lots of time.
#declare Dist=80.0;
light_source {< -50, 25, -50> color White
     fade_distance Dist fade_power 2
//   area_light <-40, 0, -40>, <40, 0, 40>, 3, 3
//   adaptive 1
//   jitter    
rotate y*360*clock
}      

    

///sor Surface of Revolution 
sor{
  7,
  <0.306,-0.140>,
  <0.605,-0.030>,
  <0.688, 0.341>,
  <0.313, 0.547>,
  <0.165, 0.894>,
  <0.265, 1.000>,
  <0.748, 1.215>

  //  sturm  // optional!
     texture { White_Marble 
               // normal { bumps 0.75 scale 0.010}
               finish { phong 1}
             } // end of texture 
     scale <1,2,1>  rotate<0,0,0> translate<-2.5,0.15,-2>
   } // end of sor ---------------------------------- 


      
object {      
  tetera         
  texture { T_Silver_3B} 
  rotate y*60
  scale 2.5
  translate <5,1,-1.5>
}  

plane { y 0 texture { T_Wood10 scale 6 rotate y*90}}   

box {
  <6,0,3>,<-6,0.1,-3>
  texture { Red_Marble scale 3}
}                      



    // Inside of box
    sphere { <1.5, 1.5, -0.75>, 1.25
        texture {
            T_Wood14
            finish { specular 0.35 roughness 0.05 ambient 0.3 }
            translate x*1
            rotate <15, 10, 0>
            translate y*2
        }
    }
    // Inside of box
    sphere { <-1.5, 1.25,  0.5>, 1
        texture { T_Wood18
            finish { specular 0.25 roughness 0.025 ambient 0.35 }
            scale 0.33
            translate x*1
            rotate <10, 20, 30>
            translate y*10
        }
    }
    // Inside of box
    sphere { <-0.75, 1.0, -1.5>, 0.75
        texture { T_Wood10
            finish { specular 0.5 roughness 0.005 ambient 0.35 }
            translate x*1
            rotate <30, 10, 20>
        }
    }

    // Outside of box
    sphere { <-0.75, 0.75, -4.25>, 0.75
        texture { T_Wood4
            finish { specular 0.25 roughness 0.015 ambient 0.2 }
        }
    }
    // Outside of box
    sphere { <-2.25, 0.45, -4.5>, 0.45
        texture { T_Wood20
            finish { specular 0.15 roughness 0.15 ambient 0.3 }
            rotate <45, 10, 45>
            translate x*10
        }
    }

    // Outside of box
    sphere { <-5.5, 0.95, 0.8>, 0.95
      // texture { T_Glass4 } interior {I_Glass caustics 1}
      // converted to material 26Sep2008 (jh)
      material {
        texture {
          pigment { color rgbf <0.98, 1.0, 0.99, 0.75> }
          finish { F_Glass4 }
          }
        interior {I_Glass caustics 1}
        }
      }
    // Outside of box
    sphere { <-5.00, 0.75, -2.0>, 0.75 texture { T_Copper_2B} }
    // Outside of box
    sphere { <-1.75, 0.4, -5.4>, 0.40 texture { T_Brass_3B} }

