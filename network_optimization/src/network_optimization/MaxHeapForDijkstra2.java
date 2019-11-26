package network_optimization;

public class MaxHeapForDijkstra2 {

	int lastIndex, x, previousW, tempVertices, i, largeChildIndex, maxValue = 0;
	int indexOfVetexInHeap = -1;
	int[] H;
	int[] D;
	int[] vertexLocator;

	// constructor
	public MaxHeapForDijkstra2(int numberOfVertex) {
		H = new int[numberOfVertex];
		D = new int[numberOfVertex];
		vertexLocator = new int[numberOfVertex];
	}

	public void add(int vertex, int bandwidth) {
		H[lastIndex] = vertex;
		D[vertex] = bandwidth;
		heapifyUp(lastIndex);
		lastIndex++;
	}

	public int pollMax() {
		lastIndex--;
		if (lastIndex < 0)
			return -1;
		maxValue = H[0];
		H[0] = H[lastIndex];
		heapifyDown();
		return maxValue;
	}

	public void update(int v, int w) {
		previousW = D[v];
		D[v] = w;
		x = vertexLocator[v];

		
		  if (w > previousW) heapifyUp(x);
		 
		/*
		 * else heapifyDown();
		 */
		
	//	  int j; for(j=0; j<lastIndex; j++) { if(H[j] == v) break; } heapifyUp(j);
		 
	}

	public void heapifyDown() {
		i = 0;
		largeChildIndex = 0;
		while (hasLeftChild(i)) {
			largeChildIndex = getLeftChildIndex(i);
			if (hasRightChild(i) && rightChildBandwidth(i) > leftChildBandwidth(i))
				largeChildIndex = getRightChildIndex(i);

			if (D[H[i]] > D[H[largeChildIndex]])
				break;
			else
				swap(i, largeChildIndex);

			i = largeChildIndex;
		}

	}

	public void heapifyUp(int index) {

		
		  if (!(hasParent(index) && parentBandwidth(index) < D[H[index]]))
		  vertexLocator[H[index]] = index;
		 

		while (hasParent(index) && parentBandwidth(index) < D[H[index]]) {

			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	public void swap(int pos1, int pos2) {

		vertexLocator[H[pos1]] = pos2;
		vertexLocator[H[pos2]] = pos1;
		tempVertices = H[pos1];
		H[pos1] = H[pos2];
		H[pos2] = tempVertices;

	}

	public boolean isNull() {
		return (lastIndex <= 0 ? true : false);
	}

	public int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	public int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	public int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	public boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < lastIndex;
	}

	public boolean hasRightChild(int index) {
		return getRightChildIndex(index) < lastIndex;
	}

	public boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int leftChildBandwidth(int index) {
		return D[H[getLeftChildIndex(index)]];
	}

	private int rightChildBandwidth(int index) {
		return D[H[getRightChildIndex(index)]];
	}

	private int parentBandwidth(int index) {
		return D[H[getParentIndex(index)]];
	}

	/*
	 * public void printH() {
	 * 
	 * for (int i = 0; i < this.lastIndex; i++) { System.out.print(this.H[i] + " ");
	 * } System.out.println(); }
	 * 
	 * public void printD() { System.out.println(); for (int i = 0; i <
	 * this.lastIndex; i++) { System.out.print(this.D[i] + " "); }
	 * System.out.println(); }
	 * 
	 * public void printVertexLocator() { System.out.println(); for (int i = 0; i <
	 * this.vertexLocator.length; i++) { System.out.print(this.vertexLocator[i] +
	 * " "); } System.out.println(); }
	 */

	/*
	 * public void delete(int v) { if(v ==0) {
	 * System.out.println("last index: "+lastIndex); } lastIndex--; int j;
	 * 
	 * //find index of vertex v in H[i] for(j=0; j<lastIndex; j++) { if(H[j] == v)
	 * break; } System.out.println("j = "+j);
	 * 
	 * 
	 * H[j] = H[lastIndex];
	 * 
	 * if(j==0) heapifyDown(); else heapifyUp(j);
	 * 
	 * // heapifyDown(); }
	 */

}