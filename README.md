# Pathfinding using a variation of A star algorithm

This program finds the shortest path between two points in the cartesian plane, where there can exist obstacles.

The implmentation first draws a Grid, which then turns it to a node map. (each point in the cartesian plane is a unique node). 
Each node is dedicated a value with a number that represents the distance between the node and the goal.
During running time, the distance to each node is calculated. Assuming that we can only step to adjacent 
blocks (8 directions), we know that the distance to the neigbours can either be 1 or 
approximately 1.41 units depending if its diagonal neighbour or not.
With the information about the node and edge, we always choose the lowest value path, and expand that branch, and update 
the edges. Where  we eventually reach the goal. Since we always choose the lowest value path to branch out, when we reached the goal, 
we therefore have the lowest value path, i.e the shortest path to the goal. 

Solving this problem we used a min-heap (priority que in java) to effiecntly acess the lowest value node. 
And a list of visited nodes, so we dont go to nodes that we already determined.



![](a2e3c354fd978020a4a3f439771d5150.gif)

Note for users: Use mouse leftclick to create obstacles, use Mouse right click to remove.  

# Comments about the code 
Coupling is high, and can be reduced by creating an abstract class for the Each marker (goal,player,empty...etc) with abstract methods. The program was firstly designed for only console implmentation, so when i expanded it for a gui implmentation, some unnecessary coupling occured since i just define each Marker as an char value, but now the markers has other attributes as colors and need methods to change colors because of the gui implmentation, therefore it would be ideal to have each marker as it own class. 
