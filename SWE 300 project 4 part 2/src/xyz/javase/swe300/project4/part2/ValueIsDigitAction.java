package xyz.javase.swe300.project4.part2;
public class ValueIsDigitAction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
		// TODO Auto-generated method stub	

		double v = x.getV();
		
		int current = c - '0';
		
		x.setV(v + current);
		
		return x;
	}

}
