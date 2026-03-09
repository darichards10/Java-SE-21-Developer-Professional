package se21.oop;

public class EmperorPenguin extends Penguin {
	@Override
	public int getHeight() { // EXAM: overrides Penguin.getHeight(); called whenever 'this' or a Penguin reference holds an EmperorPenguin at runtime
		return 8;
	}

	int getSuperHeight() {
		return super.getHeight(); // EXAM: super bypasses dynamic dispatch; explicitly calls Penguin.getHeight() returning 3, even though this is an EmperorPenguin
	}
}
