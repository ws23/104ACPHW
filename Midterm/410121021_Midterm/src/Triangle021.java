class Triangle021 {
	private int arrX[] = new int[3];
	private int arrY[] = new int[3];

	public Triangle021(int x1, int y1, int x2, int y2, int x3, int y3) {
		setTriangle(x1, y1, x2, y2, x3, y3);
	}

	public Triangle021(Triangle021 t) {
		setTriangle(t.getX()[0], t.getY()[0], t.getX()[1], t.getY()[1], t.getX()[2], t.getY()[2]);
	}

	public Triangle021(int[] x, int[] y) {
		setTriangle(x[0], y[0], x[1], y[1], x[2], y[2]);
	}

	public void setTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		arrX[0] = x1;
		arrX[1] = x2;
		arrX[2] = x3;
		arrY[0] = y1;
		arrY[1] = y2;
		arrY[2] = y3;
	}

	public int[] getX() {
		return arrX;
	}

	public int[] getY() {
		return arrY;
	}

}
