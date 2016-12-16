// 리스트 18.5  연관된 필드 없이 게터나 세터 정의하기

class Thermometer {

  var celsius: Float = _

  def fahrenheit = celsius * 9 / 5 + 32
  def fahrenheit_= (f: Float) {
    celsius = (f -32) * 5 / 9
  }
  override def toString = fahrenheit +"F/"+ celsius +"C"
}



// 18.2 재할당 가능한 변수와 속성

val t = new Thermometer
t.celsius = 100
t
t.fahrenheit = -40
t


// 18.4 디지털 회로를 위한 언어

calss Wire

val a = new Wire
val b = new Wire
val c = new Wire

val a, b, c = new Wire

def inverter(input: Wire, output: Wire)
def andGate(a1: Wire, a2: Wire, output: Wire)
def orGate(o1: Wire, o2: Wire, output: Wire)
