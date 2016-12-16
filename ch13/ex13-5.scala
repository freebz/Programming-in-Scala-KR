// 리스트 13.5  상위 패키지 안에 있는 기호를 그냥 사용할 수는 없다.

package bobsrockets {
  class Ship
}

package bobsrockets.fleets {
  class Fleet {
    // 컴파일할 수 없다! 이 스코프에는 Ship이 안 들어 있다.
    def addShip() { new Ship }
  }
}
