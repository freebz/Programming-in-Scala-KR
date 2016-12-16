// 리스트 9.5  이름에 의한 호출 사용

def byNameAssert(predicate: => Boolean) =
  if (assertionEnabled && !predicate)
    throw new AssertionError

byNameAssert(5 > 3)



def boolAssert(predicate: Boolean) =
  if (assertionEnabled && !predicate)
    throw new AssertionError

boolAssert(5 > 3)


var assertionEnabled = false

boolAssert(5 / 0 == 0)
byNameAssert(5 / 0 == 0)
