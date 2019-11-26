package network_optimization;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxHeapForKruskal2 {

	int lastIndex = 0;
	int[] H;
	int[] D;

	public MaxHeapForKruskal2(int numberOfVertex) {
		H = new int[numberOfVertex];
		D = new int[numberOfVertex];

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
		int maxValue = H[0];
		H[0] = H[lastIndex];
		heapifyDown();
		return maxValue;
	}
	
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
	
	public void update(int v, int w) {
		D[v] = w;
		int j;
		for(j=0; j<lastIndex; j++) {
			if(H[j] == v)
				break;
		}
		heapifyUp(j);
	}

	public void heapifyDown() {
		int i = 0;
		int largeChildIndex = 0;
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
		if(H[index] ==0) {
		//	System.out.println("parentBandwidth(index): "+ parentBandwidth(index) + " H[index]: "+H[index]+ " D[]: "+ D[H[index]]);
		}
		while (hasParent(index) && parentBandwidth(index) < D[H[index]]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	public void swap(int pos1, int pos2) {
		int tempVertices = H[pos1];
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

	public  void printH() {
		
		for (int i = 0; i < this.lastIndex; i++) {
			System.out.print(this.H[i] + " ");
		}
		System.out.println();
	}

	public  void printD() {
		System.out.println();
		for (int i = 0; i < this.lastIndex; i++) {
			System.out.print(this.D[i] + " ");
		}
		System.out.println();
	}

}