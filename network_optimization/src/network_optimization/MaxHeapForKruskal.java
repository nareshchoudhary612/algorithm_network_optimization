package network_optimization;

public class MaxHeapForKruskal {

	int lastIndex = 0;
	Edge[] EdgeArray;

	public MaxHeapForKruskal(int numberOfEdge) {
		EdgeArray = new Edge[numberOfEdge];
	}

	public void add(Edge e) {
		EdgeArray[lastIndex] = e;
		heapifyUp(lastIndex);
		lastIndex++;
	}

	public Edge pollMax() {
		
		lastIndex--;
		if (lastIndex < 0)
			System.out.println("gone wrong");
		Edge maxValue = EdgeArray[0];
		//System.out.println(maxValue);
		EdgeArray[0] = EdgeArray[lastIndex];
		heapifyDown();
		return maxValue;
	}
	
	
	/*
	 * public void delete(int v) { lastIndex--; int j;
	 * 
	 * //find index of vertex v in H[i] for(j=0; j<lastIndex; j++) { if(H[j] == v)
	 * break; }
	 * 
	 * 
	 * H[j] = H[lastIndex]; heapifyDown(); }
	 */
	 

	public void heapifyDown() {
		int i = 0;
		int largeChildIndex = 0;
		while (hasLeftChild(i)) {
			largeChildIndex = getLeftChildIndex(i);
			if (hasRightChild(i) && rightChildBandwidth(i) > leftChildBandwidth(i))
				largeChildIndex = getRightChildIndex(i);

			if( EdgeArray[i].getW() > EdgeArray[largeChildIndex].getW())
				break;
			else
				swap(i, largeChildIndex);

			i = largeChildIndex;
		}
	}

	public void heapifyUp(int index) {
		/* while (hasParent(index) && parentBandwidth(index) < D[H[index]]) { */
		while (hasParent(index) && parentBandwidth(index) < EdgeArray[index].getW()) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	public void swap(int pos1, int pos2) {
		Edge tempVertices = EdgeArray[pos1];
		EdgeArray[pos1] = EdgeArray[pos2];
		EdgeArray[pos2] = tempVertices;

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
		return getLeftChildIndex(index) < lastIndex - 1;
	}

	public boolean hasRightChild(int index) {
		return getRightChildIndex(index) < lastIndex - 1;
	}

	public boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int leftChildBandwidth(int index) {
		return EdgeArray[getLeftChildIndex(index)].getW();
	}

	private int rightChildBandwidth(int index) {
		return EdgeArray[getRightChildIndex(index)].getW();
	}

	private int parentBandwidth(int index) {
		return EdgeArray[getParentIndex(index)].getW();
	}
	
	/*
	 * @Override public String toString() { String result = null; for(int i=0;
	 * i<EdgeArray.length; i++) result = result + EdgeArray[i]; return result; }
	 */

}