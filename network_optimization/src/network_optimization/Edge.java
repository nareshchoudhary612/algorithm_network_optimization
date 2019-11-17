package network_optimization;

public class Edge {
	int u;
	int v; //end point of edge
	int w; // weight of the edge
	
	public Edge(int u, int v, int w) {
		super();
		this.u = u;
		this.v = v;
		this.w = w;
	}
	
	@Override
	public String toString() {
		return "("+u +","+v+"|"+w+")";
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}
	
	
}