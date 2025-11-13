#declare ejes3D = union {
  cylinder {
    <0,0,0>,<100,0,0>,0.025
    pigment {color Yellow}
  }
  cylinder { 
    <0,0,0>,<0,100,0>,0.025
    pigment {color Yellow}
  }
  cylinder { 
    <0,0,0>,<0,0,-100>,0.025
    pigment {color Yellow}
  }
}

#declare ejes2D = union {
  cylinder {
    <-100,0,0>,<100,0,0>,0.025
    pigment {color Red}
  }
  cylinder {
    <0,-100,0>,<0,100,0>,0.025
    pigment {color Red}
  }
}

#macro Cubillo (COLOR) 
union {
box {
  <-1,-1,-1>,<1,1,1>
  pigment { color COLOR }
}

sphere {
  <1,1,-0.5>,0.55
  pigment { color White }
}

sphere {
  <1,1,0.5>,0.55
  pigment { color White }
}

sphere {
  <0,0,0>,0.3
  pigment { color Black }
  scale <0.4,1.1,1>
  translate <1.46,1,0.5>
}

sphere {
  <0,0,0>,0.3
  pigment { color Black }
  scale <0.4,1.1,1>
  translate <1.46,1,-0.5>
}
//scale 0.5
//translate <0.5,0.5,0.5>
} // cubillo
#end


#declare flecha=union{
  cylinder {
              <-1,-1,0>,<0,0,0>,0.02 
              pigment {color Orange}
           }
 cylinder {
              <1,-1,0>,<0,0,0>,0.02 
              pigment {color Orange}
           }
  cylinder {
              <1,-1,0>,<0,1,0>,0.02 
              pigment {color Orange}
           }
  cylinder {
              <0,1,0>,<-1,-1,0>,0.02 
              pigment {color Orange}
           } 
}


#declare trapecio=union{
  cylinder {
              <0,0,0>,<4,0,0>,0.02
              pigment {color Orange}
           }
  cylinder {
              <4,0,0>,<2,2,0>,0.02
              pigment {color Orange}
           }
  cylinder {
              <2,2,0>,<0,2,0>,0.02
              pigment {color Orange}
           }
  cylinder {
              <0,2,0>,<0,0,0>,0.02
              pigment {color Orange}
           }
}

#declare estaca=union{
  cylinder {
              <0,0,0>,<2,0,0>,0.02
              pigment {color Orange}
           }
  cylinder {
              <2,0,0>,<2,5,0>,0.02
              pigment {color Orange}
           }
  cylinder {
              <2,5,0>,<1,7,0>,0.02
              pigment {color Orange}
           }

  cylinder {
              <1,7,0>,<0,5,0>,0.02
              pigment {color Orange}
  }
  cylinder {
              <0,5,0>,<0,0,0>,0.02
              pigment {color Orange}
  }
}

#declare estaca2=union{
  cylinder {
              <3,2,0>,<7,2,0>,0.02
              pigment {color Orange}
           }
  cylinder {
              <7,2,0>,<7,6,0>,0.02
              pigment {color Orange}
           }
  cylinder {
              <7,6,0>,<5,7,0>,0.02
              pigment {color Orange}
           }

  cylinder {
              <5,7,0>,<3,6,0>,0.02
              pigment {color Orange}
  }
  cylinder {
              <3,6,0>,<3,2,0>,0.02
              pigment {color Orange}
  }
}
