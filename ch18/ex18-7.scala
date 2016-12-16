// 리스트 18.7  전가산기를 구현한 fullAdder 메소드

def fullAdder(a: Wire, b: Wire, cin: Wire,
  sum: Wire, cout: Wire) {

  val s, c1, c2 = new Wire
  halfAdder(a, cin, s, c1)
  halfAdder(b, s, sum, c2)
  orGate(c1, c2, cout)
}
