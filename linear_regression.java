import java.io.*;
import java.util.*;

public class LMSMAIN {

	
	
	public static void main(String[] args) throws Exception{
		ArrayList<Double> x=new ArrayList<Double>();
		ArrayList<Double> y=new ArrayList<Double>();
		Scanner scr=new Scanner(System.in);
		Double meanx=0.00,meany=0.00,dx,dy,dx2,dy2,num=0.0,den=0.0,b1=0.0,b0;
		int count=0;
		FileReader fr=new FileReader("/home/user/workspace/LSM/bin/data.txt");
		BufferedReader br = new BufferedReader(fr);
		String reader,tmp[];
		while((reader=br.readLine())!=null){
			tmp=reader.split("\\s+");
			//System.out.println("x:"+tmp[0]+" y:"+tmp[1]);
			dx=Double.parseDouble(tmp[0]);
			dy=Double.parseDouble(tmp[1]);
			meanx+=dx;
			meany+=dy;
			count++;
			x.add(dx);
			y.add(dy);
		}
		meanx/=count;
		meany/=count;
		System.out.println("+----------+----------+----------+----------+----------+----------+");
		System.out.println("|    x     |    y     | xi-(xbar)| yi-(ybar)|   dx2    |   dx*dy  |");
		System.out.println("+----------+----------+----------+----------+----------+----------+");
		for(int i=0;i<count;i++){
			dx=x.get(i)-meanx;
			dy=y.get(i)-meany;
			dx2=dx*dx;
			num=dx*dy;
			den+=dx2;
			b1+=num;
			System.out.println(String.format("|%10.2f|%10.2f|%10.2f|%10.2f|%10.2f|%10.2f|",x.get(i),y.get(i),dx,dy,dx2,num));
		}
		System.out.println("+----------+----------+----------+----------+----------+----------+");
		
		b1/=den;
		b0=meany-b1*meanx;
		
		System.out.println("y = "+b1+"x + ( "+b0+" )");
		System.out.print("Enter x:");
		Double newx=scr.nextDouble();
		System.out.println("The y prediction is:");
		System.out.println(""+(b0+b1*newx));
	}

}

