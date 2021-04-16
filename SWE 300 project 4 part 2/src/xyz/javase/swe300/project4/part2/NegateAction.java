package xyz.javase.swe300.project4.part2;
public class NegateAction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
		// TODO Auto-generated method stub
		x.setS(-1);
		return x;
	}

}
