## PERT Chart
Java Program that will build the graph from the PERT chart and will give us the ways in which we can reach from start to end.

Sample PERT Chart:
![Pert Chart](https://github.com/milan-vishnoi/Practice_Programs/blob/main/Java/pertChart/image.png)


### The Input of the program  for above Chart will:
Enter the number of works:
9
Enter workId & time for work1's:1 10
Enter works on which work1 depends:-1
Enter workId & time for work2's:2 10
Enter works on which work2 depends:1
Enter workId & time for work3's:3 10
Enter works on which work3 depends:1
Enter workId & time for work4's:4 10
Enter works on which work4 depends:1,3
Enter workId & time for work5's:5 10 
Enter works on which work5 depends:2
Enter workId & time for work6's:6 10
Enter works on which work6 depends:2,3,4
Enter workId & time for work7's:7 10
Enter works on which work7 depends:4
Enter workId & time for work8's:8 10 5,6
Enter works on which work8 depends:Enter workId & time for work9's:9 10
Enter works on which work9 depends:6,7,8

### Output
Table:
WorkId:1 time:10 Depends on:[] Child:[2,3,4]
WorkId:2 time:10 Depends on:[1] Child:[5,6]
WorkId:3 time:10 Depends on:[1] Child:[4,6]
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