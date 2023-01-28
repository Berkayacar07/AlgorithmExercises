We are given a COMPLETE BINARY TREE where nodes and edges have positive weights.  Node weights arestored in a 1-dimensional array WN. Edge weights are stored in a 2-dimensional array WE where 0 denotes noedge.  Starting at the root of the tree and moving to either one of the children from the current node, the goalis to find the minimum total weight (i.e.  sum of node and edge weights) path from the root to any one of the leaves.

![image](https://user-images.githubusercontent.com/86426656/215290049-3a1c3676-529e-4f3c-9196-cd38e4c5085c.png)
Output: Min total weight path includes nodes 0-1-4 with total weight 11

(a) Implement a function that generates complete binary tree (i.e.  two arrays) with given size asinput where the node and edge weights are set randomly between 1 and 20 inclusive.
(b) Implement the greedy strategy (i.e.  write a function) of choosing the child with the smallestsum of edge and node weights each time.
(c) Implement  a  recursive  algorithm  (i.e.   write  a  function)  to  find  the  minimum  total  weight. You must determine the input parameters.
(d) Implement a dynamic programming algorithm to solve the problem.  You must determine theinput parameters.
(e) In your main function:•Show that the greedy algorithm does not solve this problem optimally.
