package util;

import ast.ChartNode;
import ChartAttributes.ChartType;

public class SnippetGenerator {
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
        if (chart.type.equals(ChartType.BAR)) {
            appendBarOptions();
        }
        else if (chart.type.equals(ChartType.PIE)) {
            appendPieOptions();
        }
        snippet.append("});\n");
        snippet.append("</script>");
        return snippet.toString();
    }

    private void appendCanvasTag() {
        snippet.append(SnippetHelpers.DIV_OPEN_TAG);
        String str ="<canvas id='" + chart.title + "'></canvas>\n";
        snippet.append(str);
        snippet.append(SnippetHelpers.DIV_CLOSE_TAG);
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
        snippet.append(SnippetHelpers.tabs(1) + "type: '" + chart.type + "',\n");
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
        snippet.append(SnippetHelpers.tabs(2) + "datasets: [{\n")
        .append(SnippetHelpers.tabs(3) + "label: '" + chart.data.datasets.label + "',\n");
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
    private void appendBarOptions() {
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

    private void appendPieOptions() {
        // stub
    }
}