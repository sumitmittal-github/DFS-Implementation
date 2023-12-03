package com.sumit;

import java.util.LinkedList;
import java.util.List;
import java.util.function.IntPredicate;

class Filter {
    /**
     * A node is present in the filtered hierarchy iff its node ID passes the predicate and all of its ancestors pass it as well.
     * */
    public static Hierarchy filter(Hierarchy hierarchy, IntPredicate nodeIdPredicate) {
        List<Integer> outputNodes = new LinkedList<>();
        List<Integer> outputDepths = new LinkedList<>();

        // iterate through DFS tree
        for (int index=0; index < hierarchy.size(); index++) {
            int nodeId = hierarchy.nodeId(index);
            int depth = hierarchy.depth(index);

            // if the predicate is passed then add in the output
            if(nodeIdPredicate.test(nodeId)) {
                outputNodes.add(nodeId);
                outputDepths.add(depth);
            }
            else {
                // discard all its successors and get next non-successor node index
                index = getNonSuccessorNodeIndex(hierarchy, index);
            }
        }
        return new ArrayBasedHierarchy(
                CommonUtils.listToArray(outputNodes),
                CommonUtils.listToArray(outputDepths));
    }

    private static int getNonSuccessorNodeIndex(Hierarchy hierarchy, int index) {
        int successorIndex = index + 1;
        while(successorIndex < hierarchy.size()) {
            if(hierarchy.depth(successorIndex) > hierarchy.depth(index)) {
                ++successorIndex;
            } else {
                break;
            }
        }
        return successorIndex-1;
    }
}
