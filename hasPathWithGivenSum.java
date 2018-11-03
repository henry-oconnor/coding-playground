/*Given a binary tree t and an integer s, 
determine whether there is a root to leaf path 
in t such that the sum of vertex values equals s.

Example

    For

    t = {
        "value": 4,
        "left": {
            "value": 1,
            "left": {
                "value": -2,
                "left": null,
                "right": {
                    "value": 3,
                    "left": null,
                    "right": null
                }
            },
            "right": null
        },
        "right": {
            "value": 3,
            "left": {
                "value": 1,
                "left": null,
                "right": null
            },
            "right": {
                "value": 2,
                "left": {
                    "value": -2,
                    "left": null,
                    "right": null
                },
                "right": {
                    "value": -3,
                    "left": null,
                    "right": null
                }
            }
        }
    }

    and
    s = 7,
    the output should be hasPathWithGivenSum(t, s) = true.

    This is what this tree looks like:

          4
         / \
        1   3
       /   / \
      -2  1   2
        \    / \
         3  -2 -3
*/

//
// Definition for binary tree:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }
boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
    System.out.println("Sum: " + s);
    if(t == null)
        return s == 0;
    if(t.left == null && t.right == null)
        return s - t.value == 0;
    if(t.left == null)
        return hasPathWithGivenSum(t.right, s - t.value);
    if(t.right == null)
        return hasPathWithGivenSum(t.left, s - t.value);
    
    return hasPathWithGivenSum(t.left, s - t.value) ||
            hasPathWithGivenSum(t.right, s - t.value);

}
