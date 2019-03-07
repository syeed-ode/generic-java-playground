package com.syeedode.acommonsencetoalgorithmdatastructure.quickselect;

import java.util.Objects;

import static com.syeedode.acommonsencetoalgorithmdatastructure.partitioning.Partitionor.partition;

public class QuickselectService {

    public static class PivotResultSet {

        private int pivotPosition;
        private int pivotValue;
        private int kthLowestValue;

        private PivotResultSet(int pivotPosition, int pivotValue) {
            this.pivotPosition = pivotPosition;
            this.pivotValue = pivotValue;
        }

        private PivotResultSet(int pivotPosition, int pivotValue, int kthLowestValue) {
            this.pivotPosition = pivotPosition;
            this.pivotValue = pivotValue;
            this.kthLowestValue = kthLowestValue;
        }

        public int getPivotPosition() {
            return pivotPosition;
        }

        public int getPivotValue() {
            return pivotValue;
        }

        public int getKthLowestValue() {
            return kthLowestValue;
        }

        @Override
        public String toString() {
            return "PivotResultSet@" + Integer.toHexString(this.hashCode()) + "[pivotPosition: "
                    + pivotPosition
                    + (Objects.isNull(pivotValue) ? "" : (", pivotValue: " + pivotValue))
                    + ((kthLowestValue == 0) ? "" : (", kthLowestValue: " + kthLowestValue))
                    + "]";
        }
    }

    public static PivotResultSet quickselect(Integer [] array, int kth_lowest_value, int leftIndex, int rightIndex) {
        if(rightIndex - leftIndex <= 0) {
            return new PivotResultSet(leftIndex, array[leftIndex], kth_lowest_value);
        }

        int pivotPosition = partition(array, leftIndex, rightIndex);

        if(kth_lowest_value < pivotPosition) {
            return quickselect(array, kth_lowest_value, leftIndex, pivotPosition - 1);
        } else if(kth_lowest_value > pivotPosition) {
            return quickselect(array, kth_lowest_value, pivotPosition + 1, rightIndex);
        } else {
            return new PivotResultSet(pivotPosition, array[pivotPosition], kth_lowest_value);
        }
    }
}
