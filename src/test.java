import java.util.Date;

import Data.DataSach;

public class test {
	public static void main(String[] args) {
		//DataSach d=new DataSach();
		Date d=new Date();
		//d.findSachData(1235,"ngay mai" ,"o" );
		System.out.println("test");
		int i=d.getMonth()+1;
		int q=d.getYear();
		System.out.println(i+"  "+q);
		int temp[][]=new int[4][3];
		temp[1][1]=2;
		System.out.println(temp[1][2]);
	}
}
