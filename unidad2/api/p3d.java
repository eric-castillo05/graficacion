import java.io.*;
import java.awt.*;
import tiburcio.lib3D.*;
class p3d extends s3D
{
   p3d()
   {
 	DEF_SISTEMA("GRAFICAS EN 3D",500,500,Color.black,30,30,1,250,250);
   }

   public static void  main (String args[])
   {
     p3d P=new p3d ();
   }
	public void paint(Graphics g)
	{
		ejes3D(Color.white,g);
                obj3D A=new obj3D("avion.3d");
                g.setColor(Color.GREEN);
                dibObj3D(A,g);
                m3D mr=new m3D();
                mr.rotacionY(90);
                g.setColor(Color.RED);
                dibObj3D(A.transforma(mr),g);
	}
}

