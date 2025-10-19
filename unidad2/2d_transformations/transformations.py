import numpy as np
import math

class Transformations:
    def despliega(self, msj, m):
        rens = m.shape[0]
        cols = m.shape[1]
        print("** " + msj + " **")
        for i in range(0, rens):
            for j in range(0, cols):
                print(f"{m[i, j]:8.4f}", end="")
            print("")
        print("-"*33)

    def rotacion(self, ang):
        ang = np.radians(ang)
        return np.matrix([
            [math.cos(ang), math.sin(ang), 0],
            [-math.sin(ang), math.cos(ang), 0],
            [0, 0, 1]
        ])

    def escalacion(self, sx, sy):
        return np.matrix([
            [sx, 0, 0],
            [0, sy, 0],
            [0, 0, 1]
        ])

    def traslacion(self, tx, ty):
        return np.matrix([
            [1, 0, 0],
            [0, 1, 0],
            [tx, ty, 1]
        ])

    def reflexionX(self):
        return np.matrix([
            [1, 0, 0],
            [0, -1, 0],
            [0, 0, 1]
        ])

    def reflexionY(self):
        return np.matrix([
            [-1, 0, 0],
            [0, 1, 0],
            [0, 0, 1]
        ])

    def reflexion45(self):
        return np.matrix([
            [0, 1, 0],
            [1, 0, 0],
            [0, 0, 1]
        ])

    def reflexion135(self):
        return np.matrix([
            [0, -1, 0],
            [-1, 0, 0],
            [0, 0, 1]
        ])

    def identidad(self):
        return np.matrix([
            [1, 0, 0],
            [0, 1, 0],
            [0, 0, 1],
        ])

    def inversa(self, m):
        return np.linalg.inv(m)

    def vector(self, x, y):
        return np.matrix([x, y, 1])
