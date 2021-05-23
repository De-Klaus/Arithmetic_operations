package base;

import java.util.stream.IntStream;

public class Ñalculations {
	
	public int sum(int... i) {
		return IntStream.of(i).sum();
	}
	
	public long mult(int... i) {
		long mult = 1;
		for(int j : i) {
			mult*=j;
		}
		return mult;
	}
	
	public long multsum(int...i) {
		return i[0]*i[1]+i[2];
	}

}
