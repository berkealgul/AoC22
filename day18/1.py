import numpy as np

with open("./inputs/input18.txt") as f:
    lines = f.readlines()
    cubes = np.ndarray((len(lines), 3), dtype=int)
    i = 0
    for line in lines:
        cube = line.strip().split(',')
        x = int(cube[0])
        y = int(cube[1])
        z = int(cube[2])
        cubes[i] = [x, y, z]
        i += 1

x_max, y_max, z_max = cubes.max(axis=0)
cube_grid = np.zeros((x_max+1, y_max+1, z_max+1), dtype=int)

def fill_grid(c):
    cube_grid[c[0]][c[1]][c[2]] = 1
np.apply_along_axis(fill_grid, axis=1, arr=cubes)

area = 0
x, y, z = cube_grid.shape

adject_offset = [
    [1,0,0],
    [-1,0,0],
    [0,1,0],
    [0,-1,0],
    [0,0,1],
    [0,0,-1],
]

for i in range(x):
    for j in range(y):
        for k in range(z):
            if cube_grid[i][j][k] == 0:
                continue
            adject = 0
            for di, dj, dk in adject_offset:
                a = i + di
                b = j + dj
                c = k + dk
                if a < 0 or a == x or b < 0 or b == y or c < 0 or c == z:
                    continue
                if cube_grid[a][b][c] == 1:
                    adject += 1
            area += 6 - adject

print("Surface area:",area)