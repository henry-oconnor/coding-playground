# Given a matrix (i.e. an array of arrays), find its submatrix 
# obtained by deleting the specified rows and columns.
# EXAMPLE
# For:
# matrix = [[1, 0, 0, 2], 
#           [0, 5, 0, 1], 
#           [0, 0, 3, 5]]
# rowsToDelete = [1], and columnsToDelete = [0, 2], the output should be
# constructSubmatrix(matrix, rowsToDelete, columnsToDelete) = [[0, 2],
#                                                              [0, 5]]

def constructSubmatrix(matrix, rowsToDelete, columnsToDelete):
    deleted = 0
    for i in rowsToDelete:
        del matrix[i - deleted]
        deleted += 1
    
    for col in matrix:
        deleted = 0
        for i in columnsToDelete:
            del col[i - deleted]
            deleted += 1
            
    return matrix