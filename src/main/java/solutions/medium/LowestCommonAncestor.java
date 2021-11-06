package solutions.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestor {
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        Set<Character> set = new HashSet<>();
        AncestralTree an1 = descendantOne;
        AncestralTree an2 = descendantTwo;
        while(an1 != null) {
            set.add(an1.name);
            an1 = an1.ancestor;
        }
        while(an2 != null) {
            if(set.contains(an2.name)) {
                return an2;
            }
            an2 = an2.ancestor;
        }

        return null;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

}
