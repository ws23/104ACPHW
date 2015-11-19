class Circle021 {

	private int x, y, r;

	public Circle021(int inX, int inY, int inR) {
		setCircle(inX, inY, inR);
	}

	public Circle021(Circle021 c) {
		setCircle(c.getX(), c.getY(), c.getRadius());
	}

	public void setCircle(int inX, int inY, int inR) {
		x = inX;
		y = inY;
		r = inR;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRadius() {
		return r;
	}

}
