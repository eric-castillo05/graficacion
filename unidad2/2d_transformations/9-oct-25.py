from transformations import Transformations
import numpy as np

if __name__ == '__main__':
    t = Transformations()
    mt1 = t.traslacion(-3, -4)
    mt2 = t.rotacion(30)
    mt3 = t.traslacion(3, 4)
    mtc = mt1 * mt2 * mt3
    t.despliega('', mtc)

    a = t.vector(2, 1)
    b = t.vector(4, 1)
    c = t.vector(3, 4)

    ap = a * mtc
    bp = b * mtc
    cp = c * mtc
    t.despliega('', ap)
    t.despliega('', bp)
    t.despliega('', cp)


    mt1 = t.traslacion(-1, -2)
    me1 = t.escalacion(2, 3)
    mt2 = t.traslacion(1, 2)
    mtc = mt1 * me1 * mt2
    t.despliega('', mtc)

    a = t.vector(1, 1)
    b = t.vector(2, 1)
    c = t.vector(2, 2)
    d = t.vector(1, 2)
    ap = a * mtc
    bp = b * mtc
    cp = c * mtc
    dp = d * mtc
    t.despliega('', ap)
    t.despliega('', bp)
    t.despliega('', cp)
    t.despliega('', dp)


    mt1 = t.traslacion(-1, -1)
    me1 = t.escalacion(1, 2)
    mt2 = t.traslacion(1, -4)
    aToB = mt1 * me1 * mt2
    t.despliega('', aToB)
    a = t.vector(1, 1)
    b = t.vector(4, 1)
    c = t.vector(3, 2)
    d = t.vector(1, 2)

    t.despliega('', a * aToB)
    t.despliega('', b * aToB)
    t.despliega('', c * aToB)
    t.despliega('', d * aToB)

    mba = t.traslacion(-1, 2) * t.escalacion(1/1, 1/2) * t.traslacion(1, 2)
    t.despliega('', mba)

    puntosb = np.matrix([
        [1, -4, 1],
        [4, -4, 1],
        [3, -2, 1],
        [1, -2, 1]
    ])

    puntoa = puntosb * mba


    mrx = t.reflexionX()
    t.despliega('', mrx)
