package network_optimization;

public class Edge implements Comparable<Edge> {
	static int IDGen;
	int ID;
	int u;
	int v; //end point of edge
	int w; // weight of the edge
	
	public int compareTo(Edge e) {
		return e.w-this.w;
	}
	public Edge(int u, int v, int w) {
		super();
		IDGen++;
		this.ID= IDGen;
		this.u = u;
		this.v = v;
		this.w = w;
	}
	
	@Override
	public String toString() {
		return "("+u +","+v+","+w+")";
	}
	
	public int getID() {
		return ID;
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