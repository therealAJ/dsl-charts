package ast;

import java.util.ArrayList;


/**
 * Created by jason on 2018-09-28.
 */
public class BarChartNode extends ChartNode {

    public BarChartNode() {
        chartItems = new ArrayList<>();
    }

    @Override
    public void addData() {
        System.out.println("BarChartNode addData called");
        data.datasets.label = xLabel;
        for (ChartValueNode node: chartItems) {
            data.labels.add(node.name);
            data.datasets.data.add(node.count);
            if (colourSpecified()) {
                data.datasets.bgColours.add(node.colour);
                data.datasets.borderColours.add(node.border);
            }
        }
    }

    @Override
    public void addOptions() {
        System.out.println("BarChartNode addOptions called");
    }

    private Boolean colourSpecified() {
        // TODO: provide our own colours when not defined by the user.
        // TODO: include border colour in our specification?
        return false;
    }


//    Preserving this code snippet to be used in generating chart.js later on

//    @Override
//    public void evaluate() {
//        String snippet = "var ctx" + count + " = document.getElementById(\"chart" + count + "\");\n" +
//                "var myChart" + count + " = new Chart(ctx" + count + ", {\n" +
//                "type: 'bar',\n" +
//                "data: {\n" +
//                "labels: [";
//        writer.println(snippet);
//        // labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
//        for (int i = 0; i < valueNodes.size(); i++) {
//            valueNodes.get(i).evaluate(Constants.BAR_CHART_PROPERTIES.NAME);
//            if (i != valueNodes.size() - 1) {
//                writer.println(",");
//            }
//        }
//    }


}
