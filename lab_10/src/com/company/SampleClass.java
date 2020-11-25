package com.company;

@haveArea(name = "haveAreaName")
public class SampleClass {

	double width = 5;
	double length = 6;

	@returnArea
	public void figureArea(){
		System.out.println(width*length);
	}
}
