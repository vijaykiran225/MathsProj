package com.MathsProject;
import java.sql.*;
import java.io.*;
class Database
{
	
	public double connectDBAndCalculate(int n) throws Exception
	{
		int i=1;
		int tempx,tempy;
		int sumx=0,sumy=0,sumx2=0,sumy2=0,sumxy=0;
		int numberOfRecords=24;
		float Ex=0,Ey=0,Ex2=0,Exy=0,Ey2=0;
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c=DriverManager.getConnection("jdbc:odbc:Maths");
		Statement smt=c.createStatement();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Field no 1 for x (value above 3)");
		int receivedF1=Integer.parseInt(br.readLine());
		System.out.println("Enter Field no 2 for y (value above 3)");
		int receivedF2=Integer.parseInt(br.readLine());
		ResultSet re=smt.executeQuery("select * from Cfb2009stats");
		while(i<=numberOfRecords)
		{re.next();
		//System.out.println("NO :"+i);
		try{
		tempx=(re.getInt(receivedF1));
		//	System.out.println("Score Off: "+tempx);
			sumx+=tempx;
			sumx2+=tempx*tempx;
			tempy=re.getInt(receivedF2);
			//re.getRef(receivedF2);
		//	System.out.println(re.getRef(receivedF2));
			sumy+=tempy;
			sumy2+=tempy*tempy;
			
			sumxy+=tempx*tempy;
			i++;}
		catch(Exception e)
		{
			System.err.println(" error .. pl re-run ..");	
			System.exit(0);
		}
		}
		re.close();
		smt.close();
		c.close();
		
		Ex=sumx/numberOfRecords;
		Ey=sumy/numberOfRecords;
		Exy=sumxy/numberOfRecords;
		Ex2=sumx2/numberOfRecords;
		Ey2=sumy2/numberOfRecords;
		
		float varx=0,vary=0,covarxy=0;
		double Corr;
		varx=Ex2-(Ex*Ex);
		vary=Ey2-(Ey*Ey);
		covarxy=Exy-(Ex*Ey);
		System.out.println("E(X) ="+Ex+"\nE(Y) ="+Ey+"\nE(X^2) ="+Ex2+"\nE(Y^2) ="+Ey2+"\nE(XY) ="+Exy+"\nvar(X) ="+varx+"\nvar(Y) ="+vary+"\nCovar(XY) ="+covarxy);
		
		Corr=((covarxy)/((Math.sqrt(varx))*(Math.sqrt(vary))));
		System.err.println("Mean of X is "+Ex+"\n Mean of Y is "+Ey);
		System.err.println("SD of X is "+Math.sqrt(varx)+"\n SD of y is "+Math.sqrt(vary));
		System.err.println("Correlation value is "+Corr);
		
		if((Corr<-1)||(Corr>1))
		{
		System.err.println("Wrong field / error .. pl retry ..");	
		System.exit(0);
		}
		else{
			if(Corr>0)
			{
				System.err.println("Positive Correlation");
			}
			else if(Corr<0)
			{
				System.err.println("Negative Correlation");
			}
		}
		c.close();
		smt.close();
		return Corr;
	}
}
public class Correlation {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Database d=new Database();
		System.out.println("enter N");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Enter Field no 1 for x");
		int receivedN=Integer.parseInt(br.readLine());
		
		double r12=d.connectDBAndCalculate(receivedN);
		double r23=d.connectDBAndCalculate(receivedN);
		double r31=d.connectDBAndCalculate(receivedN);
		
		MultiplePartial obj=new MultiplePartial();
		obj.partialmultiple(r12,r23,r31);
	}

}
