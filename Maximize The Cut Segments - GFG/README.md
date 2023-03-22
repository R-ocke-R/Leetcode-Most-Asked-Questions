# Maximize The Cut Segments
## Medium
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an integer <strong>N</strong> denoting the Length of a line segment. You need to cut the line segment in such&nbsp;a way that the cut length of a line segment each time is either <strong>x</strong> , <strong>y</strong> or <strong>z</strong>. Here x, y, and z are integers.<br>
After performing&nbsp;all the cut operations, your<strong> total number of cut segments must be maximum</strong>.</span></p>

<p><span style="font-size:18px"><strong>Note</strong>:&nbsp;if no segment can be cut then return 0.</span></p>

<p><strong><span style="font-size:18px">Example 1:</span></strong></p>

<pre style="position: relative;"><strong><span style="font-size:18px">Input:
</span></strong><span style="font-size:18px">N = 4
x = 2, y = 1, z = 1
<strong>Output: </strong>4<strong>
Explanation:</strong>Total length is 4, and the cut
lengths are 2, 1 and 1.&nbsp; We can make
maximum 4 segments each of length 1.</span>
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><strong><span style="font-size:18px">Example 2:</span></strong></p>

<pre style="position: relative;"><strong><span style="font-size:18px">Input:
</span></strong><span style="font-size:18px">N = 5
x = 5, y = 3, z = 2
<strong>Output: </strong>2<strong>
Explanation: </strong>Here total length is 5,&nbsp;and
the cut lengths are 5, 3 and 2. We can
make two segments of lengths 3 and 2.</span><div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You only need to complete the function <strong>maximizeTheCuts()&nbsp;</strong>that takes n, x, y, z as parameters and returns <strong>max number cuts</strong>.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity</strong> : O(N)<br>
<strong>Expected Auxiliary Space</strong>: O(N)</span></p>

<p><span style="font-size:18px"><strong>Constraints</strong><br>
1 &lt;= N, x, y, z &lt;= 10<sup>4</sup></span></p>
</div>