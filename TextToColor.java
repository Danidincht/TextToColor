import java.io.*;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class TextToColor
{
	public static void main(String[] args) 
	{
		System.out.println("TextToColor");
		int max = Integer.MAX_VALUE;
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyzñÑ ";
		String texto = "";
		String nombre="texto";
		int indice=0,x=0,y=0,mitad=0;

		BufferedImage foto = new BufferedImage(1,1,1);
		Color color;

		String str="";
		String linea;

		try
		{
			BufferedReader archivo = new BufferedReader(new FileReader(nombre + ".txt"));
			while((linea = archivo.readLine()) != null)
			{
				str = str + linea;
			}
			mitad = (int)Math.ceil(Math.sqrt((double)str.length()));
			foto = new BufferedImage(mitad,(int)(Math.ceil((float)str.length()/mitad)),1);

			for(int i=0;i<str.length();i++)
			{
				String letra = str.substring(i,i+1);

				if(chars.contains(letra))
				{
					indice = chars.indexOf(letra);
					color = new Color(max/indice);
					System.out.println(letra + " " + x + " " + y + " " + color);
					foto.setRGB(x++,y,color.getRGB());
					if(x==mitad)
					{
						x=0;
						y++;
					}
				}
			}
			ImageIO.write(foto,"png",new File(nombre + ".png"));
		}
		catch(ArithmeticException e){System.out.println("Empty file or file type not allowed."); return;}
		catch(Exception ex){System.out.print("Imagen no creada");}
	}
}