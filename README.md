# dsl-charts
CPSC 410 Project for creating chart visualizations using a domain-specific-language

This project implements a new DSL Language that allows users to make new charts with their data.

EBNF in grammer.txt

Example usage one:

GRAPH:LineTest
TYPE:Line
DATA:
ITEMS:
ITEM:1,5,red
ITEM:2,6,blue
ITEM:3,5,yellow
LABELS:
X:Items
Y:Values

Example usage with variables:

DATASET:apple1
ITEMS:
ITEM:ItemOne,5,red
ITEM:ItemTwo,6,blue
ITEM:ItemThree,7,yellow

GRAPH:PieTest
TYPE:Pie
DATA:
apple1
LABELS:
X:Items
Y:Values