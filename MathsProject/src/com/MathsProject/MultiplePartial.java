package com.MathsProject;

import java.io.*;
import java.math.*;

public class MultiplePartial  
{
	
	double r123,r132,r231,R123,R213,R312;// r123 means r12.3 and so no
	double mulall;
	void partialmultiple(double r12,double r23,double r31)
	{
		//partial correlation coefficients
		System.out.println("\n"+"Partial correlation coefficients"+"\n");
		r123=(r12-r31*r23)/Math.sqrt((1-r31*r31)*(1-r23*r23));
		System.out.println("\n"+"var.1 and var.2 are dependent variables and var.3 is independent.Coefficient r12.3= "+r123+"\n");
		r132=(r31-r12*r23)/Math.sqrt((1-r12*r12)*(1-r23*r23));
		System.out.println("\n"+"var.1 and var.3 are dependent variables and var.2 is independent.Coefficient r13.2= "+r132+"\n");
		r231=(r23-r12*r31)/Math.sqrt((1-r12*r12)*(1-r31*r31));
		System.out.println("\n"+"var.2 and var.3 are dependent variables and var.1 is independent.Coefficient r23.1= "+r231+"\n");
		
		//multiple correlation coefficients
		mulall=2*r12*r23*r31;
		System.out.println("\n"+"multiple correlation coefficients"+"\n");
		R123=Math.sqrt((r12*r12+r31*r31-mulall)/(1-r23*r23));
		System.out.println("\n"+"var.1 is dependent variable and var.2, var.3 are independent variables.Coefficient R123= "+R123+"\n");
		R213=Math.sqrt((r12*r12+r23*r23-mulall)/(1-r31*r31));
		System.out.println("\n"+"var.2 is dependent variable and var.1, var.3 are independent variables.Coefficient R213= "+R213+"\n");
		R312=Math.sqrt((r31*r31+r23*r23-mulall)/(1-r12*r12));
		System.out.println("\n"+"var.3 is dependent variable and var.1, var.2 are independent variables.Coefficient R312= "+R312+"\n");	
		
	}
	
		
		
	}
