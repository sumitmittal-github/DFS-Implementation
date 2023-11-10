# Tempo Software technical assignment

<p>A <tt>com.tempo.Hierarchy</tt> stores an arbitrary <em>forest</em> (an ordered collection of ordered trees)
as an array indexed by DFS-order traversal.
A node is represented by a unique ID.
Parent-child relationships are identified by the position in the array and the associated depth.
Tree root has depth 0, immediate children have depth 1, their children have depth 2, etc.
</p>

<p>Depth of the first element is 0. If the depth of a node is D, the depth of the next node in the array can be:</p>
<ul>
  <li>D + 1 if the next node is a child of this node;</li>
  <li>D if the next node is a sibling of this node;</li>
  <li>d < D - in this case the next node is not related to this node.</li>
</ul>

<p>Example:</p>
<code>
nodeIds: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
depths:  0, 1, 2, 3, 1, 0, 1, 0, 1, 1, 2
the forest can be visualized as follows:
1
- 2
- - 3
- - - 4
- 5
6
- 7
8
- 9
- 10
- - 11
</code>
Note that the depth is equal to the number of hyphens for each node.
