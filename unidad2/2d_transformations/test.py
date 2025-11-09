from transformations import Transformations

if __name__ == '__main__':
    t = Transformations()
    a = t.vector(-8, 5)
    b = t.vector(-7, 5)
    c = t.vector(-7, 2)
    d = t.vector(-6, 1)
    e = t.vector(-8, 1)

    mt1 = t.traslacion(8, -1)
    mt2 = t.rotacion(-90)
    mt3 = t.reflexionX()
    mt4 = t.escalacion(3, 2)
    mtc = mt1 * mt2 * mt3 * mt4

    ta = a * mtc
    tb = b * mtc
    tc = c * mtc
    td = d * mtc
    te = e * mtc
    t.despliega('', ta)
    t.despliega('', tb)
    t.despliega('', tc)
    t.despliega('', td)
    t.despliega('', te)

