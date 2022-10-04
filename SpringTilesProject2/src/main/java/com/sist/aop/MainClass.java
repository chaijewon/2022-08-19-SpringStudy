package com.sist.aop;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[98];
		for(int i=2;i<=100;i++)
		{
			arr[i]=i;
		}
		int a=0;
        for(int i=2;i<=100;i++)
        {
        	a=arr[i+2];
        	if(a%i==0)
            {
        	   break;
            }
        }
        
        
	}

}
