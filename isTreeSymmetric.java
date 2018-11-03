// Given a binary tree t, determine whether it is symmetric
// around its center, i.e. each side mirrors the other.

// Example

//     For

//     t = {
//         "value": 1,
//         "left": {
//             "value": 2,
//             "left": {
//                 "value": 3,
//                 "left": null,
//                 "right": null
//             },
//             "right": {
//                 "value": 4,
//                 "left": null,
//                 "right": null
//             }
//         },
//         "right": {
//             "value": 2,
//             "left": {
//                 "value": 4,
//                 "left": null,
//                 "right": null
//             },
//             "right": {
//                 "value": 3,
//                 "left": null,
//                 "right": null
//             }
//         }
//     }

//     the output should be isTreeSymmetric(t) = true.

//     Here's what the tree in this example looks like:

//         1
//        / \
//       2   2
//      / \ / \
//     3  4 4  3



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
boolean isTreeSymmetric(Tree<Integer> t) {
    if(t == null || (t.left == null && t.right == null))
        return true;
    
    Queue<Tree<Integer>> q = new LinkedList<>();
    q.add(t.left);
    q.add(t.right);
    
    while(!q.isEmpty()){
        Tree<Integer> t1 = q.remove();
        Tree<Integer> t2 = q.remove();
        // if both trees are null, check the next two
        if(t1 == null && t2 == null)
            continue;
        // false if only one is null or values don't match
        if((t1 == null || t2 == null) 
           || !t1.value.equals(t2.value))
            return false;
        // add children of t1 and t2 to queue
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    
    return true;
}

