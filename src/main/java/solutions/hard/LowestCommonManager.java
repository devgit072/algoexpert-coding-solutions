package solutions.hard;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonManager {
    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        List<OrgChart> listForOne = new ArrayList<>();
        getOrgChartList(topManager, reportOne.name, listForOne);

        List<OrgChart> listForTwo = new ArrayList<>();
        getOrgChartList(topManager, reportTwo.name, listForTwo);
        int index1 = listForOne.size()-1;
        int index2 = listForTwo.size()-1;
        OrgChart common = null;
        while (index1>=0 && index2>=0) {
            if(listForOne.get(index1).name == listForTwo.get(index2).name) {
                common = listForOne.get(index1);
            } else {
                break;
            }
            index1--;
            index2--;
        }
        return common; // Replace this line.
    }

    private static boolean getOrgChartList(OrgChart node, char targetNode, List<OrgChart> listSoFar) {
        if (node == null) {
            return false;
        }
        if (node.name == targetNode) {
            listSoFar.add(node);
            return true;
        }
        for (OrgChart dr : node.directReports) {
            boolean result = getOrgChartList(dr, targetNode, listSoFar);
            if (result) {
                listSoFar.add(node);
                return true;
            }
        }
        return false;
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }
}
