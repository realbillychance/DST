package com.mygdx.game;

public class Coordinate 
{
	int pivot;
	int time;

	//Fill in pivots
	Pivot [] pivots = new Pivot[52];
	public Coordinate(int p, int t)
	{
		pivots[0]= new Pivot(572,260);
		pivots[1]= new Pivot(827,263);
		pivots[2]= new Pivot(843,280);
		pivots[3]= new Pivot(864,385);   
		pivots[4]= new Pivot(848,403);
		pivots[5]= new Pivot(817,398);
		pivots[6]= new Pivot(753,298);
		pivots[7]= new Pivot(570,195);
		//8 is transfer
		pivots[8]= new Pivot(570,196);
		pivots[9]= new Pivot(570,115);
		pivots[10]= new Pivot(551,119);
		pivots[11]= new Pivot(557,390);
		pivots[12]= new Pivot(444,425);
		pivots[13]= new Pivot(442,438);
		pivots[14]= new Pivot(442,443);
		pivots[15]= new Pivot(378,469);
		pivots[16]= new Pivot(341,476);
		pivots[17]= new Pivot(324,500);
		pivots[18]= new Pivot(277,500);
		pivots[19]= new Pivot(233,481);
		pivots[20]= new Pivot(177,479);
		pivots[21]=new Pivot(165,450);
		pivots[22]=new Pivot(142,447);
		pivots[23]=new Pivot(145,514);
		pivots[24]=new Pivot(181,522);
		pivots[25]=new Pivot(321,519);
		pivots[26]=new Pivot(406,476);
		pivots[27]=new Pivot(574,439);
		pivots[28]=new Pivot(720,702);
		pivots[29]=new Pivot(730, 695);
		pivots[30]= new Pivot(554,192);
		//31 is transfer point
		pivots[31]= new Pivot(554,193);
		pivots[32]= new Pivot(570,115);
		pivots[33]= new Pivot(551,119);
		pivots[34]= new Pivot(687,660);
		pivots[35]= new Pivot(555,193);
		//Pivots for myself
		pivots[36]= new Pivot(551,188);
		pivots[37]= new Pivot(534,217);
		pivots[38]= new Pivot(628,564);
		pivots[39]= new Pivot(627,526);
		pivots[40]= new Pivot(594,444);
		pivots[41]= new Pivot(559,323);
		pivots[42]= new Pivot(547,262);
		pivots[43]= new Pivot(534,217);
		pivots[44]= new Pivot(563,397);
		pivots[45]= new Pivot(577,441);
		pivots[46]= new Pivot(622,548);
		pivots[47]= new Pivot(701,654);
		pivots[48]= new Pivot(627,526);
		pivots[49]= new Pivot(594,444);
		pivots[50]= new Pivot(559,323);
		pivots[51]= new Pivot(547,262);
		pivot=p;
		
		time=t;
		//35 701 654, 627 526, 594 444, 559 323, 547 262
}
	public int getDeltaTime()
	{
		return time;
	}
	
	public int getX()
	{
		return pivots[pivot].getX();
	}
	public int getY()
	{
		return pivots[pivot].getY();
	}
	public int getPivot()
	{
		return pivot;
	}
	

	
}
