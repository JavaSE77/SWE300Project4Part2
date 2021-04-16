package xyz.javase.swe300.project4.part2;

public class MinusInputVerifier implements InputVerifier {

	@Override
	public boolean meetsCriteria(char c) {
		// TODO Auto-generated method stub
		
		if(c == '-' ) {
			return true;
		}
		
		return false;
	}

}
