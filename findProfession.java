/*
Consider a special family of Engineers and Doctors. This family has the following rules:

    Everybody has two children.
    The first child of an Engineer is an Engineer and the second child is a Doctor.
    The first child of a Doctor is a Doctor and the second child is an Engineer.
    All generations of Doctors and Engineers start with an Engineer.

We can represent the situation using this diagram:

                E
           /         \
          E           D
        /   \        /  \
       E     D      D    E
      / \   / \    / \   / \
     E   D D   E  D   E E   D

Given the level and position of a person in the ancestor tree above, find the profession of the person.
Note: in this tree first child is considered as left child, second - as right.

Example

For level = 3 and pos = 3, the output should be
findProfession(level, pos) = "Doctor".
*/

String findProfession(int level, int pos) {
    boolean guess = true;
    // a node and its left child always have the same
    // value, and left children have odd positions.
    // therefore if you travel up the tree, toggling
    // the value of your guess when current node has
    // an even position, you should get the answer
    while(level > 0){
        guess = (pos % 2 == 0) ? !guess : guess;
        pos = (pos + 1) / 2;
        level--;
    }
    return guess ? "Engineer" : "Doctor";
}
