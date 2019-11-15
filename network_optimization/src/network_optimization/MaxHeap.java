package network_optimization;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxHeap {

	int lastIndex = 0;
	int[] H;
	int[] D;

	public MaxHeap(int numberOfVertex) {
		H = new int[numberOfVertex];
		D = new int[numberOfVertex];
		Arrays.fill(D, -1);
		Arrays.fill(H, -1);

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
		return (lastIndex < 0 ? true : false);
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
		return D[H[getLeftChildIndex(index)]];
	}

	private int rightChildBandwidth(int index) {
		return D[H[getRightChildIndex(index)]];
	}

	private int parentBandwidth(int index) {
		return D[H[getParentIndex(index)]];
	}

	public  void printH() {
		System.out.println();
		for (int i = 0; i < 10; i++) {
			System.out.print(this.H[i] + " ");
		}
	}

	public  void printD() {
		System.out.println();
		for (int i = 0; i < 10; i++) {
			System.out.print(this.D[i] + " ");
		}
		System.out.println();
	}

}