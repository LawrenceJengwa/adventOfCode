package com.lawrence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import java.util.Arrays;

public class Puzzle {
	static List<String> strings = new ArrayList<>();
	static int[] maarray = new int[] {4, 10, 4, 1, 8, 4, 9, 14,5, 1, 14, 15, 0, 15, 3, 5};
	static private int largest = 0;
	static private int position = 0;
	static private int depth = 0;
	private static String first = "";
	private static String secord = "", outputString = "";
	static int[] outputArray = null;

	public static void main(String[] args) {
		if(depth==0) {
			first = printArrayContents(maarray);
			strings.add(first);
		}
		outputArray = recurseArray(maarray, position, largest);
		
	}
	
	private static int[] recurseArray( int[] input, int positio, int value) {
		int size = value;
		int referencePosition = positio;
		int[] copyInput = input.clone();
		copyInput[position] = 0;
		do {
			referencePosition++;
			if(referencePosition < input.length ) {
				copyInput[referencePosition] = copyInput[referencePosition] + 1;
			}else {
				referencePosition = 0;
				copyInput[referencePosition] = copyInput[referencePosition] + 1;
			}
			
			size--;
		}while(size > 0);
		depth++;
		outputString = printArrayContents(copyInput);
		if(depth == 2)
			System.out.println(secord);
		System.out.println(outputString);
		if(!(strings.contains(outputString) || depth == 5000)) {
			strings.add(outputString);
			recurseArray(copyInput, position, largest);
		}else {
			System.out.println("Number of Iterations: " + depth);
		}
		
		return copyInput;
		
		
	}
	
	private static String printArrayContents(int[] array) {
		largest = 0;
		position = 0;
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i < array.length; i++) {
			if(largest < array[i]) {
				largest = array[i];
				position = i;
			}
			sb.append(array[i]+",");
		}
		return sb.toString();
	}

}
