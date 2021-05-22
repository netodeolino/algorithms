public class TorresDeHanoi {

	private static void mover(int discs, char A, char C) {
		System.out.println("-----------------------------------------");
        System.out.println("----- Moving from " + A + " to " + C + " | Discs: " + discs + " -----");
        System.out.println("-----------------------------------------\n");
	}

	static void hanoi(int discs, char A, char B, char C) {
		if (discs > 0) {
			hanoi(discs-1, A, C, B);
			mover(discs, A, C);
			hanoi(discs-1, B, A, C);
		}
	}

	public static void main(String[] args) {
		int discs = 3;
		TorresDeHanoi.hanoi(discs, 'A', 'B', 'C');
	}
}