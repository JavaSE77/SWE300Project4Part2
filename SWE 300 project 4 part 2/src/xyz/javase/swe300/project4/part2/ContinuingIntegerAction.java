package xyz.javase.swe300.project4.part2;
public class ContinuingIntegerAction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {

		double v = x.getV() * 10;
		
		int current = c - '0';
		
		x.setV(v + current);
		
		return x;
	}

}
