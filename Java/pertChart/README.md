## PERT Chart
Java Program that will build the graph from the PERT chart and will give us the ways in which we can reach from start to end.

Implemented for following PERT Chart:
![Pert Chart](https://github.com/milan-vishnoi/Practice_Programs/blob/main/Java/pertChart/image.png)


### The output of the program is:
Table:
WorkId:1 time:5 Depends on:[] Child:[2,3,4]
WorkId:2 time:10 Depends on:[1] Child:[5,6]
WorkId:3 time:12 Depends on:[1] Child:[4,6]
WorkId:4 time:10 Depends on:[1,3] Child:[6,7]
WorkId:5 time:10 Depends on:[2] Child:[8]
WorkId:6 time:10 Depends on:[2,3,4] Child:[8,9]
WorkId:7 time:10 Depends on:[4] Child:[9]
WorkId:8 time:10 Depends on:[5,6] Child:[9]
WorkId:9 time:10 Depends on:[6,7,8] Child:[]

Paths:
Path1: 1->2->5->8->9
Path2: 1->2->6->8->9
Path3: 1->2->6->9
Path4: 1->3->4->6->8->9
Path5: 1->3->4->6->9
Path6: 1->3->4->7->9
Path7: 1->3->6->8->9
Path8: 1->3->6->9
Path9: 1->4->6->8->9
Path10: 1->4->6->9
Path11: 1->4->7->9