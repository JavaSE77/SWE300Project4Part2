package xyz.javase.swe300.project4.part2;
public class ContinuingFactionAction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
		// TODO Auto-generated method stub
		double v = x.getV();
		double p = x.getP();
	
		int current = c - '0';
		
		v = v + (current * p);
		x.setV(v);
		p = p * .1;
		x.setP(p);
		
		return x;
	}

}
