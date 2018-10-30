
import java.awt.Color;
    

    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.IOException;
    



public class Image {
  int height=0;
  int width=0;
	


	private static String matrix="";
	
	
	private final static String fileName="Assignment1.ppm";
	
	
	public static void main(String[] args) throws IOException {
		
		Image(200,200);
	    write(fileName);	
	
		
	}
	
	
	public static void Image(int width, int height){
	
		byte [] images=new byte[3];
		matrix +="P3\n" + width + "\n" + height + "\n255\n";
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color p= setPixels(width,height,j,i);
				
				if(p==Color.red) {
					images[0]=(byte)(255*factor(width,height,j,i));
					images[1]=0;
					images[2]=0;		
				}else if (p==Color.green) {
					images[0]=0;
					images[1]=(byte)(255*factor(width,height,j,i));
					images[2]=0;	
				}else if (p==Color.blue) {
					images[0]=0;
					images[1]=0;
					images[2]=(byte)(255*factor(width,height,j,i));
					
				}
				matrix += ""+ images[0] + " " + images[1] + " " + images[2] + "  " ;
				
				
			}
			matrix += "\n";
		}
		
		
		
	}
	
	public static Color setPixels(int width,int height, int a,int b ) {
			
		double d1 = ((double) width / height) * a;
        double d2 = (((double) -width / height) * a + height);
        if(d1 > b && d2 > b) return Color.green;
        if(d1 > b && d2 < b) return Color.blue;
       
        return Color.red;

	}
	
	
	public static double  factor(int width, int height, int a, int b){
        double factorX = (double) Math.min(a, width - a) / width * 2;
        double factorY = (double) Math.min(b, height - b) / height * 2;

       
        return Math.min(factorX, factorY);
    }
	
	public static void write( String fn) throws FileNotFoundException, IOException{
		FileOutputStream fos = new FileOutputStream(fn);
        fos.write(new String(matrix).getBytes());
        
        fos.close();
	}
	


	
	

}
