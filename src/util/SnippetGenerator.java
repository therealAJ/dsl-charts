package util;

import ast.ChartNode;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SnippetGenerator {
    PrintWriter writer;
    StringBuilder snippet;
    ChartNode chart;

    public SnippetGenerator(ChartNode chart) {
        this.chart = chart;
        snippet = new StringBuilder();
    }

    /*
        This method is excessively modular in hopes that it will be easier to abstract to other types of charts when
        the time comes.
     */
    public String printSnippet() {
        appendCanvasTag();
        snippet.append("<script>\n");
        appendCTXDefinition();
        appendChartDefinition();
        appendType();
        appendData();
        appendOptions();
        snippet.append("});\n");
        snippet.append("</script>");
        return snippet.toString();
    }

    private void appendCanvasTag() {
        String str ="<canvas id='" + chart.title + "' width='400' height='400'></canvas>\n";
        snippet.append(str);
    }

    private void appendCTXDefinition() {
        snippet.append("var ctx" + chart.ID +
                " = document.getElementById('" + chart.title + "').getContext('2d');\n");
    }

    private void appendChartDefinition() {
        String str = "var " + chart.title + " = new Chart(ctx" + chart.ID + ", {\n";
        snippet.append(str);
    }

    private void appendType() {
        snippet.append("   type: '" + chart.type + "',\n");
    }

    private void appendData() {
        snippet.append(SnippetHelpers.tabs(1) + "data: {\n");
        snippet.append(SnippetHelpers.tabs(2) + "labels: [");
        appendDataLabels();
        appendDatasets();
        snippet.append(SnippetHelpers.tabs(1) + "},\n");
    }

    private void appendDataLabels() {
        String dataLabels = SnippetHelpers.appendArrayItems(chart.data.labels);
        snippet.append(dataLabels);
    }

    private void appendDatasets() {
        snippet.append(SnippetHelpers.tabs(2) + "datasets: [{\n");
        snippet.append(SnippetHelpers.tabs(3) + "label: '" + chart.data.datasets.label + "',\n");
        appendValues();
        appendBackgroundColour();
        appendBorder();
        snippet.append(SnippetHelpers.tabs(3) + "borderWidth: 1\n");
        snippet.append(SnippetHelpers.tabs(2) + "}]\n");
    }

    private void appendValues() {
        snippet.append(SnippetHelpers.tabs(3) + "data: [");
        String values = SnippetHelpers.appendArrayItems(chart.data.datasets.data);
        snippet.append(values);
    }

    // TODO: handling for if colours are or are not provided
    private void appendBackgroundColour() {
        snippet.append(SnippetHelpers.tabs(3) + "backgroundColor: [\n");
        snippet.append(SnippetHelpers.tabs(3) + "],\n");

    }

    private void appendBorder() {
        snippet.append(SnippetHelpers.tabs(3) + "borderColor: [\n");
        snippet.append(SnippetHelpers.tabs(3) + "],\n");
    }


    // TODO: proper handling of more cases where certain options may or may not be specified.
    private void appendOptions() {
        snippet.append(SnippetHelpers.tabs(1) + "options: {\n");
        appendSloppyHardCodedOptions();
        snippet.append(SnippetHelpers.tabs(1) + "}\n");
    }

    private void appendSloppyHardCodedOptions() {
        snippet.append(SnippetHelpers.tabs(2) + "scales: {\n");
        snippet.append(SnippetHelpers.tabs(3) + "yAxes: [{\n");
        snippet.append(SnippetHelpers.tabs(4) + "ticks: {\n");
        snippet.append(SnippetHelpers.tabs(5) + "beginAtZero:true\n");

        // closing tags
        snippet.append(SnippetHelpers.tabs(4) + "}\n");
        snippet.append(SnippetHelpers.tabs(3) + "}]\n");
        snippet.append(SnippetHelpers.tabs(2) + "}\n");
    }





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

    //    public void printGraphs() {
//        writer = new PrintWriter("charts.html", "UTF-8");
//        writer.println(Constants.START_HTML);
//
//        for (GraphNode graph: graphs) {
//            printHtmlCanvas();
//            printChartJsCode();
//        }
//        writer.println(Constants.END_HTML);
//        writer.close();
//    }

//    public void printHtmlCanvas() {
//        for (int i = 0; i < graphs.size(); i++) {
//            writer.println("<canvas id=\"chart" + i + "\" " +
//                    "width=\"400\" height=\"400\"></canvas>");
//        }
//    }
//
//    public void printChartJsCode() throws FileNotFoundException, UnsupportedEncodingException {
//        writer.println("<script>");
//        for (GraphNode g : graphs) {
//            g.evaluate();
//        }
//        writer.println("</script>");
//    }

}