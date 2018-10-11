# dsl-charts
CPSC 410 Project for creating chart visualizations using a domain-specific-language

This project implements a new DSL Language that allows users to make new charts with their data.

A sample chart is made with:

DATASET: apple
ITEMS:
ITEM: THIS, 10, red
ITEM:ISA ,6,blue
ITEM:TEST,7,yellow

GRAPH:Tester
TYPE:Bar
DATA:
apple
LABELS:
X:Items
Y:Values

The EBNF is as follows:

PROGRAM ::= GRAPH*
GRAPH   ::= "Graph:" TITLE TYPE ITEMS LABELS END
TITLE   ::= "Title: " STRING
TYPE    ::= "Type: " CHART-TYPE
CHART-TYPE ::= "Bar" | "Pie"
ITEMS   ::= "[" ITEM* "]"
ITEM    ::= NAME SEP VALUE SEP COLOR? SEP BORDER?
NAME    ::= [*]
VALUE   ::= [0-9]
COLOR   ::= "rgba(" [0-255] SEP [0-255] SEP [0-255] SEP [0-1] ")"
BORDER   ::= "rgba(" [0-255] SEP [0-255] SEP [0-255] SEP [0-1] ")"
LABELS  ::= LABEL LABEL
LABEL   ::= "XName" | "YName" ":" STRING
END     ::= "END"
SEP     ::= ,
