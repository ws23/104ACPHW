class Rectangle021 {
	private int x, y, height, width;

	public Rectangle021(int inX, int inY, int w, int h) {
		setRectangle(inX, inY, w, h);
	}

	public Rectangle021(Rectangle021 r) {
		setRectangle(r.getX(), r.getY(), r.getWidth(), r.getHeight()); 
	}

	public void setRectangle(int inX, int inY, int w, int h) {
		x = inX;
		y = inY;
		width = w;
		height = h;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
}
