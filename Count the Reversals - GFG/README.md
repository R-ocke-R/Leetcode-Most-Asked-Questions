# Count the Reversals
## Medium
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a string <strong>S</strong> consisting of only opening and closing curly brackets<strong> '{'</strong> and<strong> '}',</strong>&nbsp;find out the minimum&nbsp;number of reversals required to convert the string into a balanced expression.<br>
A reversal means changing <strong>'{'</strong> to <strong>'}'</strong> or vice-versa.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input:</strong>
S = "}{{}}{{{"
<strong>Output:</strong> 3
<strong>Explanation</strong>: One way to balance is:
"<strong>{</strong>{{}}{<strong>}}</strong>". There is no balanced sequence
that can be formed in lesser reversals.</span>
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><span style="font-size:18px">â€‹<strong>Example 2:</strong></span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input</strong>: 
S = "{{}{{{}{{}}{{"</span><span style="font-size:18px">
<strong>Output:</strong> -1
<strong>Explanation</strong>: There's no way we can balance
this sequence of braces.</span>
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>countRev()&nbsp;</strong>which takes the string S as input parameter&nbsp;and returns the minimum number of reversals required to balance the bracket sequence. If balancing is not possible, return -1.&nbsp;</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(|S|).<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(1).</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ |S| ≤ 10<sup>5</sup></span></p>

<p>&nbsp;</p>
</div>