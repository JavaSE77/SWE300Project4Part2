
public class DigitInputVerifier implements InputVerifier {

	@Override
	public boolean meetsCriteria(char c) {
		// TODO Auto-generated method stub
		int s = c -'0';
		if(s >= 0 && s <= 9) {
			return true;
		}
		
		return false;
	}

}
