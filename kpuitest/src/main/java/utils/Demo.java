package utils;

public class Demo {


    private static int binarySearch0(long[] a, int fromIndex, int toIndex,
                                     long key) {
        int low = fromIndex;//0
        int high = toIndex - 1;//a.length-1

        while (low <= high) {
            int mid = (low + high) >>> 1;//  == /2
            long midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

}
