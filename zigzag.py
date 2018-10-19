# A sequence of integers is called a zigzag sequence if 
# each of its elements is either strictly less than all 
# its neighbors or strictly greater than all its neighbors. 
# For example, the sequence 4 2 3 1 5 3 is a zigzag, 
# but 7 3 5 5 2 and 3 8 6 4 5 aren't. Sequence of length 1 
# is also a zigzag.

# For a given array of integers return the length of its 
# longest contiguous sub-array that is a zigzag sequence.

# EXAMPLE

#     For a = [9, 8, 8, 5, 3, 5, 3, 2, 8, 6], the output should be
#     zigzag(a) = 4.

#     The longest zigzag sub-arrays are [5, 3, 5, 3] 
#       and [3, 2, 8, 6] and they both have length 4.

#     For a = [4, 4], the output should be
#     zigzag(a) = 1.

#     The longest zigzag sub-array is [4] - it has only one element,
#     which is strictly greater than all its neighbors (there are 
#     none of them).


def zigzag(a):
    if len(a) < 3:
        return 1
    
    counter = 0
    max = 0
    for i in range(1, len(a) - 1):
        if (a[i] < a[i+1] and a[i] < a[i-1]) or (a[i] > a[i+1] and a[i] > a[i-1]):
            counter += 1
            if counter > max:
                max = counter
        else:
            counter = 0
        
    return max + 2