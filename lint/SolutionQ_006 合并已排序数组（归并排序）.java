package 刷题;

public class Solution {
	/**
	 * @param A:
	 *            sorted integer array A
	 * @param B:
	 *            sorted integer array B
	 * @return: A new sorted integer array
	 * 
	 *          归并排序应用
	 * 
	 * 
	 * 
	 * 
	 *          #include<stdio.h > #include<stdlib.h>
	 * 
	 * 
	 * 
	 * 
	 *          //归并排序 void MSort(int A[], int TmpArray[], int Left, int Right){ int
	 *          Center; if (Left < Right){ Center = (Left + Right) / 2; MSort(A,
	 *          TmpArray, Left, Center); MSort(A, TmpArray, Center + 1, Right); } }
	 *          void MergeSort(int A[], int N){ int* tmpArry; tmpArry =
	 *          malloc(N*sizeof(int)); if (tmpArry != NULL){ MSort(A, tmpArry, 0, N
	 *          - 1); } else{ printf("data error!"); } } void Merge(int A[], int
	 *          tmp[], int Lpos, int Rpos, int RightEnd){ int i, LeftEnd,
	 *          NumElements, TmpPos;
	 * 
	 *          LeftEnd = Rpos - 1; TmpPos = Lpos; NumElements = RightEnd - LeftEnd
	 *          + 1;
	 * 
	 *          while ((Lpos <= LeftEnd) && (Rpos <= RightEnd)){ if (A[Lpos] <=
	 *          A[Rpos]) tmp[TmpPos++] = A[Lpos++]; else tmp[TmpPos++] = A[Rpos++];
	 *          }
	 * 
	 *          while (Lpos <= LeftEnd) tmp[TmpPos++] = A[Lpos++]; while (Rpos <=
	 *          RightEnd) tmp[TmpPos++] = A[Rpos++];
	 * 
	 *          for (i = 0; i < NumElements; i++, RightEnd--) A[RightEnd] =
	 *          tmp[RightEnd]; }
	 *
	 *
	 * 
	 */

	public int[] mergeSortedArray(int[] A, int[] B) {
		int[] tmpArry = new int[A.length + B.length];
		int APos=0,BPos=0,tmpPos=0;
		int AEnd=A.length-1,BEnd=B.length-1,tmpEnd=tmpArry.length-1;
		
		while((APos<=AEnd)&&(BPos<=BEnd)) {
			if(A[APos]<=B[BPos])
				tmpArry[tmpPos++]=A[APos++];
			else
				tmpArry[tmpPos++]=B[BPos++];
		}
		
		
		return tmpArry;

	}
}

class Test {
	public static void main(String[] args) {

	}
}
